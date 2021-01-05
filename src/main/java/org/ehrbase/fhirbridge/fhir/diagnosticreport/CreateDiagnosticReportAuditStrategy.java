package org.ehrbase.fhirbridge.fhir.diagnosticreport;

import java.util.Optional;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditStrategy;
import org.openehealth.ipf.commons.ihe.fhir.support.OperationOutcomeOperations;

public class CreateDiagnosticReportAuditStrategy
    extends GenericFhirAuditStrategy<DiagnosticReport> {

  public CreateDiagnosticReportAuditStrategy(boolean serverSide) {
    super(
        serverSide,
        OperationOutcomeOperations.INSTANCE,
        diagnosticReport -> Optional.of(diagnosticReport.getSubject()));
  }
}
