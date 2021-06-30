/*
 * Copyright 2020-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ehrbase.fhirbridge.fhir.medicationstatement;

import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.rest.annotation.Count;
import ca.uhn.fhir.rest.annotation.IdParam;
import ca.uhn.fhir.rest.annotation.Offset;
import ca.uhn.fhir.rest.annotation.OptionalParam;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.annotation.Search;
import ca.uhn.fhir.rest.annotation.Sort;
import ca.uhn.fhir.rest.api.Constants;
import ca.uhn.fhir.rest.api.SortSpec;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.DateRangeParam;
import ca.uhn.fhir.rest.param.ReferenceAndListParam;
import ca.uhn.fhir.rest.param.StringAndListParam;
import ca.uhn.fhir.rest.param.TokenAndListParam;
import ca.uhn.fhir.rest.param.UriAndListParam;
import org.hl7.fhir.instance.model.api.IAnyResource;
import org.hl7.fhir.r4.model.IdType;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.ResourceType;
import org.openehealth.ipf.commons.ihe.fhir.AbstractPlainProvider;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Implementation of {@link org.openehealth.ipf.commons.ihe.fhir.FhirProvider FhirProvider} that provides REST support
 * for 'Find Medication Statement' transaction.
 *
 * @since 1.0.0
 */
@SuppressWarnings({"unused", "java:S107", "DuplicatedCode"})
public class FindMedicationStatementProvider extends AbstractPlainProvider {

    @Search(type = MedicationStatement.class)
    public IBundleProvider search(@OptionalParam(name = IAnyResource.SP_RES_ID) TokenAndListParam id,
                                  @OptionalParam(name = IAnyResource.SP_RES_LANGUAGE) StringAndListParam language,
                                  @OptionalParam(name = Constants.PARAM_LASTUPDATED) DateRangeParam lastUpdated,
                                  @OptionalParam(name = Constants.PARAM_PROFILE) UriAndListParam profile,
                                  @OptionalParam(name = Constants.PARAM_SOURCE) UriAndListParam resourceSource,
                                  @OptionalParam(name = Constants.PARAM_SECURITY) TokenAndListParam security,
                                  @OptionalParam(name = Constants.PARAM_TAG) TokenAndListParam tag,
                                  @OptionalParam(name = Constants.PARAM_CONTENT) StringAndListParam content,
                                  @OptionalParam(name = Constants.PARAM_TEXT) StringAndListParam text,
                                  @OptionalParam(name = Constants.PARAM_FILTER) StringAndListParam filter,
                                  @OptionalParam(name = MedicationStatement.SP_CATEGORY) TokenAndListParam category,
                                  @OptionalParam(name = MedicationStatement.SP_CODE) TokenAndListParam code,
                                  @OptionalParam(name = MedicationStatement.SP_CONTEXT) ReferenceAndListParam context,
                                  @OptionalParam(name = MedicationStatement.SP_EFFECTIVE) DateRangeParam effective,
                                  @OptionalParam(name = MedicationStatement.SP_IDENTIFIER) TokenAndListParam identifier,
                                  @OptionalParam(name = MedicationStatement.SP_MEDICATION) ReferenceAndListParam medication,
                                  @OptionalParam(name = MedicationStatement.SP_PART_OF) ReferenceAndListParam partOf,
                                  @OptionalParam(name = MedicationStatement.SP_PATIENT) ReferenceAndListParam patient,
                                  @OptionalParam(name = MedicationStatement.SP_SOURCE) ReferenceAndListParam source,
                                  @OptionalParam(name = MedicationStatement.SP_STATUS) TokenAndListParam status,
                                  @OptionalParam(name = MedicationStatement.SP_SUBJECT) ReferenceAndListParam subject,
                                  @Count Integer count, @Offset Integer offset, @Sort SortSpec sort,
                                  RequestDetails requestDetails, HttpServletRequest request, HttpServletResponse response) {

        SearchParameterMap searchParams = new SearchParameterMap();
        searchParams.add(IAnyResource.SP_RES_ID, id);
        searchParams.add(IAnyResource.SP_RES_LANGUAGE, language);

        searchParams.add(Constants.PARAM_PROFILE, profile);
        searchParams.add(Constants.PARAM_SOURCE, resourceSource);
        searchParams.add(Constants.PARAM_SECURITY, security);
        searchParams.add(Constants.PARAM_TAG, tag);
        searchParams.add(Constants.PARAM_CONTENT, content);
        searchParams.add(Constants.PARAM_TEXT, text);
        searchParams.add(Constants.PARAM_FILTER, filter);

        searchParams.add(MedicationStatement.SP_CATEGORY, category);
        searchParams.add(MedicationStatement.SP_CODE, code);
        searchParams.add(MedicationStatement.SP_CONTEXT, context);
        searchParams.add(MedicationStatement.SP_EFFECTIVE, effective);
        searchParams.add(MedicationStatement.SP_IDENTIFIER, identifier);
        searchParams.add(MedicationStatement.SP_MEDICATION, medication);
        searchParams.add(MedicationStatement.SP_PART_OF, partOf);
        searchParams.add(MedicationStatement.SP_PATIENT, patient);
        searchParams.add(MedicationStatement.SP_SOURCE, source);
        searchParams.add(MedicationStatement.SP_STATUS, status);
        searchParams.add(MedicationStatement.SP_SUBJECT, subject);

        searchParams.setLastUpdated(lastUpdated);
        searchParams.setCount(count);
        searchParams.setOffset(offset);
        searchParams.setSort(sort);

        return requestBundleProvider(searchParams, null, ResourceType.MedicationStatement.name(), request, response, requestDetails);
    }

    @Read(version = true)
    public MedicationStatement read(@IdParam IdType id, RequestDetails requestDetails,
                                    HttpServletRequest request, HttpServletResponse response) {
        return requestResource(id, null, MedicationStatement.class, request, response, requestDetails);
    }
}
