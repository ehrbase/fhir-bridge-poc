package org.ehrbase.fhirbridge.fhir.patient;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

public class FindPatientTransaction extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

  public FindPatientTransaction() {
    super(
        "fhir-find-patient",
        "Find Patient",
        true,
        new FindPatientAuditStrategy(false),
        new FindPatientAuditStrategy(true),
        FhirVersionEnum.R4,
        new FindPatientProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
