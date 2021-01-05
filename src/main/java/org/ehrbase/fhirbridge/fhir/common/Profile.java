package org.ehrbase.fhirbridge.fhir.common;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.Resource;

public enum Profile {

  // Condition Profiles

  DEFAULT_CONDITION(Condition.class, null),

  SYMPTOMS_COVID_19(
      Condition.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/symptoms-covid-19"),

  // DiagnosticReport Profiles

  DIAGNOSTIC_REPORT_LAB(
      DiagnosticReport.class,
      "https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab"),

  // Observation Profiles

  BODY_HEIGHT(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/body-height"),

  BLOOD_PRESSURE(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/blood-pressure"),

  BODY_TEMP(Observation.class, "http://hl7.org/fhir/StructureDefinition/bodytemp"),

  BODY_WEIGHT(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/body-weight"),

  CLINICAL_FRAILTY_SCALE(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/frailty-score"),

  CORONARIRUS_NACHWEIS_TEST(
      Observation.class,
      "https://charite.infectioncontrol.de/fhir/core/StructureDefinition/CoronavirusNachweisTest"),

  FIO2(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/inhaled-oxygen-concentration"),

  HEART_RATE(Observation.class, "http://hl7.org/fhir/StructureDefinition/heartrate"),

  PATIENT_IN_ICU(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/patient-in-icu"),

  PREGNANCY_STATUS(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pregnancy-status"),

  OBSERVATION_LAB(
      Observation.class,
      "https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/ObservationLab"),

  RESPIRATORY_RATE(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/respiratory-rate"),

  SOFA_SCORE(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/sofa-score"),

  SMOKING_STATUS(
      Observation.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/smoking-status"),

  // Patient Profiles

  PATIENT(
      Patient.class,
      "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/Patient"),

  // Procedure Profiles

  PROCEDURE(
      Procedure.class,
      "https://www.medizininformatik-initiative.de/fhir/core/modul-prozedur/StructureDefinition/Procedure"),

  // QuestionnaireResponse Profiles

  DEFAULT_QUESTIONNAIRE_RESPONSE(QuestionnaireResponse.class, null);

  private final Class<? extends Resource> resourceType;

  private final String uri;

  <T extends Resource> Profile(Class<T> resourceType, String uri) {
    this.resourceType = resourceType;
    this.uri = uri;
  }

  public static <T extends Resource> Profile getDefaultProfile(Class<T> resourceType) {
    for (Profile profile : values()) {
      if (profile.isAssignable(resourceType) && profile.isDefault()) {
        return profile;
      }
    }
    return null;
  }

  public static <T extends Resource> Set<Profile> getSupportedProfiles(Class<T> resourceType) {
    return Arrays.stream(values())
        .filter(profile -> profile.isAssignable(resourceType))
        .collect(Collectors.toCollection(LinkedHashSet::new));
  }

  public static Set<Profile> resolveAll(Resource resource) {
    return resource.getMeta().getProfile().stream()
        .map(uri -> Profile.resolve(resource.getClass(), uri.getValue()))
        .filter(Objects::nonNull)
        .collect(Collectors.toUnmodifiableSet());
  }

  public static <T extends Resource> Profile resolve(Class<T> resourceType, String uri) {
    for (Profile profile : values()) {
      if (profile.isAssignable(resourceType) && Objects.equals(profile.getUri(), uri)) {
        return profile;
      }
    }
    return null;
  }

  public Class<? extends Resource> getResourceType() {
    return resourceType;
  }

  public String getUri() {
    return uri;
  }

  public <T extends Resource> boolean isAssignable(Class<T> resourceType) {
    return getResourceType() == resourceType;
  }

  public boolean isDefault() {
    return uri == null;
  }

  @Override
  public String toString() {
    return uri;
  }
}
