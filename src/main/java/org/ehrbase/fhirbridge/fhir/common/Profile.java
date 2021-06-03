package org.ehrbase.fhirbridge.fhir.common;

import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Consent;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.Encounter;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public enum Profile {

    // Condition Profiles

    DEFAULT_CONDITION(Condition.class, null),

    SYMPTOMS_COVID_19(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/symptoms-covid-19"),

    DIAGNOSE_LIVER_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/chronic-liver-diseases"),
    DIAGNOSE_LUNG_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/chronic-lung-diseases"),
    DIAGNOSE_DIABETES_MELLITUS(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/diabetes-mellitus"),
    DIAGNOSE_COVID_19(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/diagnosis-covid-19"),
    DIAGNOSE_MALIGNANT_NEOPLASTIC_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/malignant-neoplastic-disease"),
    DIAGNOSE_RHEUMATOLOGICAL_IMMUNOLOGICAL_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/rheumatological-immunological-diseases"),
    DIAGNOSE_CARDIOVASCULAR_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/cardiovascular-diseases"),
    DIAGNOSE_CHRONIC_KIDNEY_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/chronic-kidney-diseases"),
    DIAGNOSE_CHRONIC_NEUROLOGICAL_MENTAL_DISEASE(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/chronic-neurological-mental-diseases"),
    DIAGNOSE_GASTROINTESTINAL_ULCERS(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/gastrointestinal-ulcers"),
    DIAGNOSE_HIV(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/human-immunodeficiency-virus-infection"),
    DIAGNOSE_ORGAN_RECIPIENT(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/organ-recipient"),
    DIAGNOSE_COMPLICATIONS_COVID_19(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/complications-covid-19"),
    DIAGNOSE_DEPENDENCE_ON_VENTILATOR(Condition.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/dependence-on-ventilator"),

    // Consent Profiles

    DO_NOT_RESUSCITATE_ORDER(Consent.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/do-not-resuscitate-order"),

    // DiagnosticReport Profiles

    DIAGNOSTIC_REPORT_LAB(DiagnosticReport.class, "https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab"),

    DIAGNOSTIC_REPORT_RADIOLOGY(DiagnosticReport.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/diagnostic-report-radiology"),


    // MedicationStatement Profiles
    PHARMACOLOGICAL_THERAPY(MedicationStatement.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pharmacological-therapy"),
    PHARMACOLOGICAL_THERAPY_ACE_INHIBITORS(MedicationStatement.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pharmacological-therapy-ace-inhibitors"),
    PHARMACOLOGICAL_THERAPY_ANTICOAGULANTS(MedicationStatement.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pharmacological-therapy-anticoagulants"),
    PHARMACOLOGICAL_THERAPY_IMMUNOGLOBULINS(MedicationStatement.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pharmacological-therapy-immunoglobulins"),

    // Encounter Profiles
    KONTAKT_GESUNDHEIT_EINRICHTUNG(Encounter.class, null), // as default, has the same link like KONTAKT_GESUNDHEIT_ABTEILUNG

    KONTAKT_GESUNDHEIT_ABTEILUNG(Encounter.class, "https://www.medizininformatik-initiative.de/fhir/core/modul-fall/StructureDefinition/KontaktGesundheitseinrichtung"),

    // Observation Profiles

    TRAVEL_HISTORY(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/history-of-travel"),

    BODY_HEIGHT(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/body-height"),

    BLOOD_GAS_PANEL(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/blood-gas-panel"),

    BLOOD_PRESSURE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/blood-pressure"),

    BODY_TEMP(Observation.class, "http://hl7.org/fhir/StructureDefinition/bodytemp"),

    BODY_WEIGHT(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/body-weight"),

    CLINICAL_FRAILTY_SCALE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/frailty-score"),

    CLINICAL_TRIAL_PARTICIPATION(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/interventional-clinical-trial-participation"),

    CORONARIRUS_NACHWEIS_TEST(Observation.class, "https://charite.infectioncontrol.de/fhir/core/StructureDefinition/CoronavirusNachweisTest"),

    FIO2(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/inhaled-oxygen-concentration"),

    HEART_RATE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/heart-rate"),

    KNOWN_EXPOSURE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/known-exposure"),

    PACO2(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/carbon-dioxide-partial-pressure"),

    PAO2(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/oxygen-partial-pressure"),

    PATIENT_DISCHARGE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/discharge-disposition"),

    PATIENT_IN_ICU(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/patient-in-icu"),

    PCR(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/sars-cov-2-rt-pcr"),

    PH(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pH"),

    PREGNANCY_STATUS(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/pregnancy-status"),

    OBSERVATION_LAB(Observation.class, "https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/ObservationLab"),

    OXYGEN_SATURATION(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/oxygen-saturation"),

    RESPIRATORY_RATE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/respiratory-rate"),

    SOFA_SCORE(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/sofa-score"),

    SMOKING_STATUS(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/smoking-status"),

    ANTI_BODY_PANEL(Observation.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/sars-cov-2-ab-pnl-ser-pl-ia"),

    VIROLOGISCHER_BEFUND(Observation.class, "http://highmed.org/StructureDefinition/VirologischerBefund"),

    // Patient Profiles

    PATIENT(Patient.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/Patient"),

    // Procedure Profiles

    PROCEDURE(Procedure.class, "https://www.medizininformatik-initiative.de/fhir/core/modul-prozedur/StructureDefinition/Procedure"),


    APHERESIS_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/apheresis"),
    DIALYSIS_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/dialysis"),
    EXTRACORPOREAL_MEMBRANE_OXYGENATION_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/extracorporeal-membrane-oxygenation"),
    PRONE_POSITION_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/prone-position"),
    RADIOLOGY_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/radiology-procedures"),
    RESPIRATORY_THERAPIES_PROCEDURE(Procedure.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/respiratory-therapies"),

    // Consent profiles

    DNR_ORDER(Consent.class, "https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/do-not-resuscitate-order"),

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
