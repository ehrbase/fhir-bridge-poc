package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisDvQuantity;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisDvMultimedia;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisDvCount;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusElement;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import java.util.ArrayList;
import java.util.List;

public class ProAnalytQuantitativesErgebnisChoiceConverter extends ProAnalytQuantitativesErgebnisDvQuantity{

    public ProAnalytQuantitativesErgebnisChoice convertDvQuantity(Observation observation){

        ProAnalytQuantitativesErgebnisDvQuantity proAnalytQuantitativesErgebnisDvQuantity = new ProAnalytQuantitativesErgebnisDvQuantity();

        proAnalytQuantitativesErgebnisDvQuantity.setQuantitativesErgebnisMagnitude(observation.getValueQuantity().getValue().doubleValue());
        proAnalytQuantitativesErgebnisDvQuantity.setQuantitativesErgebnisUnits(observation.getValueQuantity().getUnit());

        return proAnalytQuantitativesErgebnisDvQuantity;

    }

    public ProAnalytQuantitativesErgebnisChoice convertDvCount(Observation observation){

        ProAnalytQuantitativesErgebnisDvCount proAnalytQuantitativesErgebnisDvCount = new ProAnalytQuantitativesErgebnisDvCount();

        proAnalytQuantitativesErgebnisDvCount.setQuantitativesErgebnisMagnitude(observation.getValueQuantity().getValue().longValue());

        return proAnalytQuantitativesErgebnisDvCount;

    }

}
