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

package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.jpa.searchparam.SearchParameterMap;
import ca.uhn.fhir.model.api.IQueryParameterType;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.openehr.aql.AqlConstants;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.client.aql.record.Record;
import org.ehrbase.fhirbridge.config.SearchProperties;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.GECCOLaborbefundComposition;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link RouteBuilder} that provides route definitions for transactions
 * linked to {@link DiagnosticReport} resource.
 *
 * @since 1.0.0
 */
@Component
public class DiagnosticReportRoutes extends AbstractRouteBuilder {

    private final FhirContext fhirContext;

    public DiagnosticReportRoutes(SearchProperties properties, FhirContext fhirContext) {
        super(properties);
        this.fhirContext = fhirContext;
    }

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // Route: Provide Diagnostic Report
        from("diagnostic-report-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-diagnostic-report-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .to("direct:internal-provide-diagnostic-report");

        // Route: Internal Provide Diagnostic Report
        from("direct:internal-provide-diagnostic-report")
            .routeId("internal-provide-diagnostic-report-route")
            .process("provideDiagnosticReportPersistenceProcessor")
            .to("direct:internal-provide-resource");

        // 'Find Diagnostic Report' route definition
        from("diagnostic-report-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=false")
            .routeId("find-diagnostic-report-route")
            .choice()
                .when(isDatabaseSearchMode())
                    .process("findDiagnosticReportProcessor")
                .otherwise()
                    .to("direct:search-using-ehrbase");

        from("direct:search-using-ehrbase")
            .setHeader(AqlConstants.AQL_QUERY, () -> Query.buildNativeQuery(
                "SELECT c " +
                      "FROM EHR e CONTAINS COMPOSITION c " +
                     "WHERE c/archetype_details/template_id/value = 'GECCO_Laborbefund' " +
                       "AND e/ehr_status/subject/external_ref/id/value = $value", GECCOLaborbefundComposition.class))
            .setBody(exchange -> {
                SearchParameterMap searchParameters = exchange.getIn().getBody(SearchParameterMap.class);
                List<List<IQueryParameterType>> patientIdentifier = searchParameters.get(DiagnosticReport.SP_PATIENT);
                if (patientIdentifier.size() != 1) {
                    throw new IllegalArgumentException("SearchParameters should contain exactly one patient identifier");
                }
                String value = patientIdentifier.get(0).get(0).getValueAsQueryToken(fhirContext);
                return new ParameterValue<>("value", value);
            })
            .to("openehr-aql:endpoint")
            .process(exchange -> {
                // TODO: map result into FHIR Resource
                Record[] records = exchange.getIn().getBody(Record[].class);

                List<IBaseResource> result = new ArrayList<>();
                for (int i = 0; i < records.length; i++) {
                    result.add(new DiagnosticReport().setId("ID-" + i));
                }
                exchange.getMessage().setBody(result);
            });
        // @formatter:on
    }
}
