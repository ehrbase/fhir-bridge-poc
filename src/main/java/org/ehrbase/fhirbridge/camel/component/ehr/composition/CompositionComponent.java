package org.ehrbase.fhirbridge.camel.component.ehr.composition;

import java.util.Map;
import java.util.Set;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.camel.component.ehr.EhrConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Composition component */
public class CompositionComponent extends DefaultComponent {

  private static final Logger LOG = LoggerFactory.getLogger(CompositionComponent.class);

  private EhrConfiguration configuration;

  private boolean allowAutoWiredOpenEhrClient = true;

  public CompositionComponent() {
    this.configuration = new EhrConfiguration();
  }

  public CompositionComponent(CamelContext context) {
    super(context);
    this.configuration = new EhrConfiguration();
  }

  @Override
  protected void doStart() throws Exception {
    if (configuration.getOpenEhrClient() == null && isAllowAutoWiredOpenEhrClient()) {
      Set<OpenEhrClient> beans = getCamelContext().getRegistry().findByType(OpenEhrClient.class);
      if (beans.size() == 1) {
        OpenEhrClient client = beans.iterator().next();
        configuration.setOpenEhrClient(client);
      } else if (beans.size() > 1) {
        LOG.debug("Cannot autowire OpenEhrClient as {} instances found in registry.", beans.size());
      }
    }
    super.doStart();
  }

  @Override
  protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters)
      throws Exception {
    final EhrConfiguration newConfiguration = configuration.copy();

    CompositionEndpoint endpoint = new CompositionEndpoint(uri, this, newConfiguration);
    setProperties(endpoint, parameters);
    return endpoint;
  }

  public EhrConfiguration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(EhrConfiguration configuration) {
    this.configuration = configuration;
  }

  public boolean isAllowAutoWiredOpenEhrClient() {
    return allowAutoWiredOpenEhrClient;
  }

  public void setAllowAutoWiredOpenEhrClient(boolean allowAutoWiredOpenEhrClient) {
    this.allowAutoWiredOpenEhrClient = allowAutoWiredOpenEhrClient;
  }

  public OpenEhrClient getOpenEhrClient() {
    return configuration.getOpenEhrClient();
  }
}
