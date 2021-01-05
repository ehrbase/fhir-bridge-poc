package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.ehr.converter.DiagnosticReportLabCompositionConverter;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticReportRoutes extends RouteBuilder {

  private final IFhirResourceDao<DiagnosticReport> diagnosticReportDao;

  private final ResourceProfileValidator requestValidator;

  private final PatientIdProcessor patientIdProcessor;

  private final DefaultExceptionHandler defaultExceptionHandler;

  public DiagnosticReportRoutes(
      IFhirResourceDao<DiagnosticReport> diagnosticReportDao,
      ResourceProfileValidator requestValidator,
      PatientIdProcessor patientIdProcessor,
      DefaultExceptionHandler defaultExceptionHandler) {
    this.diagnosticReportDao = diagnosticReportDao;
    this.requestValidator = requestValidator;
    this.patientIdProcessor = patientIdProcessor;
    this.defaultExceptionHandler = defaultExceptionHandler;
  }

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-diagnostic-report:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(requestValidator)
        .bean(diagnosticReportDao, "create(${body})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process(patientIdProcessor)
        .to(
            "ehr-composition:compositionProducer?operation=mergeCompositionEntity&compositionConverter=#diagnosticReportLabCompositionConverter")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));
    // @formatter:on
  }

  // TODO: Update when Apache Camel > 3.x
  @Bean
  public DiagnosticReportLabCompositionConverter diagnosticReportLabCompositionConverter() {
    return new DiagnosticReportLabCompositionConverter();
  }
}
