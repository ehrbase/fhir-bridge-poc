package org.ehrbase.fhirbridge.camel.component.fhir.procedure;

import org.ehrbase.fhirbridge.fhir.procedure.FindProcedureTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindProcedureComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindProcedureComponent() {
    super(new FindProcedureTransaction());
  }
}
