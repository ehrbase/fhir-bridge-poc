package org.ehrbase.fhirbridge.fhir.diagnosticreport;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.FhirQueryAuditDataset;

public class FindDiagnosticReportTransaction
    extends FhirTransactionConfiguration<FhirQueryAuditDataset> {

  public FindDiagnosticReportTransaction() {
    super(
        "fhir-find-diagnostic-report",
        "Find Diagnostic Report",
        true,
        new FindDiagnosticReportAuditStrategy(false),
        new FindDiagnosticReportAuditStrategy(true),
        FhirVersionEnum.R4,
        new FindDiagnosticReportProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
