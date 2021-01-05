package org.ehrbase.fhirbridge.fhir.common.audit;

import org.openehealth.ipf.commons.audit.types.EnumeratedCodedValue;
import org.openehealth.ipf.commons.audit.types.EventType;

@SuppressWarnings("java:S115")
public enum FhirBridgeEventType implements EventType, EnumeratedCodedValue<EventType> {
  FindAuditEvent("fhir-find-audit-event", "Find Audit Event"),

  CreateCondition("fhir-create-condition", "Create Condition"),

  FindCondition("fhir-find-condition", "Find Condition"),

  CreateDiagnosticReport("fhir-create-diagnostic-report", "Create Diagnostic Report"),

  FindDiagnosticReport("fhir-find-diagnostic-report", "Find Diagnostic Report"),

  CreateObservation("fhir-create-observation", "Create Observation"),

  FindObservation("fhir-find-observation", "Find Observation"),

  CreatePatient("fhir-create-patient", "Create Patient"),

  FindPatient("fhir-find-patient", "Find Patient"),

  CreateProcedure("fhir-create-procedure", "Create Procedure"),

  FindProcedure("fhir-find-procedure", "Find Procedure");

  private final EventType value;

  FhirBridgeEventType(String code, String displayName) {
    this.value = EventType.of(code, "FHIR Bridge Transactions", displayName);
  }

  @Override
  public EventType getValue() {
    return value;
  }
}
