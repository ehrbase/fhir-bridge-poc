package org.ehrbase.fhirbridge.config;

import org.ehrbase.fhirbridge.fhir.common.validation.TerminologyValidationMode;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** {@link ConfigurationProperties ConfigurationProperties} to configure FHIR validation. */
@ConfigurationProperties(prefix = "fhir-bridge.fhir.validation")
public class FhirValidationProperties {

  private final Terminology terminology = new Terminology();

  public Terminology getTerminology() {
    return terminology;
  }

  public static class Terminology {

    private TerminologyValidationMode mode = TerminologyValidationMode.NONE;

    private String serverUrl;

    public TerminologyValidationMode getMode() {
      return mode;
    }

    public void setMode(TerminologyValidationMode mode) {
      this.mode = mode;
    }

    public String getServerUrl() {
      return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
      this.serverUrl = serverUrl;
    }
  }
}
