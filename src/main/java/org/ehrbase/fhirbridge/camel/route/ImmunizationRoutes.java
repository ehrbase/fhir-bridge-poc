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

import org.springframework.stereotype.Component;

/**
 * Implementation of {@link AbstractRouteBuilder} that provides route definitions
 * for transactions linked to {@link org.hl7.fhir.r4.model.Immunization Immunization} resource.
 *
 * @since 1.2.0
 */
@Component
public class ImmunizationRoutes extends AbstractRouteBuilder {

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // 'Create Immunization' route definition
        from("immunization-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-immunization-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .process("provideImmunizationPersistenceProcessor")
            .to("direct:internal-provide-resource");

        // 'Find Immunization' route definition
        from("immunization-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=true")
            .routeId("find-immunization-route")
            .process("findImmunizationProcessor");
        // @formatter:on
    }
}
