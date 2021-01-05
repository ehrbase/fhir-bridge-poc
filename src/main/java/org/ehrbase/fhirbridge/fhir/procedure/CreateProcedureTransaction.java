package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;

public class CreateProcedureTransaction
    extends FhirTransactionConfiguration<GenericFhirAuditDataset> {

  public CreateProcedureTransaction() {
    super(
        "fhir-create-procedure",
        "Create Procedure",
        false,
        new CreateProcedureAuditStrategy(false),
        new CreateProcedureAuditStrategy(true),
        FhirVersionEnum.R4,
        new CreateProcedureProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
