package org.ehrbase.fhirbridge.camel.component.fhir.patient;

import org.ehrbase.fhirbridge.fhir.patient.FindPatientTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindPatientComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindPatientComponent() {
    super(new FindPatientTransaction());
  }
}
