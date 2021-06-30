package org.ehrbase.fhirbridge.fhir.support;

import org.apache.commons.lang3.StringUtils;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.hl7.fhir.r4.model.CanonicalType;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Consent;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.PrimitiveType;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressWarnings("java:S6212")
public class Resources {

    public static final String RFC_4122_SYSTEM = "urn:ietf:rfc:4122";

    private static final String COVID_19_QUESTIONNAIRE_URL = "http://fhir.data4life.care/covid-19/r4/Questionnaire/covid19-recommendation";

    private Resources() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isPatient(Resource resource) {
        return resource != null && resource.getResourceType() == ResourceType.Patient;
    }

    public static boolean isQuestionnaireResponse(Resource resource) {
        return resource != null && resource.getResourceType() == ResourceType.QuestionnaireResponse;
    }

    public static boolean isCovid19Questionnaire(Resource resource) {
        return isQuestionnaireResponse(resource) &&
                StringUtils.contains(((QuestionnaireResponse) resource).getQuestionnaire(), COVID_19_QUESTIONNAIRE_URL);
    }

    public static Optional<Reference> getSubject(Resource resource) {
        switch (resource.getResourceType()) {
            case Condition:
                return getSubject((Condition) resource);
            case Consent:
                return getSubject((Consent) resource);
            case DiagnosticReport:
                return getSubject((DiagnosticReport) resource);
            case Encounter:
                return getSubject((Encounter) resource);
            case Immunization:
                    return getSubject((Immunization) resource);
            case MedicationStatement:
                return getSubject((MedicationStatement) resource);
            case Observation:
                return getSubject((Observation) resource);
            case Procedure:
                return getSubject((Procedure) resource);
            case QuestionnaireResponse:
                return getSubject((QuestionnaireResponse) resource);
            default:
                throw new IllegalArgumentException("Unsupported resource type: " + resource.getResourceType());
        }
    }

    public static Optional<Reference> getSubject(Condition condition) {
        return condition.hasSubject() ? Optional.of(condition.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(Consent consent) {
        return consent.hasPatient() ? Optional.of(consent.getPatient()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(Immunization immunization) {
        return immunization.hasPatient() ? Optional.of(immunization.getPatient()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(DiagnosticReport diagnosticReport) {
        return diagnosticReport.hasSubject() ? Optional.of(diagnosticReport.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(Encounter encounter) {
        return encounter.hasSubject() ? Optional.of(encounter.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(MedicationStatement medicationStatement) {
        return medicationStatement.hasSubject() ? Optional.of(medicationStatement.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(Observation observation) {
        return observation.hasSubject() ? Optional.of(observation.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(Procedure procedure) {
        return procedure.hasSubject() ? Optional.of(procedure.getSubject()) : Optional.empty();
    }

    public static Optional<Reference> getSubject(QuestionnaireResponse questionnaireResponse) {
        return questionnaireResponse.hasSubject() ? Optional.of(questionnaireResponse.getSubject()) : Optional.empty();
    }

    public static List<String> getProfileUris(Resource resource) {
        return resource.getMeta().getProfile()
                .stream()
                .map(CanonicalType::getValue)
                .collect(Collectors.toUnmodifiableList());
    }

    public static boolean hasProfile(Resource resource, Profile profile) {
        return hasAnyProfile(resource, profile);
    }

    public static boolean hasAnyProfile(Resource resource, Profile... profiles) {
        Set<String> c1 = resource.getMeta().getProfile()
                .stream()
                .map(PrimitiveType::getValue)
                .collect(Collectors.toSet());
        Set<String> c2 = Arrays.stream(profiles)
                .map(Profile::getUri)
                .collect(Collectors.toSet());

        return !Collections.disjoint(c1, c2);
    }
}
