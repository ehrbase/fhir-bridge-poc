package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Specimen;
import org.hl7.fhir.r4.model.Resource;

public class VirologischerBefundBundle {

    private Observation virologischerBefund = new Observation();
    private DiagnosticReport diagnosticReport = new DiagnosticReport();
    private Specimen specimen = new Specimen();

    public VirologischerBefundBundle(Observation observation) {
        setResources(observation);
    }

    private void setResources(Observation observation) {
        virologischerBefund = observation;
        for (Resource resource : observation.getContained()) {
            setProfiles(resource);
        }
    }

    private void setProfiles(Resource resource) {
        try {
            String profileUrl = resource.getMeta().getProfile().get(0).getValue();

            if (VirologischerBefundProfileUrl.DIAGNOSTIC_REPORT.getUrl().equals(profileUrl)) {
                this.diagnosticReport = (DiagnosticReport) resource;

            } else if (VirologischerBefundProfileUrl.SPECIMEN.getUrl().equals(profileUrl)) {
                this.specimen = (Specimen) resource;

            } else {
                throw new UnprocessableEntityException("Virologischer Befund bundle needs to contain only the profiles for the Virologischer Befund. Please delete profile " + profileUrl + " from the Bundle.");
            }

        } catch (IndexOutOfBoundsException e) {
            throw new UnprocessableEntityException("Make sure only the for Virologischer Befund supported Profiles are contained in the Bundle these are: Virologischer Befund, Diagnostic Report and Specimen");
        }
    }

    public Observation getVirologischerBefund() {
        return virologischerBefund;
    }

    public DiagnosticReport getDiagnosticReport() {
        return diagnosticReport;
    }

    public Specimen getSpecimen() {
        return specimen;
    }



}
