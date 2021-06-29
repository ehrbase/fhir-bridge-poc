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

import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.config.SearchProperties;
import org.hl7.fhir.r4.model.Observation;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link RouteBuilder} that provides route definitions for transactions
 * linked to {@link Observation} resource.
 *
 * @since 1.0.0
 */
@Component
public class ObservationRoutes extends AbstractRouteBuilder {

    public ObservationRoutes(SearchProperties properties) {
        super(properties);
    }

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // Route: Provide Observation
        from("observation-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-observation-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .to("direct:internal-provide-observation");

        // Route: Internal Provide Observation
        from("direct:internal-provide-observation")
            .routeId("internal-provide-observation-route")
            .process("provideObservationPersistenceProcessor")
            .to("direct:internal-provide-resource");

        // 'Find Observation' route definition
        from("observation-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=true")
            .routeId("find-observation-route")
            .process("findObservationProcessor");
        // @formatter:on
    }
}
