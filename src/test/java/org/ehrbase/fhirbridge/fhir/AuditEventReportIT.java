package org.ehrbase.fhirbridge.fhir;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ca.uhn.fhir.rest.api.MethodOutcome;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.hl7.fhir.r4.model.AuditEvent;
import org.hl7.fhir.r4.model.Bundle;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

/** Integration tests for {@link org.hl7.fhir.r4.model.AuditEvent AuditEvent} resource. */
class AuditEventReportIT extends AbstractSetupIT {

  @Test
  void createResourceAndSearchAuditEvent() throws IOException {
    Date now = new Date();
    String resource =
        IOUtils.toString(
            new ClassPathResource("DiagnosticReport/create-diagnosticReport.json").getInputStream(),
            StandardCharsets.UTF_8);
    MethodOutcome outcome =
        client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID)).execute();

    assertNotNull(outcome.getId());
    assertEquals(true, outcome.getCreated());

    Bundle bundle =
        client
            .search()
            .forResource(AuditEvent.class)
            .where(AuditEvent.DATE.afterOrEquals().day(now))
            .and(AuditEvent.ENTITY.hasId(outcome.getResource().getIdElement()))
            .returnBundle(Bundle.class)
            .execute();

    assertNotNull(bundle);
    assertEquals(1, bundle.getTotal());

    AuditEvent auditEvent = (AuditEvent) bundle.getEntryFirstRep().getResource();
    assertEquals(AuditEvent.AuditEventOutcome._0, auditEvent.getOutcome());
    assertEquals(
        outcome.getResource().getIdElement(),
        auditEvent.getEntity().get(0).getWhat().getReferenceElement());
  }
}
