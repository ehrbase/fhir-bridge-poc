package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisElement;
import org.hl7.fhir.r4.model.Observation;

import java.util.ArrayList;
import java.util.List;

public class ProAnalytQuantitativesErgebnisElementConverter {

    public ProAnalytQuantitativesErgebnisElement convert(Observation observation){

        ProAnalytQuantitativesErgebnisElement proAnalytQuantitativesErgebnisElement = new ProAnalytQuantitativesErgebnisElement();
        List <ProAnalytQuantitativesErgebnisChoice> proAnalytQuantitativesErgebnisChoiceList = new ArrayList<>();
        if (observation.getValueQuantity().hasUnit()){
            proAnalytQuantitativesErgebnisChoiceList.add(new ProAnalytQuantitativesErgebnisChoiceConverter().convertDvQuantity(observation));
        }else {
            proAnalytQuantitativesErgebnisChoiceList.add(new ProAnalytQuantitativesErgebnisChoiceConverter().convertDvCount(observation));
        }
        proAnalytQuantitativesErgebnisElement.setValue2(proAnalytQuantitativesErgebnisChoiceList);

        return proAnalytQuantitativesErgebnisElement;
    }

}
