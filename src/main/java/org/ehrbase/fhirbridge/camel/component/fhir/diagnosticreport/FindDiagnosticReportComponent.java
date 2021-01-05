package org.ehrbase.fhirbridge.camel.component.fhir.diagnosticreport;

import org.ehrbase.fhirbridge.fhir.diagnosticreport.FindDiagnosticReportTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class FindDiagnosticReportComponent extends CustomFhirComponent<FhirQueryAuditDataset> {

  public FindDiagnosticReportComponent() {
    super(new FindDiagnosticReportTransaction());
  }
}
