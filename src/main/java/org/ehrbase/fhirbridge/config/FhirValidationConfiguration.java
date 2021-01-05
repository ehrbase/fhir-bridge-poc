package org.ehrbase.fhirbridge.config;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.interceptor.RequestValidatingInterceptor;
import java.io.IOException;
import java.io.InputStream;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.FhirBridgeException;
import org.ehrbase.fhirbridge.camel.processor.PatientIdProcessor;
import org.ehrbase.fhirbridge.camel.processor.ResourceProfileValidator;
import org.ehrbase.fhirbridge.fhir.common.validation.TerminologyServerValidationSupport;
import org.ehrbase.fhirbridge.fhir.common.validation.TerminologyValidationMode;
import org.hl7.fhir.common.hapi.validation.support.CachingValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.CommonCodeSystemsTerminologyService;
import org.hl7.fhir.common.hapi.validation.support.InMemoryTerminologyServerValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.PrePopulatedValidationSupport;
import org.hl7.fhir.common.hapi.validation.support.ValidationSupportChain;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.StructureDefinition;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;

/** {@link Configuration Configuration} for FHIR validation. */
@Configuration
@EnableConfigurationProperties(FhirValidationProperties.class)
public class FhirValidationConfiguration {

  private final FhirContext fhirContext = FhirContext.forR4();

  private final FhirValidationProperties properties;

  private final ResourcePatternResolver resourceLoader;

  private final MessageSource messageSource;

  public FhirValidationConfiguration(
      FhirValidationProperties properties,
      ResourcePatternResolver resourceLoader,
      MessageSource messageSource) {
    this.properties = properties;
    this.resourceLoader = resourceLoader;
    this.messageSource = messageSource;
  }

  @Bean
  public ResourceProfileValidator defaultCreateResourceRequestValidator(FhirContext fhirContext) {
    return new ResourceProfileValidator(fhirContext);
  }

  @Bean
  public PatientIdProcessor patientIdProcessor(
      FhirContext fhirContext, OpenEhrClient openEhrClient) {
    return new PatientIdProcessor(fhirContext, openEhrClient);
  }

  @Bean
  public RequestValidatingInterceptor requestValidatingInterceptor() {
    ValidationSupportChain validationSupport = new ValidationSupportChain();
    validationSupport.addValidationSupport(new DefaultProfileValidationSupport(fhirContext));
    validationSupport.addValidationSupport(prePopulatedValidationSupport());

    TerminologyValidationMode mode = properties.getTerminology().getMode();
    if (mode == TerminologyValidationMode.EMBEDDED) {
      validationSupport.addValidationSupport(new CommonCodeSystemsTerminologyService(fhirContext));
      validationSupport.addValidationSupport(
          new InMemoryTerminologyServerValidationSupport(fhirContext));
    } else if (mode == TerminologyValidationMode.SERVER) {
      validationSupport.addValidationSupport(terminologyServerValidationSupport());
    }

    CachingValidationSupport cachingValidationSupport =
        new CachingValidationSupport(validationSupport);

    FhirInstanceValidator fhirInstanceValidator =
        new FhirInstanceValidator(cachingValidationSupport);
    fhirInstanceValidator.setErrorForUnknownProfiles(false);
    fhirInstanceValidator.setNoTerminologyChecks(
        properties.getTerminology().getMode() == TerminologyValidationMode.NONE);

    RequestValidatingInterceptor interceptor = new RequestValidatingInterceptor();
    interceptor.addValidatorModule(fhirInstanceValidator);
    return interceptor;
  }

  private PrePopulatedValidationSupport prePopulatedValidationSupport() {
    PrePopulatedValidationSupport prePopulatedValidationSupport =
        new PrePopulatedValidationSupport(fhirContext);
    IParser parser = fhirContext.newXmlParser();
    try {
      for (Resource resource : resourceLoader.getResources("classpath:/profiles/*")) {
        InputStream inputStream = resource.getInputStream();
        StructureDefinition structureDefinition =
            parser.parseResource(StructureDefinition.class, inputStream);
        prePopulatedValidationSupport.addStructureDefinition(structureDefinition);
      }
    } catch (IOException e) {
      throw new FhirBridgeException("Initialization failed", e);
    }
    return prePopulatedValidationSupport;
  }

  private TerminologyServerValidationSupport terminologyServerValidationSupport() {
    IGenericClient client =
        fhirContext.newRestfulGenericClient(properties.getTerminology().getServerUrl());
    TerminologyServerValidationSupport terminologyServerValidationSupport =
        new TerminologyServerValidationSupport(fhirContext, client);
    terminologyServerValidationSupport.setMessageSource(messageSource);
    return terminologyServerValidationSupport;
  }
}
