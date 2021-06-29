package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.CamelConstants;
import org.ehrbase.fhirbridge.config.SearchProperties;
import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.ehrbase.fhirbridge.fhir.support.Encounters;
import org.hl7.fhir.r4.model.Encounter;
import org.springframework.stereotype.Component;

/**
 * Implementation of {@link RouteBuilder} that provides route definitions for transactions
 * linked to {@link Encounter} resource.
 *
 * @since 1.0.0
 */
@Component
public class EncounterRoutes extends AbstractRouteBuilder {

    public EncounterRoutes(SearchProperties properties) {
        super(properties);
    }

    @Override
    public void configure() throws Exception {
        // @formatter:off
        super.configure();

        // 'Provide Encounter' route definition
        from("encounter-provide:consumer?fhirContext=#fhirContext")
            .routeId("provide-encounter-route")
            .onCompletion()
                .process("provideResourceAuditHandler")
            .end()
            .process("fhirProfileValidator")
            .to("direct:internal-provide-encounter");

       // Internal routes definition
        from("direct:internal-provide-encounter")
            .routeId("internal-provide-encounter-route")
            .process("provideEncounterPersistenceProcessor")
            .process("ehrIdLookupProcessor")
            .setHeader(CamelConstants.PROFILE, method(Encounters.class, "getProfileByKontaktEbene"))
            .doTry()
                .choice()
                    .when(header(CamelConstants.PROFILE).isEqualTo(Profile.KONTAKT_GESUNDHEIT_ABTEILUNG))
                        .to("bean:fhirResourceConversionService?method=convert(${headers.FhirBridgeProfile}, ${body})")
                    .otherwise()
                        .to("bean:fhirResourceConversionService?method=convertDefaultEncounter(${body})")
            .endDoTry()
            .doCatch(ConversionException.class)
                .throwException(UnprocessableEntityException.class, "${exception.message}")
            .end()
            .to("direct:internal-provide-resource-after-converter");

        // 'Find Encounter' route definition
        from("encounter-find:consumer?fhirContext=#fhirContext&lazyLoadBundles=true")
                .routeId("find-encounter-route")
                .process("findEncounterProcessor");

        // @formatter:on
    }
}