package org.ehrbase.fhirbridge.fhir.common.validation;

import static org.apache.commons.lang3.StringUtils.isBlank;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.ConceptValidationOptions;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.context.support.ValidationSupportContext;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.server.exceptions.ResourceNotFoundException;
import ca.uhn.fhir.util.ParametersUtil;
import io.micrometer.core.lang.NonNull;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.hl7.fhir.common.hapi.validation.support.BaseValidationSupport;
import org.hl7.fhir.instance.model.api.IBaseResource;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.Parameters;
import org.hl7.fhir.r4.model.StringType;
import org.hl7.fhir.r4.model.ValueSet;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;

public class TerminologyServerValidationSupport extends BaseValidationSupport
    implements MessageSourceAware {

  private static final Logger LOG =
      LoggerFactory.getLogger(TerminologyServerValidationSupport.class);

  private final IGenericClient client;

  private MessageSourceAccessor messages;

  public TerminologyServerValidationSupport(FhirContext theFhirContext, IGenericClient client) {
    super(theFhirContext);
    this.client = client;
  }

  @Override
  @Cacheable(cacheNames = "codeSystemSupported", key = "#theSystem")
  public boolean isCodeSystemSupported(
      ValidationSupportContext theValidationSupportContext, String theSystem) {
    LOG.debug("Checks whether or not the CodeSystem '{}' is supported by the server", theSystem);
    Bundle bundle =
        client
            .search()
            .forResource(CodeSystem.class)
            .where(CodeSystem.URL.matches().value(theSystem))
            .returnBundle(Bundle.class)
            .execute();
    return bundle.getTotal() > 0;
  }

  @Override
  @Cacheable(cacheNames = "valueSetSupported", key = "#theValueSetUrl")
  public boolean isValueSetSupported(
      ValidationSupportContext theValidationSupportContext, String theValueSetUrl) {
    LOG.debug("Checks whether or not the ValueSet '{}' is supported by the server", theValueSetUrl);
    Bundle bundle =
        client
            .search()
            .forResource(ValueSet.class)
            .where(ValueSet.URL.matches().value(theValueSetUrl))
            .returnBundle(Bundle.class)
            .execute();
    return bundle.getTotal() > 0;
  }

  @Override
  @Cacheable(cacheNames = "codeInCodeSystem", key = "#theCodeSystem + #theCode")
  public CodeValidationResult validateCode(
      ValidationSupportContext theValidationSupportContext,
      ConceptValidationOptions theOptions,
      String theCodeSystem,
      String theCode,
      String theDisplay,
      String theValueSetUrl) {
    LOG.debug("Checks if the CodeSystem '{}' contains the code '{}'", theCodeSystem, theCode);

    try {
      Parameters input = new Parameters();
      ParametersUtil.addParameterToParametersUri(getFhirContext(), input, "system", theCodeSystem);
      ParametersUtil.addParameterToParametersString(getFhirContext(), input, "code", theCode);

      Parameters output =
          client
              .operation()
              .onType(CodeSystem.class)
              .named("lookup")
              .withParameters(input)
              .returnResourceType(Parameters.class)
              .execute();

      return new CodeValidationResult()
          .setCode(theCode)
          .setCodeSystemName(((StringType) output.getParameter("name")).getValue())
          .setDisplay(((StringType) output.getParameter("display")).getValue());
    } catch (ResourceNotFoundException e) {
      return new CodeValidationResult()
          .setSeverity(IssueSeverity.ERROR)
          .setMessage(
              messages.getMessage(
                  "validation.terminology.lookup", new Object[] {theCode, theCodeSystem}));
    }
  }

  @Override
  @Cacheable(cacheNames = "codeInValueSet", key = "#theValueSet + #theCodeSystem + #theCode")
  public CodeValidationResult validateCodeInValueSet(
      ValidationSupportContext theValidationSupportContext,
      ConceptValidationOptions theOptions,
      String theCodeSystem,
      String theCode,
      String theDisplay,
      @NotNull IBaseResource theValueSet) {
    String valueSetUrl =
        DefaultProfileValidationSupport.getConformanceResourceUrl(myCtx, theValueSet);

    LOG.debug("Checks if the ValueSet '{}' contains the code '{}'", valueSetUrl, theCode);

    Parameters input = new Parameters();
    ParametersUtil.addParameterToParametersUri(getFhirContext(), input, "url", valueSetUrl);

    if (theOptions != null && theOptions.isInferSystem()) {
      ValueSet valueSet =
          client
              .operation()
              .onType(ValueSet.class)
              .named("expand")
              .withParameters(input)
              .returnResourceType(ValueSet.class)
              .execute();

      ValueSet.ValueSetExpansionComponent expansion = valueSet.getExpansion();
      Optional<ValueSet.ValueSetExpansionContainsComponent> optCode =
          expansion.getContains().stream()
              .filter(
                  valueSetExpansionContainsComponent ->
                      Objects.equals(valueSetExpansionContainsComponent.getCode(), theCode))
              .findFirst();

      if (optCode.isPresent()) {
        ValueSet.ValueSetExpansionContainsComponent code = optCode.get();
        return new CodeValidationResult().setCode(code.getCode()).setDisplay(code.getDisplay());
      } else {
        return new CodeValidationResult()
            .setSeverity(IssueSeverity.ERROR)
            .setMessage(
                messages.getMessage(
                    "validation.terminology.expand", new Object[] {theCode, valueSetUrl}));
      }
    } else {
      ParametersUtil.addParameterToParametersUri(getFhirContext(), input, "system", theCodeSystem);
      ParametersUtil.addParameterToParametersString(getFhirContext(), input, "code", theCode);

      Parameters output =
          client
              .operation()
              .onType(ValueSet.class)
              .named("validate-code")
              .withParameters(input)
              .returnResourceType(Parameters.class)
              .execute();

      List<String> resultValues =
          ParametersUtil.getNamedParameterValuesAsString(getFhirContext(), output, "result");
      if (resultValues.isEmpty() || isBlank(resultValues.get(0))) {
        return null;
      }

      BooleanType result = (BooleanType) output.getParameter("result");
      if (result.booleanValue()) {
        StringType display = (StringType) output.getParameter("display");
        return new CodeValidationResult().setCode(theCode).setDisplay(display.getValue());
      } else {
        return new CodeValidationResult()
            .setSeverity(IssueSeverity.WARNING)
            .setMessage(
                messages.getMessage(
                    "validation.terminology.validateCodeInValueSet",
                    new Object[] {theCode, theCodeSystem, valueSetUrl}));
      }
    }
  }

  @Override
  public void setMessageSource(@NonNull MessageSource messageSource) {
    messages = new MessageSourceAccessor(messageSource);
  }
}
