package org.ehrbase.fhirbridge.camel.component.fhir.observation;

import org.ehrbase.fhirbridge.fhir.observation.CreateObservationTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class CreateObservationComponent extends CustomFhirComponent<GenericFhirAuditDataset> {

  public CreateObservationComponent() {
    super(new CreateObservationTransaction());
  }
}
