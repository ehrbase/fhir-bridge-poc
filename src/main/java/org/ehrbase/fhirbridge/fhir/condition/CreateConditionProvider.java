package org.ehrbase.fhirbridge.fhir.condition;

import ca.uhn.fhir.rest.annotation.Create;
import ca.uhn.fhir.rest.annotation.ResourceParam;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hl7.fhir.r4.model.Condition;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class CreateConditionProvider extends AbstractPlainProvider {

  @Create
  public MethodOutcome create(
      @ResourceParam Condition condition,
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    return requestAction(condition, null, httpServletRequest, httpServletResponse, requestDetails);
  }
}
