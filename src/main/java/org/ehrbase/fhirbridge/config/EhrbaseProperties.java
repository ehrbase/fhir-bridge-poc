package org.ehrbase.fhirbridge.config;

import org.ehrbase.fhirbridge.config.ehrbase.AuthorizationType;
import org.springframework.boot.context.properties.ConfigurationProperties;

/** {@link ConfigurationProperties ConfigurationProperties} to configure EHRbase SDK. */
@ConfigurationProperties(prefix = "fhir-bridge.ehrbase")
public class EhrbaseProperties {

  private String baseUrl;

  private final Security security = new Security();

  private final Template template = new Template();

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public Security getSecurity() {
    return security;
  }

  public Template getTemplate() {
    return template;
  }

  public static class Security {

    private AuthorizationType type;

    private String username;

    private String password;

    public AuthorizationType getType() {
      return type;
    }

    public void setType(AuthorizationType type) {
      this.type = type;
    }

    public String getUsername() {
      return username;
    }

    public void setUsername(String username) {
      this.username = username;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
  }

  public static class Template {

    private String prefix;

    public String getPrefix() {
      return prefix;
    }

    public void setPrefix(String prefix) {
      this.prefix = prefix;
    }
  }
}
