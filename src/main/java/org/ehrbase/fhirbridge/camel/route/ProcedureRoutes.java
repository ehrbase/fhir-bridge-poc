package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.component.ehr.aql.AqlConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.ehr.converter.ProcedureCompositionConverter;
import org.ehrbase.fhirbridge.ehr.mapper.ProcedureRowMapper;
import org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.ProzedurComposition;
import org.hl7.fhir.r4.model.Procedure;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ProcedureRoutes extends RouteBuilder {

  private final IFhirResourceDao<Procedure> procedureDao;

  private final ResourceProfileValidator requestValidator;

  private final PatientIdProcessor patientIdProcessor;

  private final DefaultExceptionHandler defaultExceptionHandler;

  public ProcedureRoutes(
      IFhirResourceDao<Procedure> procedureDao,
      ResourceProfileValidator requestValidator,
      PatientIdProcessor patientIdProcessor,
      DefaultExceptionHandler defaultExceptionHandler) {
    this.procedureDao = procedureDao;
    this.requestValidator = requestValidator;
    this.patientIdProcessor = patientIdProcessor;
    this.defaultExceptionHandler = defaultExceptionHandler;
  }

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-procedure:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(requestValidator)
        .bean(procedureDao, "create(${body})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process(patientIdProcessor)
        .to(
            "ehr-composition:compositionProducer?operation=mergeCompositionEntity&compositionConverter=#procedureCompositionConverter")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));

    from("fhir-find-procedure:fhirConsumer?fhirContext=#fhirContext")
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .setHeader(
            AqlConstants.AQL_QUERY,
            () ->
                Query.buildNativeQuery(
                    "SELECT c "
                        + "FROM EHR e CONTAINS COMPOSITION c "
                        + "WHERE c/archetype_details/template_id/value = 'Prozedur' "
                        + "AND e/ehr_status/subject/external_ref/id/value = $subjectId",
                    ProzedurComposition.class))
        .to("ehr-aql:aqlProducer?rowMapper=#procedureRowMapper");
    // @formatter:on
  }

  // TODO: Update when Apache Camel > 3.x
  @Bean
  public ProcedureCompositionConverter procedureCompositionConverter() {
    return new ProcedureCompositionConverter();
  }

  @Bean
  public ProcedureRowMapper procedureRowMapper() {
    return new ProcedureRowMapper();
  }
}
