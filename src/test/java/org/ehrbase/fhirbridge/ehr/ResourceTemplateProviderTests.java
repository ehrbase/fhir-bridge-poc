package org.ehrbase.fhirbridge.ehr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.openehr.schemas.v1.OPERATIONALTEMPLATE;

class ResourceTemplateProviderTests {

  @Test
  void find() {
    ResourceTemplateProvider templateProvider = new ResourceTemplateProvider("classpath:/opt/");
    templateProvider.afterPropertiesSet();

    Optional<OPERATIONALTEMPLATE> result =
        templateProvider.find("Kennzeichnung Erregernachweis SARS-CoV-2");

    assertTrue(result.isPresent());
    assertEquals("Kennzeichnung Erregernachweis SARS-CoV-2", result.get().getConcept());
  }

  @Test
  void findWithInvalidTemplateId() {
    ResourceTemplateProvider templateProvider = new ResourceTemplateProvider("classpath:/opt/");
    templateProvider.afterPropertiesSet();

    Optional<OPERATIONALTEMPLATE> template = templateProvider.find("Invalid Template ID");

    assertTrue(template.isEmpty());
  }
}
