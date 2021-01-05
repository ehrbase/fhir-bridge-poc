package org.ehrbase.fhirbridge.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.springframework.stereotype.Component;

@Component
public class QuestionnaireResponseRoutes extends RouteBuilder {

  @Override
  public void configure() {
    // @formatter:off
    from("fhir-create-questionnaire-response:fhirConsumer?fhirContext=#fhirContext")
        .onCompletion()
        .process("auditCreateResourceProcessor")
        .end()
        .onException(Exception.class)
        .process("defaultExceptionHandler")
        .end()
        .bean("myQuestionnaireResponseDaoR4", "create(${body})")
        .setHeader(FhirBridgeConstants.METHOD_OUTCOME, body())
        .setBody(simple("${body.resource}"))
        .process("patientIdProcessor")
        .setBody(header(FhirBridgeConstants.METHOD_OUTCOME));
    // @formatter:on
  }
}
