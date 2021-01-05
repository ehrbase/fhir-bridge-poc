package org.ehrbase.fhirbridge.camel.component.fhir.observation;

import org.ehrbase.fhirbridge.fhir.observation.FindObservationTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindObservationComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindObservationComponent() {
    super(new FindObservationTransaction());
  }
}
