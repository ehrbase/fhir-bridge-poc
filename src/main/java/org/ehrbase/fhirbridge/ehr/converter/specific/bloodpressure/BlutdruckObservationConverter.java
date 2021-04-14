package org.ehrbase.fhirbridge.ehr.converter.specific.bloodpressure;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.converter.generic.ObservationToObservationConverter;
import org.ehrbase.fhirbridge.ehr.opt.blutdruckcomposition.definition.BlutdruckObservation;
import org.hl7.fhir.r4.model.Observation;

public class BlutdruckObservationConverter extends ObservationToObservationConverter<BlutdruckObservation> {
    @Override
    protected BlutdruckObservation convertInternal(Observation resource) {
        BlutdruckObservation bloodPressure = new BlutdruckObservation();
        try {
            double systolicBPValue = resource.getComponent().get(0).getValueQuantity().getValue().doubleValue();
            String systolicBPUnit = resource.getComponent().get(0).getValueQuantity().getCode(); //mmHg, mm[Hg]
            bloodPressure.setSystolischMagnitude(systolicBPValue);
            bloodPressure.setSystolischUnits(systolicBPUnit);
            double diastolicBPValue = resource.getComponent().get(1).getValueQuantity().getValue().doubleValue();
            String diastolicBPUnit = resource.getComponent().get(1).getValueQuantity().getCode();
            bloodPressure.setDiastolischMagnitude(diastolicBPValue);
            bloodPressure.setDiastolischUnits(diastolicBPUnit);
        } catch (Exception e) {
            throw new UnprocessableEntityException(e.getMessage());
        }
        return bloodPressure;
    }
}
