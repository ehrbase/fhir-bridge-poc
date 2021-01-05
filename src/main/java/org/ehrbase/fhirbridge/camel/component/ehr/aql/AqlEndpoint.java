package org.ehrbase.fhirbridge.camel.component.ehr.aql;

import org.apache.camel.Component;
import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.camel.component.ehr.EhrConfiguration;

@UriEndpoint(
    scheme = "ehr-aql",
    title = "openEHR AQL",
    syntax = "ehr-aql:name",
    producerOnly = true)
@SuppressWarnings({"java:S2160", "java:S1452"})
public class AqlEndpoint extends DefaultEndpoint {

  @UriPath private String name;

  @UriParam private AqlOutputType outputType = AqlOutputType.SelectList;

  @UriParam private RowMapper<?> rowMapper;

  @UriParam private EhrConfiguration configuration;

  public AqlEndpoint(String endpointUri, Component component, EhrConfiguration configuration) {
    super(endpointUri, component);
    this.configuration = configuration;
  }

  @Override
  public Producer createProducer() {
    return new AqlProducer(this);
  }

  @Override
  public Consumer createConsumer(Processor processor) {
    throw new UnsupportedOperationException("Cannot consume from AQL endpoint");
  }

  @Override
  public boolean isSingleton() {
    return true;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public AqlOutputType getOutputType() {
    return outputType;
  }

  public void setOutputType(AqlOutputType outputType) {
    this.outputType = outputType;
  }

  public RowMapper<?> getRowMapper() {
    return rowMapper;
  }

  public void setRowMapper(RowMapper<?> rowMapper) {
    this.rowMapper = rowMapper;
  }

  public EhrConfiguration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(EhrConfiguration configuration) {
    this.configuration = configuration;
  }

  public OpenEhrClient getOpenEhrClient() {
    return getConfiguration().getOpenEhrClient();
  }

  public void setOpenEhrClient(OpenEhrClient openEhrClient) {
    getConfiguration().setOpenEhrClient(openEhrClient);
  }
}
