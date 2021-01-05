package org.ehrbase.fhirbridge.ehr.converter;

import java.util.EnumMap;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class CompositionConverterResolver implements InitializingBean {

  private final EnumMap<Profile, CompositionConverter<?, ?>> profiles =
      new EnumMap<>(Profile.class);

  @SuppressWarnings("java:S1452")
  public CompositionConverter<?, ?> resolve(Profile profile) {
    CompositionConverter<?, ?> compositionConverter = profiles.get(profile);
    if (compositionConverter == null) {
      throw new IllegalArgumentException(
          "No CompositionConverter defines for profile '" + profile + "'");
    }
    return compositionConverter;
  }

  @Override
  public void afterPropertiesSet() {
    // Conditions
    profiles.put(Profile.DEFAULT_CONDITION, new DiagnoseCompositionConverter());
    profiles.put(Profile.SYMPTOMS_COVID_19, new SymptomCompositionConverter());
    // Observations
    profiles.put(Profile.DIAGNOSTIC_REPORT_LAB, new DiagnosticReportLabCompositionConverter());
    profiles.put(Profile.BODY_HEIGHT, new BodyHeightCompositionConverter());
    profiles.put(Profile.BLOOD_PRESSURE, new BloodPressureCompositionConverter());
    profiles.put(Profile.BODY_TEMP, new BodyTemperatureCompositionConverter());
    profiles.put(Profile.BODY_WEIGHT, new BodyWeightCompositionConverter());
    profiles.put(
        Profile.CLINICAL_FRAILTY_SCALE, new ClinicalFrailtyScaleScoreCompositionConverter());
    profiles.put(
        Profile.CORONARIRUS_NACHWEIS_TEST, new CoronavirusNachweisTestCompositionConverter());
    profiles.put(Profile.FIO2, new FiO2CompositionConverter());
    profiles.put(Profile.HEART_RATE, new HeartRateCompositionConverter());
    profiles.put(Profile.PATIENT_IN_ICU, new PatientInIcuCompositionConverter());
    profiles.put(Profile.PREGNANCY_STATUS, new PregnancyStatusCompositionConverter());
    profiles.put(Profile.OBSERVATION_LAB, new ObservationLabCompositionConverter());
    profiles.put(Profile.RESPIRATORY_RATE, new RespiratoryRateCompositionConverter());
    profiles.put(Profile.SOFA_SCORE, new SofaScoreCompositionConverter());
    profiles.put(Profile.SMOKING_STATUS, new SmokingStatusCompositionConverter());
    profiles.put(Profile.PROCEDURE, new ProcedureCompositionConverter());
  }
}
