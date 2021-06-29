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

import org.ehrbase.fhirbridge.config.SearchProperties;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link org.apache.camel.builder.RouteBuilder RouteBuilder} that defines routes for transactions
 * related to {@link org.hl7.fhir.r4.model.MedicationStatement MedicationStatement} resource.
 *
 * @since 1.1.0
 */
@Component
public class MedicationStatementRoutes extends AbstractRouteBuilder {

    public MedicationStatementRoutes(SearchProperties properties) {
        super(properties);
    }

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // Route: Provide Medication Statement
        from("medication-statement-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-medication-statement-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .process("provideMedicationStatementPersistenceProcessor")
            .to("direct:internal-provide-resource");

        // Route: Find Medication Statement
        from("medication-statement-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=true")
            .routeId("find-medication-statement-route")
            .process("findMedicationStatementProcessor");

        // @formatter:on
    }
}
