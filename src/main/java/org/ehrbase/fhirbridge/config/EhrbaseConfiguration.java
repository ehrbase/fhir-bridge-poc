package org.ehrbase.fhirbridge.config;

import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;
import org.ehrbase.client.openehrclient.OpenEhrClientConfig;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.fhirbridge.config.ehrbase.AuthorizationType;
import org.ehrbase.fhirbridge.ehr.ResourceTemplateProvider;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/** {@link Configuration Configuration} for EHRbase SDK. */
@Configuration
@EnableConfigurationProperties(EhrbaseProperties.class)
@Import(EhrbaseTemplateInitializer.class)
public class EhrbaseConfiguration {

  private final EhrbaseProperties properties;

  public EhrbaseConfiguration(EhrbaseProperties properties) {
    this.properties = properties;
  }

  @Bean
  public OpenEhrClientConfig restClientConfig() throws URISyntaxException {
    return new OpenEhrClientConfig(new URI(properties.getBaseUrl()));
  }

  @Bean
  public TemplateProvider templateProvider() {
    return new ResourceTemplateProvider(properties.getTemplate().getPrefix());
  }

  @Bean
  public DefaultRestClient openEhrClient(
      OpenEhrClientConfig restClientConfig,
      TemplateProvider templateProvider,
      HttpClient httpClient) {
    return new DefaultRestClient(restClientConfig, templateProvider, httpClient);
  }

  @Bean
  public HttpClient httpClient() {
    HttpClientBuilder builder = HttpClientBuilder.create();

    EhrbaseProperties.Security security = properties.getSecurity();
    if (security.getType() == AuthorizationType.BASIC_AUTH) {
      CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
      credentialsProvider.setCredentials(
          AuthScope.ANY,
          new UsernamePasswordCredentials(security.getUsername(), security.getPassword()));
      builder.setDefaultCredentialsProvider(credentialsProvider);
    }

    return builder.build();
  }
}
