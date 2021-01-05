package org.ehrbase.fhirbridge.fhir.auditevent;

import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.model.api.Include;
import ca.uhn.fhir.rest.annotation.IncludeParam;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.RequiredParam;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.annotation.Sort;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ReferenceParam;
import ca.uhn.fhir.rest.param.TokenAndListParam;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hl7.fhir.r4.model.AuditEvent;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

public class FindAuditEventProvider extends AbstractPlainProvider {

  @Search(type = AuditEvent.class)
  @SuppressWarnings("java:S107")
  public IBundleProvider search(
      @RequiredParam(name = AuditEvent.SP_DATE) DateRangeParam interval,
      @OptionalParam(name = AuditEvent.SP_ENTITY) ReferenceParam entity,
      @OptionalParam(name = AuditEvent.SP_OUTCOME) TokenAndListParam outcome,
      //            @OptionalParam(name = AuditEvent.SP_ADDRESS) StringAndListParam address,
      //            @OptionalParam(name = AuditEvent.SP_AGENT) ReferenceParam agent,
      //            @OptionalParam(name = AuditEvent.SP_PATIENT + ".identifier") TokenAndListParam
      // patientId,
      //            @OptionalParam(name = AuditEvent.SP_ENTITY_TYPE) TokenAndListParam entityType,
      //            @OptionalParam(name = AuditEvent.SP_ENTITY_ROLE) TokenAndListParam entityRole,
      //            @OptionalParam(name = AuditEvent.SP_SOURCE) ReferenceParam source,
      //            @OptionalParam(name = AuditEvent.SP_TYPE) TokenAndListParam type,
      //            @OptionalParam(name = AuditEvent.SP_SUBTYPE) TokenAndListParam subtype,
      @Sort SortSpec sort,
      @IncludeParam Set<Include> includes,
      RequestDetails requestDetails,
      HttpServletRequest httpServletRequest,
      HttpServletResponse httpServletResponse) {

    SearchParameterMap searchParameters = new SearchParameterMap();
    searchParameters.add(AuditEvent.SP_DATE, interval);
    searchParameters.add(AuditEvent.SP_ENTITY, entity);
    searchParameters.add(AuditEvent.SP_OUTCOME, outcome);
    searchParameters.setSort(sort);
    searchParameters.setIncludes(includes);

    return requestBundleProvider(
        searchParameters,
        null,
        ResourceType.AuditEvent.name(),
        httpServletRequest,
        httpServletResponse,
        requestDetails);
  }
}
