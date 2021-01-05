package org.ehrbase.fhirbridge.ehr;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.apache.xmlbeans.XmlException;
import org.ehrbase.fhirbridge.FhirBridgeException;
import org.ehrbase.webtemplate.templateprovider.TemplateProvider;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;
import org.openehr.schemas.v1.TemplateDocument;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class ResourceTemplateProvider implements TemplateProvider, InitializingBean {

  private final ResourcePatternResolver resourceLoader = new PathMatchingResourcePatternResolver();

  private final Map<String, String> templates = new HashMap<>();

  private final String prefix;

  public ResourceTemplateProvider(String prefix) {
    this.prefix = prefix;
  }

  @Override
  public Optional<OPERATIONALTEMPLATE> find(String templateId) {
    String templateFilename = templates.get(templateId);
    if (templateFilename == null) {
      return Optional.empty();
    }

    Resource resource = resourceLoader.getResource(prefix + templateFilename);
    return Optional.of(parse(resource));
  }

  @Override
  public void afterPropertiesSet() {
    try {
      Arrays.stream(resourceLoader.getResources(prefix + "*.opt"))
          .forEach(
              resource -> {
                OPERATIONALTEMPLATE template = parse(resource);
                templates.put(template.getTemplateId().getValue(), resource.getFilename());
              });
    } catch (IOException e) {
      throw new FhirBridgeException("An I/O exception occurred during initialization", e);
    }
  }

  public Iterable<String> getTemplateIds() {
    return templates.keySet();
  }

  private OPERATIONALTEMPLATE parse(Resource resource) {
    try {
      TemplateDocument document = TemplateDocument.Factory.parse(resource.getInputStream());
      return document.getTemplate();
    } catch (XmlException | IOException e) {
      throw new FhirBridgeException(
          "An error occurred while parsing template [" + resource.getFilename() + "]", e);
    }
  }
}
