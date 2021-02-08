package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.camel.FhirBridgeConstants;
import org.ehrbase.fhirbridge.camel.processor.DefaultExceptionHandler;
import org.ehrbase.fhirbridge.camel.processor.EhrIdLookupProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.camel.processor.ResourceResponseProcessor;
import org.ehrbase.fhirbridge.ehr.converter.DiagnosticReportLabCompositionConverter;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class DiagnosticReportRoutes extends RouteBuilder {

    private final IFhirResourceDao<DiagnosticReport> diagnosticReportDao;

    private final EhrIdLookupProcessor ehrIdLookupProcessor;

    private final ResourceResponseProcessor resourceResponseProcessor;

    private final ResourceProfileValidator requestValidator;

    private final DefaultExceptionHandler defaultExceptionHandler;

    public DiagnosticReportRoutes(IFhirResourceDao<DiagnosticReport> diagnosticReportDao,
                                  EhrIdLookupProcessor ehrIdLookupProcessor,
                                  ResourceResponseProcessor resourceResponseProcessor,
                                  ResourceProfileValidator requestValidator,
                                  DefaultExceptionHandler defaultExceptionHandler) {
        this.diagnosticReportDao = diagnosticReportDao;
        this.ehrIdLookupProcessor = ehrIdLookupProcessor;
        this.resourceResponseProcessor = resourceResponseProcessor;
        this.requestValidator = requestValidator;
        this.defaultExceptionHandler = defaultExceptionHandler;
    }


    @Override
    public void configure() {
        // @formatter:off
        onException(Exception.class)
                .process(defaultExceptionHandler);

        from("fhir-create-diagnostic-report:fhirConsumer?fhirContext=#fhirContext")
            .onCompletion()
                .process("auditCreateResourceProcessor")
            .end()
            .process(requestValidator)
            .to("direct:process-diagnostic-report");

        from("direct:process-diagnostic-report")
            .setHeader(FhirBridgeConstants.METHOD_OUTCOME, method(diagnosticReportDao, "create"))
            .process(ehrIdLookupProcessor)
            .to("ehr-composition:compositionEndpoint?operation=mergeCompositionEntity&compositionConverter=#diagnosticReportLabCompositionConverter")
            .process(resourceResponseProcessor);
        // @formatter:on
    }

    // TODO: Update when Apache Camel > 3.x
    @Bean
    public DiagnosticReportLabCompositionConverter diagnosticReportLabCompositionConverter() {
        return new DiagnosticReportLabCompositionConverter();
    }
}
