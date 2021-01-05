package org.ehrbase.fhirbridge.config;

import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.ehr.ResourceTemplateProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class EhrbaseTemplateInitializer implements InitializingBean {

  private static final Logger LOG = LoggerFactory.getLogger(EhrbaseTemplateInitializer.class);

  private final OpenEhrClient openEhrClient;

  private final ResourceTemplateProvider templateProvider;

  public EhrbaseTemplateInitializer(
      OpenEhrClient openEhrClient, ResourceTemplateProvider templateProvider) {
    this.openEhrClient = openEhrClient;
    this.templateProvider = templateProvider;
  }

  @Override
  public void afterPropertiesSet() {
    templateProvider
        .getTemplateIds()
        .forEach(
            templateId -> {
              LOG.info("Initializing template '{}'", templateId);
              openEhrClient.templateEndpoint().ensureExistence(templateId);
            });
  }
}
