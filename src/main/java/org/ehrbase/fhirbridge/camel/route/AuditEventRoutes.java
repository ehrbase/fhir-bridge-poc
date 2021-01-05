package org.ehrbase.fhirbridge.camel.route;

import ca.uhn.fhir.jpa.search.PersistedJpaBundleProvider;
import ca.uhn.fhir.rest.api.server.IBundleProvider;
import java.util.Map;
import org.apache.camel.builder.RouteBuilder;
import org.openehealth.ipf.commons.ihe.fhir.Constants;
import org.springframework.stereotype.Component;

@Component
public class AuditEventRoutes extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    // @formatter:off
    from("fhir-find-audit-event:fhirConsumer?fhirContext=#fhirContext&lazyLoadBundles=true")
        .to("bean:myAuditEventDaoR4?method=search(${body})")
        .process(
            exchange -> {
              IBundleProvider bundleProvider =
                  exchange.getIn().getBody(PersistedJpaBundleProvider.class);
              Map<String, Object> headers = exchange.getIn().getHeaders();
              if (headers.containsKey(Constants.FHIR_REQUEST_SIZE_ONLY)) {
                exchange
                    .getMessage()
                    .setHeader(Constants.FHIR_REQUEST_SIZE_ONLY, bundleProvider.size());
              } else {
                Integer from = exchange.getIn().getHeader(Constants.FHIR_FROM_INDEX, Integer.class);
                Integer to = exchange.getIn().getHeader(Constants.FHIR_TO_INDEX, Integer.class);
                exchange.getMessage().setBody(bundleProvider.getResources(from, to));
              }
            });
    // @formatter:on
  }
}
