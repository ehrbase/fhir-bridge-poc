package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import org.ehrbase.fhirbridge.ehr.converter.generic.ObservationToCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.VirologischerBefundComposition;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.FallidentifikationCluster;

import org.hl7.fhir.r4.model.Observation;
import org.springframework.lang.NonNull;
import org.hl7.fhir.r4.model.DiagnosticReport;

public class VirologischerBefundCompositionConverter extends ObservationToCompositionConverter<VirologischerBefundComposition> {

        @Override
        public VirologischerBefundComposition convertInternal(@NonNull Observation resource) {

            VirologischerBefundComposition composition = new VirologischerBefundComposition();

            VirologischerBefundBundle virologischerBefundBundle = new VirologischerBefundBundle(resource);
            Observation observation = virologischerBefundBundle.getVirologischerBefund();

            DiagnosticReport diagnosticReport = virologischerBefundBundle.getDiagnosticReport();

            observation.setSpecimenTarget(virologischerBefundBundle.getSpecimen());

            mapStatus(composition, diagnosticReport);
            mapFallIdentifikation(composition, diagnosticReport);
            composition.setBefund(new VirologischerBefundObservationConverter().convert(observation));

            return composition;
        }

    private void mapStatus(VirologischerBefundComposition composition, DiagnosticReport diagnosticReport) {
        String codeString = diagnosticReport.getStatusElement().toString();
        composition.setStatusValue(codeString);
    }

    private void mapFallIdentifikation(VirologischerBefundComposition composition, DiagnosticReport diagnosticReport) {
        FallidentifikationCluster fallidentifikationCluster = new FallidentifikationCluster();
        String codeString = diagnosticReport.getEncounter().getReference();
        fallidentifikationCluster.setFallKennungValue(codeString);
        composition.setFallidentifikation(fallidentifikationCluster);
    }

}
