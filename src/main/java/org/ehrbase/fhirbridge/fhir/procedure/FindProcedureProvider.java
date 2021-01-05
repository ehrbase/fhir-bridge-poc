package org.ehrbase.fhirbridge.fhir.procedure;

import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.ReferenceParam;
import ca.uhn.fhir.rest.param.TokenParam;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class FindProcedureProvider extends AbstractPlainProvider {

  @Search
  public List<Procedure> search(
      @RequiredParam(
              name = Procedure.SP_SUBJECT,
              chainWhitelist = {Patient.SP_IDENTIFIER})
          ReferenceParam subject,
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {
    List<ParameterValue<?>> parameters = new ArrayList<>();

    String chain = subject.getChain();
    if (Patient.SP_IDENTIFIER.equals(chain)) {
      TokenParam tokenSubject = subject.toTokenParam(getFhirContext());
      parameters.add(new ParameterValue<>("subject", tokenSubject.getValue()));
    }

    return this.requestBundle(
        parameters,
        null,
        ResourceType.Procedure.name(),
        httpServletRequest,
        httpServletResponse,
        requestDetails);
  }
}
