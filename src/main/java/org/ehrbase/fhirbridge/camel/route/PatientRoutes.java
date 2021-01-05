package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.stereotype.Component;

@Component
public class PatientRoutes extends RouteBuilder {

  private final IFhirResourceDao<Patient> patientDao;

  private final ResourceProfileValidator requestValidator;

  private final PatientIdProcessor patientIdProcessor;

  private final DefaultExceptionHandler defaultExceptionHandler;

  public PatientRoutes(
      IFhirResourceDao<Patient> patientDao,
      ResourceProfileValidator requestValidator,
      PatientIdProcessor patientIdProcessor,
      DefaultExceptionHandler defaultExceptionHandler) {
    this.patientDao = patientDao;
    this.requestValidator = requestValidator;
    this.patientIdProcessor = patientIdProcessor;
    this.defaultExceptionHandler = defaultExceptionHandler;
  }

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-patient:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(requestValidator)
        .bean(patientDao, "create(${body})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process(patientIdProcessor)
        //            .to("ehr-composition:compositionProducer?operation=mergeCompositionEntity")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));
    // @formatter:on
  }
}
