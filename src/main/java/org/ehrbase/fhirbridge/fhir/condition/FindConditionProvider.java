package org.ehrbase.fhirbridge.fhir.condition;

import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ReferenceParam;
import ca.uhn.fhir.rest.param.TokenParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class FindConditionProvider extends AbstractPlainProvider {

  @Search
  public List<Condition> search(
      @RequiredParam(
              name = Condition.SP_SUBJECT,
              chainWhitelist = {Patient.SP_IDENTIFIER})
          ReferenceParam subject,
      @OptionalParam(name = Condition.SP_RECORDED_DATE) DateRangeParam recordedDate,
      @OptionalParam(name = Condition.SP_CODE) TokenParam code,
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {

    Map<String, ParameterValue<?>> parameters = new HashMap<>();

    String chain = subject.getChain();
    if (Patient.SP_IDENTIFIER.equals(chain)) {
      TokenParam tokenSubject = subject.toTokenParam(getFhirContext());
      parameters.put("subjectId", new ParameterValue<>("subjectId", tokenSubject.getValue()));
    }
    if (recordedDate != null) {
      if (recordedDate.getLowerBound() != null) {
        parameters.put(
            "startTimeFrom",
            new ParameterValue<>("startTimeFrom", recordedDate.getLowerBound().getValueAsString()));
      }
      if (recordedDate.getUpperBound() != null) {
        parameters.put(
            "startTimeTo",
            new ParameterValue<>("startTimeTo", recordedDate.getUpperBound().getValueAsString()));
      }
    }
    if (code != null) {
      parameters.put("code", new ParameterValue<>("code", code.getValue()));
    }

    return this.requestBundle(
        parameters,
        null,
        ResourceType.Condition.name(),
        httpServletRequest,
        httpServletResponse,
        requestDetails);
  }
}
