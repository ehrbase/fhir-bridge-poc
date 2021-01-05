package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.ehr.converter.CompositionConverterResolver;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.stereotype.Component;

@Component
public class ObservationRoutes extends RouteBuilder {

  private final IFhirResourceDao<Observation> observationDao;

  private final ResourceProfileValidator requestValidator;

  private final PatientIdProcessor patientIdProcessor;

  private final CompositionConverterResolver compositionConverterResolver;

  private final DefaultExceptionHandler defaultExceptionHandler;

  public ObservationRoutes(
      IFhirResourceDao<Observation> observationDao,
      ResourceProfileValidator requestValidator,
      PatientIdProcessor patientIdProcessor,
      CompositionConverterResolver compositionConverterResolver,
      DefaultExceptionHandler defaultExceptionHandler) {
    this.observationDao = observationDao;
    this.requestValidator = requestValidator;
    this.patientIdProcessor = patientIdProcessor;
    this.compositionConverterResolver = compositionConverterResolver;
    this.defaultExceptionHandler = defaultExceptionHandler;
  }

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-observation:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process(defaultExceptionHandler)
        .end()
        .process(requestValidator)
        .bean(observationDao, "create(${body}, ${null}, ${header.FhirRequestDetails})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process(patientIdProcessor)
        .setHeader(
            CompositionConstants.COMPOSITION_CONVERTER,
            method(compositionConverterResolver, "resolve(${header.CamelFhirBridgeProfile})"))
        .to("ehr-composition:compositionProducer?operation=mergeCompositionEntity")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));
    // @formatter:on
  }
}
