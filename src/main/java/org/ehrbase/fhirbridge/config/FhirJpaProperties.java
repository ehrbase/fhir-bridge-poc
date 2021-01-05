package org.ehrbase.fhirbridge.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/** {@link ConfigurationProperties ConfigurationProperties} to configure HAPI FHIR JPA server. */
@ConfigurationProperties(prefix = "fhir-bridge.fhir.jpa")
public class FhirJpaProperties {

  private boolean allowExternalReferences = true;

  public boolean isAllowExternalReferences() {
    return allowExternalReferences;
  }

  public void setAllowExternalReferences(boolean allowExternalReferences) {
    this.allowExternalReferences = allowExternalReferences;
  }
}
