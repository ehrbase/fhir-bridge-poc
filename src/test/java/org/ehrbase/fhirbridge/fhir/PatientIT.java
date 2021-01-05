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

/** Integration tests for {@link org.hl7.fhir.r4.model.Patient Patient} resource. */
class PatientIT extends AbstractSetupIT {

  @Test
  void create() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Patient/create-patient.json").getInputStream(),
            StandardCharsets.UTF_8);
    MethodOutcome outcome =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID)).execute();

    assertNotNull(outcome.getId());
    assertEquals(true, outcome.getCreated());
  }

  @Test
  void createInvalid() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Patient/create-patient-invalid.json").getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : Extension.extension:dateTimeOfDocumentation: minimum required = 1, but only found 0 (from https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/age)",
        exception.getMessage());
  }

  @Test
  void createWithDefaultProfile() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Patient/create-patient-with-default-profile.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : Default profile is not supported for Patient. One of the following profiles is expected: "
            + "[https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/Patient]",
        exception.getMessage());
  }
}
