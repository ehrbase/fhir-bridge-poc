package org.ehrbase.fhirbridge.fhir.diagnosticreport;

import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class FindDiagnosticReportProvider extends AbstractPlainProvider {

  @Search
  public List<Procedure> search(
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    return this.requestBundle(
        null,
        null,
        ResourceType.DiagnosticReport.name(),
        httpServletRequest,
        httpServletResponse,
        requestDetails);
  }
}
