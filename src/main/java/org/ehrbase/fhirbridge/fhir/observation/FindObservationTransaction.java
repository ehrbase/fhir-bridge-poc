package org.ehrbase.fhirbridge.fhir.observation;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

public class FindObservationTransaction
    extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

  public FindObservationTransaction() {
    super(
        "fhir-find-observation",
        "Find Observation",
        true,
        new FindObservationAuditStrategy(false),
        new FindObservationAuditStrategy(true),
        FhirVersionEnum.R4,
        new FindObservationProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
