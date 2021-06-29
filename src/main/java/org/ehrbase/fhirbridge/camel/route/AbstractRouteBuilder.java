package org.ehrbase.fhirbridge.camel.route;

import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.ehrbase.fhirbridge.config.SearchProperties;
import org.springframework.beans.factory.annotation.Value;

public abstract class AbstractRouteBuilder extends RouteBuilder {

    @Value("${fhir-bridge.debug.enabled:false}")
    private boolean debug;

    private final SearchProperties properties;

    protected AbstractRouteBuilder(SearchProperties properties) {
        this.properties = properties;
    }

    @Override
    public void configure() throws Exception {
        errorHandler(defaultErrorHandler()
                .logStackTrace(debug)
                .logExhaustedMessageHistory(debug));

        onException(Exception.class)
                .process("defaultExceptionHandler");
    }

    protected Predicate isDatabaseSearchMode() {
        return exchange -> properties.getSearch() == SearchProperties.SearchMode.DATABASE;
    }
}
