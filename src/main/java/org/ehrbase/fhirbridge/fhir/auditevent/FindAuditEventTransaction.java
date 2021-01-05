package org.ehrbase.fhirbridge.fhir.auditevent;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

public class FindAuditEventTransaction extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

  public FindAuditEventTransaction() {
    super(
        "fhir-find-audit-event",
        "Find Audit Event",
        true,
        new FindAuditEventAuditStrategy(false),
        new FindAuditEventAuditStrategy(true),
        FhirVersionEnum.R4,
        new FindAuditEventProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
