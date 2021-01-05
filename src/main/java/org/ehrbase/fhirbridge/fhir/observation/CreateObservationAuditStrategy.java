package org.ehrbase.fhirbridge.fhir.observation;

import java.util.Optional;
import org.hl7.fhir.r4.model.Observation;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditStrategy;
import org.openehealth.ipf.commons.ihe.fhir.support.OperationOutcomeOperations;

public class CreateObservationAuditStrategy extends GenericFhirAuditStrategy<Observation> {

  public CreateObservationAuditStrategy(boolean serverSide) {
    super(
        serverSide,
        OperationOutcomeOperations.INSTANCE,
        observation -> Optional.of(observation.getSubject()));
  }
}
