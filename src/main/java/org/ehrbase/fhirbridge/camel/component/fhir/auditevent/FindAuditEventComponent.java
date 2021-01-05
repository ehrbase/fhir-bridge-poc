package org.ehrbase.fhirbridge.camel.component.fhir.auditevent;

import org.ehrbase.fhirbridge.fhir.auditevent.FindAuditEventTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindAuditEventComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindAuditEventComponent() {
    super(new FindAuditEventTransaction());
  }
}
