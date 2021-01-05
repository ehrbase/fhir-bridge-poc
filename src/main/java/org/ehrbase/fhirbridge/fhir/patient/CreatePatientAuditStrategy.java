package org.ehrbase.fhirbridge.fhir.patient;

import java.util.Optional;
import org.hl7.fhir.r4.model.Patient;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditStrategy;
import org.openehealth.ipf.commons.ihe.fhir.support.OperationOutcomeOperations;

public class CreatePatientAuditStrategy extends GenericFhirAuditStrategy<Patient> {

  public CreatePatientAuditStrategy(boolean serverSide) {
    super(serverSide, OperationOutcomeOperations.INSTANCE, patient -> Optional.empty());
  }
}
