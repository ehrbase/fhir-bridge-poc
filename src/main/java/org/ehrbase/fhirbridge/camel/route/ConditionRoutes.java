package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import java.util.Map;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.component.ehr.aql.AqlConstants;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.ehr.converter.CompositionConverterResolver;
import org.ehrbase.fhirbridge.ehr.mapper.DiagnoseRowMapper;
import org.ehrbase.fhirbridge.ehr.opt.diagnosecomposition.DiagnoseComposition;
import org.hl7.fhir.r4.model.Condition;
import org.springframework.stereotype.Component;

@Component
public class ConditionRoutes extends RouteBuilder {

  private final IFhirResourceDao<Condition> conditionDao;

  private final ResourceProfileValidator requestValidator;

  private final PatientIdProcessor patientIdProcessor;

  private final CompositionConverterResolver compositionConverterResolver;

  private final DefaultExceptionHandler defaultExceptionHandler;

  public ConditionRoutes(
      IFhirResourceDao<Condition> conditionDao,
      ResourceProfileValidator requestValidator,
      PatientIdProcessor patientIdProcessor,
      CompositionConverterResolver compositionConverterResolver,
      DefaultExceptionHandler defaultExceptionHandler) {

    this.conditionDao = conditionDao;
    this.requestValidator = requestValidator;
    this.patientIdProcessor = patientIdProcessor;
    this.compositionConverterResolver = compositionConverterResolver;
    this.defaultExceptionHandler = defaultExceptionHandler;
  }

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-condition:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(requestValidator)
        .bean(conditionDao, "create(${body})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process(patientIdProcessor)
        .setHeader(
            CompositionConstants.COMPOSITION_CONVERTER,
            method(compositionConverterResolver, "resolve(${header.CamelFhirBridgeProfile})"))
        .to("ehr-composition:compositionProducer?operation=mergeCompositionEntity")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));

    from("fhir-find-condition:fhirConsumer?fhirContext=#fhirContext")
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(buildAqlQuery())
        .setHeader(AqlConstants.ROW_MAPPER, constant(new DiagnoseRowMapper()))
        .to("ehr-aql:aqlProducer");
    // @formatter:on
  }

  @SuppressWarnings("unchecked")
  private Processor buildAqlQuery() {
    return exchange -> {
      // @formatter:off
      String aql =
          "SELECT c "
              + "FROM EHR e "
              + "CONTAINS COMPOSITION c "
              + "CONTAINS EVALUATION eval[openEHR-EHR-EVALUATION.problem_diagnosis.v1] "
              + "WHERE c/archetype_details/template_id/value = 'Diagnose' "
              + "AND e/ehr_status/subject/external_ref/id/value = $subjectId";
      // @formatter:on

      Map<String, ParameterValue<?>> parameters = exchange.getIn().getBody(Map.class);

      if (parameters.get("startTimeFrom") != null) {
        aql += " AND c/context/start_time/value >= $startTimeFrom";
      }
      if (parameters.get("startTimeTo") != null) {
        aql += " AND c/context/start_time/value <= $startTimeTo";
      }
      if (parameters.get("code") != null) {
        aql += " AND eval/data[at0001]/items[at0002]/value/defining_code/code_string = $code";
      }

      exchange
          .getMessage()
          .setHeader(
              AqlConstants.AQL_QUERY, Query.buildNativeQuery(aql, DiagnoseComposition.class));
      exchange.getMessage().setBody(parameters.values());
    };
  }
}
