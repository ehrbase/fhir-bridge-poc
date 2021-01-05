package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

public class FindProcedureTransaction extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

  public FindProcedureTransaction() {
    super(
        "fhir-find-procedure",
        "Find Procedure",
        true,
        new FindProcedureAuditStrategy(false),
        new FindProcedureAuditStrategy(true),
        FhirVersionEnum.R4,
        new FindProcedureProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
