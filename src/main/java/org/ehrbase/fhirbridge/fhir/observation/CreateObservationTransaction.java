package org.ehrbase.fhirbridge.fhir.observation;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;

public class CreateObservationTransaction
    extends FhirTransactionConfiguration<GenericFhirAuditDataset> {

  public CreateObservationTransaction() {
    super(
        "fhir-create-observation",
        "Create Observation",
        false,
        new CreateObservationAuditStrategy(false),
        new CreateObservationAuditStrategy(true),
        FhirVersionEnum.R4,
        new CreateObservationProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
