package org.ehrbase.fhirbridge.fhir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.gclient.ICreateTyped;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

/**
 * Integration tests for {@link org.hl7.fhir.r4.model.QuestionnaireResponse QuestionnaireResponse}
 * resource.
 */
class QuestionnaireResponseIT extends AbstractSetupIT {

  @Test
  void createCovApp() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("QuestionnaireResponse/create-covapp-response.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    MethodOutcome outcome =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID)).execute();

    assertNotNull(outcome.getId());
    assertEquals(true, outcome.getCreated());
  }

  @Test
  void createWrongSubjectId() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("QuestionnaireResponse/create-covapp-response.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, "123456789"));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals("HTTP 422 : EhrId not found for subject '123456789'", exception.getMessage());
  }

  @Test
  void createInvalid() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("QuestionnaireResponse/create-invalid.json").getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : QuestionnaireResponse.status: minimum required = 1, but only found 0 (from http://hl7.org/fhir/StructureDefinition/QuestionnaireResponse)",
        exception.getMessage());
  }
}
