package org.ehrbase.fhirbridge.camel.component.fhir.patient;

import org.ehrbase.fhirbridge.fhir.patient.CreatePatientTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class CreatePatientComponent extends CustomFhirComponent<GenericFhirAuditDataset> {

  public CreatePatientComponent() {
    super(new CreatePatientTransaction());
  }
}
