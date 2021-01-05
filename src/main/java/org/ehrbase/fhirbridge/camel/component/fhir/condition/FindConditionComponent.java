package org.ehrbase.fhirbridge.camel.component.fhir.condition;

import org.ehrbase.fhirbridge.fhir.condition.FindConditionTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindConditionComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindConditionComponent() {
    super(new FindConditionTransaction());
  }
}
