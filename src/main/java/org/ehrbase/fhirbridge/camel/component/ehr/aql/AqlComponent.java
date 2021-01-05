package org.ehrbase.fhirbridge.camel.component.ehr.aql;

import java.util.Map;
import java.util.Set;
import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.camel.component.ehr.EhrConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** AQL component */
public class AqlComponent extends DefaultComponent {

  private static final Logger LOG = LoggerFactory.getLogger(AqlComponent.class);

  private EhrConfiguration configuration;

  private boolean allowAutoWiredOpenEhrClient = true;

  public AqlComponent() {
    configuration = new EhrConfiguration();
  }

  public AqlComponent(CamelContext context) {
    super(context);
    configuration = new EhrConfiguration();
  }

  @Override
  protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters)
      throws Exception {
    final EhrConfiguration newConfiguration = configuration.copy();
    AqlEndpoint endpoint = new AqlEndpoint(uri, this, newConfiguration);
    setProperties(endpoint, parameters);
    return endpoint;
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
}
