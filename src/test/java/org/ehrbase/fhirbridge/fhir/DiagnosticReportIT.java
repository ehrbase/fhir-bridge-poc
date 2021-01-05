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
 * Integration tests for {@link org.hl7.fhir.r4.model.DiagnosticReport DiagnosticReport} resource.
 */
class DiagnosticReportIT extends AbstractSetupIT {

  @Test
  void create() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("DiagnosticReport/create-diagnosticReport.json").getInputStream(),
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
            new ClassPathResource(
                    "DiagnosticReport/create-diagnosticReport-with-default-profile.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : Default profile is not supported for DiagnosticReport. One of the following profiles is expected: "
            + "[https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab]",
        exception.getMessage());
  }

  @Test
  void createWithInvalidCode() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("DiagnosticReport/create-diagnosticReport-with-invalid-code.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals(
        "HTTP 422 : This element does not match any known slice defined in the profile https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab",
        exception.getMessage());
  }
}
