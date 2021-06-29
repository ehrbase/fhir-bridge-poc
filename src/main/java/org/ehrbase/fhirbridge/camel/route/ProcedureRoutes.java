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
import org.hl7.fhir.r4.model.Procedure;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link RouteBuilder} that provides route definitions for transactions
 * linked to {@link Procedure} resource.
 *
 * @since 1.0.0
 */
@Component
public class ProcedureRoutes extends AbstractRouteBuilder {

    public ProcedureRoutes(SearchProperties properties) {
        super(properties);
    }

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // Route: Provide Procedure
        from("procedure-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-procedure-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .process("provideProcedurePersistenceProcessor")
            .to("direct:internal-provide-resource");

        // Route: 'Find Procedure'
        from("procedure-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=true")
            .routeId("find-procedure-route")
            .process("findProcedureProcessor");

        // @formatter:on
    }
}
