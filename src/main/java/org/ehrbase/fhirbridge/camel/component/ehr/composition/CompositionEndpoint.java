package org.ehrbase.fhirbridge.camel.component.ehr.composition;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriPath;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.camel.component.ehr.EhrConfiguration;
import org.ehrbase.fhirbridge.ehr.Composition;

@UriEndpoint(
    firstVersion = "1.0.0",
    scheme = "ehr-composition",
    title = "EHR Composition",
    syntax = "ehr-composition:name",
    producerOnly = true)
@SuppressWarnings({"java:S2160", "java:S1452"})
public class CompositionEndpoint extends DefaultEndpoint {

  @UriPath private String name;

  @UriParam private CompositionOperation operation;

  @UriParam private CompositionConverter<Composition, Object> compositionConverter;

  private Class<?> expectedType;

  @UriParam private EhrConfiguration configuration;

  public CompositionEndpoint(
      String uri, CompositionComponent component, EhrConfiguration configuration) {
    super(uri, component);
    this.configuration = configuration;
  }

  @Override
  public Producer createProducer() {
    return new CompositionProducer(this);
  }

  @Override
  public Consumer createConsumer(Processor processor) {
    throw new UnsupportedOperationException("Cannot consume from Composition endpoint");
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

  public CompositionOperation getOperation() {
    return operation;
  }

  public void setOperation(CompositionOperation operation) {
    this.operation = operation;
  }

  public CompositionConverter<Composition, Object> getCompositionConverter() {
    return compositionConverter;
  }

  public void setCompositionConverter(
      CompositionConverter<Composition, Object> compositionConverter) {
    this.compositionConverter = compositionConverter;
  }

  public Class<?> getExpectedType() {
    return expectedType;
  }

  public void setExpectedType(Class<?> expectedType) {
    this.expectedType = expectedType;
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
