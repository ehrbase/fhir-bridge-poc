package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import org.ehrbase.fhirbridge.ehr.converter.generic.ObservationToObservationConverter;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.BefundJedesEreignisChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.BefundObservation;

import org.hl7.fhir.r4.model.Observation;

import java.util.ArrayList;
import java.util.List;


public class VirologischerBefundObservationConverter extends ObservationToObservationConverter<BefundObservation>{

    @Override
    protected BefundObservation convertInternal(Observation observation) {
        BefundObservation befundObservation = new BefundObservation();
        List<BefundJedesEreignisChoice> events = new ArrayList<>();
        events.add(new BefundJedesEreignisPointEventConverter().convert(observation));
        befundObservation.setJedesEreignis(events);

        return befundObservation;
    }
}

