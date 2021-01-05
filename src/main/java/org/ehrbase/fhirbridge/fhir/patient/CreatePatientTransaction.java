package org.ehrbase.fhirbridge.fhir.patient;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;

public class CreatePatientTransaction
    extends FhirTransactionConfiguration<GenericFhirAuditDataset> {

  public CreatePatientTransaction() {
    super(
        "fhir-create-patient",
        "Create Patient",
        false,
        new CreatePatientAuditStrategy(false),
        new CreatePatientAuditStrategy(true),
        FhirVersionEnum.R4,
        new CreatePatientProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
