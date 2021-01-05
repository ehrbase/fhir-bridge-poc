package org.ehrbase.fhirbridge.fhir.condition;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;

public class CreateConditionTransaction
    extends FhirTransactionConfiguration<GenericFhirAuditDataset> {

  public CreateConditionTransaction() {
    super(
        "fhir-create-condition",
        "Create Condition",
        false,
        new CreateConditionAuditStrategy(false),
        new CreateConditionAuditStrategy(true),
        FhirVersionEnum.R4,
        new CreateConditionProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
