package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.rest.annotation.Create;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hl7.fhir.r4.model.Procedure;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class CreateProcedureProvider extends AbstractPlainProvider {

  @Create
  public MethodOutcome create(
      @ResourceParam Procedure procedure,
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    return requestAction(procedure, null, httpServletRequest, httpServletResponse, requestDetails);
  }
}
