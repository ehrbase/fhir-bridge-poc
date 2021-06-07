package org.ehrbase.fhirbridge.fhir.bundle.validator;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.hl7.fhir.r4.model.Bundle;

import java.util.Map;


public class VirologischerBefundBundleValidator extends AbstractBundleValidator {

    private static final String VirologischerBefundUrl = "http://highmed.org/StructureDefinition/VirologischerBefund";
    private static final String SpecimenUrl = "http://highmed.org/StructureDefinition/Specimen";
    private static final String DiagnosticReportUrl ="http://highmed.org/fhir/StructureDefinition/ic/DiagnosticReportLab";

    private int VirologischerBefundProfilesContained = 0;
    private int SpecimenProfilesContained = 0;
    private int DiagnosticReportProfilesContained = 0;

    public void validateRequest(Object bundle, Map<String, Object> parameters) {
        super.validateRequest(bundle, parameters);
        validateVirologischerBefund((Bundle) bundle);
    }

    private void validateVirologischerBefund(Bundle bundle) {
        resetAttributes();
        for (Bundle.BundleEntryComponent entry : bundle.getEntry()) {
            validateProfiles(entry);
        }
        checkIfAtLeastOneObservationContained();
    }


    private void resetAttributes() {
        VirologischerBefundProfilesContained = 0;
        SpecimenProfilesContained = 0;
        DiagnosticReportProfilesContained = 0;
    }

    private void validateProfiles(Bundle.BundleEntryComponent entry) {
        try {
            String profileUrl = entry.getResource().getMeta().getProfile().get(0).getValue();
            switch (profileUrl) {
                case VirologischerBefundUrl:
                    setVirologischerBefund();
                    break;
                case SpecimenUrl:
                    SpecimenProfilesContained += 1;
                    break;
                case DiagnosticReportUrl:
                    DiagnosticReportProfilesContained += 1;
                    break;
                default:
                    throw new UnprocessableEntityException("Virologischer Befund bundle needs to contain only the profiles for the Virologischer Befund. Please delete profile " + profileUrl + " from the Bundle.");
            }

        } catch (IndexOutOfBoundsException e) {
            throw new UnprocessableEntityException("Make sure only the for Virologischer Befund supported Profiles are contained in the Bundle.");
        }
    }



    private void checkIfAtLeastOneObservationContained() {
        if (!checkIfOneProfileIsPresent()) {
            throw new UnprocessableEntityException("Virologischer Befund needs to contain at least one profile of VirologischerBefund, DiagnosticReport and Specimen.");
        }
    }


    private boolean checkIfOneProfileIsPresent() {
        return VirologischerBefundProfilesContained==1 && SpecimenProfilesContained==1 && DiagnosticReportProfilesContained==1;
    }

    private void setVirologischerBefund() {
        VirologischerBefundProfilesContained += 1;
        if (VirologischerBefundProfilesContained != 1) {
            throw new UnprocessableEntityException("Virologischer Befund profile is duplicated within the bundle, please delete one of them");
        }
    }


}
