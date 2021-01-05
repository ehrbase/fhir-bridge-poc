package org.ehrbase.fhirbridge.fhir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.gclient.ICreateTyped;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

/** Integration tests for {@link org.hl7.fhir.r4.model.Condition Condition} resource. */
class ConditionIT extends AbstractSetupIT {

  @Test
  void createDefault() throws IOException {
    create("Condition/create-condition-default.json");
  }

  @Test
  void createWithInvalidSubject() throws IOException {
    String resource =
        IOUtils.toString(
            new ClassPathResource("Condition/create-condition-with-invalid-subject.json")
                .getInputStream(),
            StandardCharsets.UTF_8);
    ICreateTyped createTyped = client.create().resource(resource);
    Exception exception =
        Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

    assertEquals("HTTP 422 : Subject identifier is required", exception.getMessage());
  }

  @Test
  void createSymptomCovidAbsent() throws IOException {
    create("Condition/create-symptoms-covid-19-absent.json");
  }

  @Test
  void createSymptomCovidPresent() throws IOException {
    create("Condition/create-symptoms-covid-19-present.json");
  }

  @Test
  void createSymptomCovidUnknown() throws IOException {
    create("Condition/create-symptoms-covid-19-unknown.json");
  }

  @Test
  void searchBySubject() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(Patient.IDENTIFIER.exactly().code(PATIENT_ID)))
            .returnBundle(Bundle.class)
            .execute();

    assertTrue(bundle.getTotal() >= 1);
  }

  @Test
  void searchByInvalidSubject() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(
                    Patient.IDENTIFIER.exactly().code("123456789")))
            .returnBundle(Bundle.class)
            .execute();

    assertEquals(0, bundle.getTotal());
  }

  @Test
  void searchBySubjectAndCode() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(Patient.IDENTIFIER.exactly().code(PATIENT_ID)))
            .and(Condition.CODE.exactly().code("B97.2"))
            .returnBundle(Bundle.class)
            .execute();

    assertTrue(bundle.getTotal() >= 1);
  }

  @Test
  void searchBySubjectAndInvalidCode() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(Patient.IDENTIFIER.exactly().code(PATIENT_ID)))
            .and(Condition.CODE.exactly().code("AAA"))
            .returnBundle(Bundle.class)
            .execute();

    assertEquals(0, bundle.getTotal());
  }

  @Test
  void searchBySubjectAndStartTime() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(Patient.IDENTIFIER.exactly().code(PATIENT_ID)))
            .and(Condition.RECORDED_DATE.afterOrEquals().day("2012-05-23"))
            .and(Condition.RECORDED_DATE.before().day("2012-05-25"))
            .returnBundle(Bundle.class)
            .execute();

    assertTrue(bundle.getTotal() >= 1);
  }

  @Test
  void searchBySubjectAndInvalidStartTime() throws IOException {
    createDefault();

    Bundle bundle =
        client
            .search()
            .forResource(Condition.class)
            .where(
                Condition.SUBJECT.hasChainedProperty(Patient.IDENTIFIER.exactly().code(PATIENT_ID)))
            .and(Condition.RECORDED_DATE.after().day(new Date()))
            .returnBundle(Bundle.class)
            .execute();

    assertEquals(0, bundle.getTotal());
  }

  private void create(String path) throws IOException {
    String resource =
        IOUtils.toString(new ClassPathResource(path).getInputStream(), StandardCharsets.UTF_8);
    MethodOutcome outcome =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID)).execute();

    assertNotNull(outcome.getId());
    assertEquals(true, outcome.getCreated());
  }
}
