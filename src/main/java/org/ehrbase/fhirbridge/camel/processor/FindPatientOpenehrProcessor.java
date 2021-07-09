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

package org.ehrbase.fhirbridge.camel.processor;

import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.model.api.IQueryParameterType;
import ca.uhn.fhir.rest.api.RestOperationTypeEnum;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.param.HasParam;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.Processor;
import org.ehrbase.client.annotations.Template;
import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.instance.model.api.IIdType;
import org.hl7.fhir.r4.model.Patient;
import org.openehealth.ipf.commons.ihe.fhir.Constants;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;
import java.util.Arrays;
import java.util.HashSet;



/**
 * Test to find Patient in openEHR.
 *
 */
public class FindPatientOpenehrProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(FindPatientOpenehrProcessor.class);

    public FindPatientOpenehrProcessor() {
            }

    @Override
    public void process(Exchange exchange) throws Exception {
        LOG.trace("Processing...");

        if (isSearchOperation(exchange)) {
            handleSearchOperation(exchange);
        } else {
            handleReadOperation(exchange);
        }
    }

    private void handleSearchOperation(Exchange exchange) throws Exception {
        LOG.debug("Execute 'search' operation");

        /*
        SearchParameterMap parameters = exchange.getIn().getMandatoryBody(SearchParameterMap.class);

        // getting parameters this way gives empty...
        for (String param : parameters.keySet()) {
            System.out.println(param);

            for (List<IQueryParameterType> complexValue : parameters.get(param)) {
                for (IQueryParameterType simpleValue : complexValue) {
                    System.out.println(simpleValue);
                    System.out.println(simpleValue.getClass().getSimpleName());
                }
            }
            System.out.println("");
        }
        */

        boolean isCount = false;
        List<HasParam> hasParams = new ArrayList<>();
        HasParam tmpParam;

        RequestDetails request = extractRequestDetails(exchange);
        Map<String, String[]> params = request.getParameters();
        for (String key : params.keySet()) {

            //System.out.println(key + ": "); // _has:Encounter:patient:date // _summary // _has:Encounter:patient:date

            String[] values = params.get(key);

            if (key.startsWith("_summary") && values.length > 0) {

                isCount = values[0].equals("count");

            } else if (key.startsWith("_has")) {

                for (int i = 0; i < values.length; i++) { // multiple values if the same param was submitted twice

                    tmpParam = new HasParam();
                    tmpParam.setValueAsQueryToken(null, ca.uhn.fhir.rest.api.Constants.PARAM_HAS, key.substring(4), values[i]); // 3rd param is the key without the _has
                    hasParams.add(tmpParam);
                }
            }

            System.out.println("");
        }

        /* TODO: How to get the parsed params from Camel?
        _summary:
        count

        _has:Encounter:patient:date:
        2020

        _has:Observation:patient:code: <<< there are 2 parameters with the same name so there are 2 values that should be processed independently
        2160-0,14682-9,3091-6,22664-7
        1743-4,1742-6,30239-8,1920-8,88112-8

        _has:Condition:patient:code:
        C34.0,C34.1,C34.2,C34.3,C34.8,C34.9
        */



        List<String> codeValues;
        for (HasParam param : hasParams) {

            // if any of the codes in getParameterValue() matches a template, all the codes will be compared to a path in that template
            // it might be semantically incorrect to have codes in the same list matching different templates
            // so one match is enough to know the template
            // but then we need an extra piece of metadata to know which path corresponds to the getTargetResourceType() . getParameterName() FHIR attribute,
            // which could be Observation.code or Condition.code.
            // if the getParameterName() is not "code" then it should be processed separately, for instance Encounter.date
            System.out.println(param.getTargetResourceType() + "." + param.getParameterName() + "=" + param.getParameterValue());

            if (param.getParameterName().equals("code")) {

                codeValues = Arrays.stream(param.getParameterValue().split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());

                // accumulates all unique matching templates for this FHIR parameter
                Set<String> allTemplates = new HashSet<>();

                for (String code : codeValues) {

                    allTemplates.addAll(this.findMatchingTemplates(code));
                }

                for (String template : allTemplates) {

                    System.out.println("Template found: " + template);
                }

                System.out.println("");
            }
        }

        //IBundleProvider bundleProvider = resourceDao.search(parameters, extractRequestDetails(exchange));

        /*
        if (exchange.getIn().getHeaders().containsKey(Constants.FHIR_REQUEST_SIZE_ONLY)) {
            exchange.getMessage().setHeader(Constants.FHIR_REQUEST_SIZE_ONLY, bundleProvider.size());
        } else {
            Integer from = exchange.getIn().getHeader(Constants.FHIR_FROM_INDEX, Integer.class);
            Integer to = exchange.getIn().getHeader(Constants.FHIR_TO_INDEX, Integer.class);
            exchange.getMessage().setBody(bundleProvider.getResources(from, to));
        }
        */

        // TEST: simulate output bundle
        List<IBaseResource> result = new ArrayList<>();
        result.add(new Patient().setId("ID-12345"));
        exchange.getMessage().setBody(result);

        if (isCount) {
            exchange.getMessage().setHeader(Constants.FHIR_REQUEST_SIZE_ONLY, result.size()); // required if param _summary=count
        } else {
            throw new Exception("_summary should be equals to 'count'");
        }
    }

    private void handleReadOperation(Exchange exchange) throws InvalidPayloadException {
        LOG.debug("Execute 'read'/'vread' operation");

        //IIdType id = exchange.getIn().getMandatoryBody(IIdType.class);
        //exchange.getMessage().setBody(resourceDao.read(id, extractRequestDetails(exchange)));
    }

    private boolean isSearchOperation(Exchange exchange) {
        RequestDetails requestDetails = extractRequestDetails(exchange);
        return requestDetails.getRestOperationType() == RestOperationTypeEnum.SEARCH_TYPE;
    }

    private RequestDetails extractRequestDetails(Exchange exchange) {
        RequestDetails requestDetails = exchange.getIn().getHeader(Constants.FHIR_REQUEST_DETAILS, RequestDetails.class);
        if (requestDetails == null) {
            throw new IllegalStateException("RequestDetails must not be null");
        }
        return requestDetails;
    }

    private List<String> findMatchingTemplates(String code) {

        List<String> templates = new ArrayList<>();

        Reflections reflections = new Reflections("org.ehrbase.fhirbridge.ehr.opt");
        Set<Class<? extends Enum>> enumClasses = reflections.getSubTypesOf(Enum.class);

        String enumCode;
        boolean foundCode = false;
        String foundPackage;

        for (Class<? extends Enum> enumClass: enumClasses) {

            foundCode = false;

            if (!enumClass.isEnum()) {
                continue;
            }

            for (Object econt : enumClass.getEnumConstants()) {
                Method methodToFind = null;
                try {
                    methodToFind = econt.getClass().getMethod("getCode", (Class<?>[]) null);

                    // calls econt.getCode(), no parameters
                    enumCode = (String) methodToFind.invoke(econt, (Object[]) null);

                    if (code.equals(enumCode)) {
                        foundCode = true;
                        break;
                    }

                    //System.out.println(code); // this should be used for code matching

                    // when the code matches, we need the package where the enum is defined
                    // then remove the '.definition' from the package
                    // then in that package search for the class that implements CompositionEntity
                    // on that class, get the @Template anotation
                    // the value of the annotation will be the template we are looking for

                } catch (NoSuchMethodException | SecurityException | IllegalAccessException | InvocationTargetException e) {
                    System.out.println("oops 1");
                }
            }

            if (!foundCode) {
                continue;
            }

            // enumClass has a code that matches

            // code for processing the found package

            // get parent package
            foundPackage = enumClass.getPackageName(); // org.ehrbase.fhirbridge.ehr.opt.xxx.definition
            int lastIndex = foundPackage.lastIndexOf(".");
            String parentPackName = foundPackage.substring(0, lastIndex); // org.ehrbase.fhirbridge.ehr.opt.xxx


            // get compo classes in parent package (there should be just one)
            Reflections reflectComposition = new Reflections(parentPackName);
            Set<Class<? extends CompositionEntity>> compoClasses = reflectComposition.getSubTypesOf(CompositionEntity.class);

            // get template annotation
            for (Class<? extends CompositionEntity> compoClass : compoClasses) {

                Template templateAnnotation = compoClass.getAnnotation(Template.class);
                templates.add(templateAnnotation.value());
            }
        }

        return templates;
    }
}
