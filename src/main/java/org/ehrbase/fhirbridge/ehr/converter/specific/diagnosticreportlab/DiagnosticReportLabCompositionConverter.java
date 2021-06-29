package org.ehrbase.fhirbridge.ehr.converter.specific.diagnosticreportlab;

import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.ehr.converter.generic.DiagnosticReportToCompositionConverter;
import org.ehrbase.fhirbridge.ehr.converter.specific.observationlab.ObservationLabCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.GECCOLaborbefundComposition;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition.LaborergebnisObservation;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DiagnosticReportLabCompositionConverter extends DiagnosticReportToCompositionConverter<GECCOLaborbefundComposition> {

    private static final Logger LOG = LoggerFactory.getLogger(DiagnosticReportLabCompositionConverter.class);

    @Override
    protected GECCOLaborbefundComposition convertInternal(DiagnosticReport resource) {
        LOG.debug("Contained size: {}", resource.getContained().size());
        // one contained Observation is expected
        if (resource.getContained().size() != 1) {
            throw new ConversionException("One contained Observation was expected " + resource.getContained().size() + " were received in DiagnosticReport " + resource.getId());
        }
        if (resource.getContained().get(0).getResourceType() != ResourceType.Observation) {
            throw new ConversionException("One contained Observation was expected, contained is there but is not Observation, it is " + resource.getContained().get(0).getResourceType().toString());
        }
        Observation observation = (Observation) resource.getContained().get(0);
        GECCOLaborbefundComposition result = new ObservationLabCompositionConverter().convert(observation);
        LaborergebnisObservation laborbefund = new LaborergebnisObservationConverter().convertInternal(resource);
        result.setLaborergebnis(laborbefund);
        return result;
    }

}
