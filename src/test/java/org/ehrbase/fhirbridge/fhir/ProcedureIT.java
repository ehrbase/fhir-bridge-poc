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

/** Integration tests for {@link org.hl7.fhir.r4.model.Procedure Procedure} resource. */
class ProcedureIT extends AbstractSetupIT {

  @Test
  void create() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Procedure/create-procedure.json").getInputStream(),
            StandardCharsets.UTF_8);
    MethodOutcome outcome =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID)).execute();

    assertNotNull(outcome.getId());
    assertEquals(true, outcome.getCreated());
  }

  @Test
  void createWithDefaultProfile() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Procedure/create-procedure-with-default-profile.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : Default profile is not supported for Procedure. One of the following profiles is expected: "
            + "[https://www.medizininformatik-initiative.de/fhir/core/modul-prozedur/StructureDefinition/Procedure]",
        exception.getMessage());
  }

  @Test
  void createWithNonExistingSubject() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Procedure/create-procedure-with-non-existing-subject.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals("HTTP 422 : EhrId not found for subject '123456789'", exception.getMessage());
  }
}
