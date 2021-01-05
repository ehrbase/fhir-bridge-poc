package org.ehrbase.fhirbridge.fhir.condition;

import java.util.Optional;
import org.hl7.fhir.r4.model.Condition;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditStrategy;
import org.openehealth.ipf.commons.ihe.fhir.support.OperationOutcomeOperations;

public class CreateConditionAuditStrategy extends GenericFhirAuditStrategy<Condition> {

  public CreateConditionAuditStrategy(boolean serverSide) {
    super(
        serverSide,
        OperationOutcomeOperations.INSTANCE,
        condition -> Optional.of(condition.getSubject()));
  }
}
