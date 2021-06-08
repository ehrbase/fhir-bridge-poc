package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusElement;

import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusChoice;
import org.hl7.fhir.r4.model.Observation;

import java.util.ArrayList;
import java.util.List;

public class ProAnalytErgebnisStatusElementConverter extends ProAnalytErgebnisStatusElement {


    public ProAnalytErgebnisStatusElement convert(Observation observation){

        ProAnalytErgebnisStatusElement proAnalytErgebnisStatusElement = new ProAnalytErgebnisStatusElement();
        List <ProAnalytErgebnisStatusChoice>  proAnalytErgebnisStatusChoiceList = new ArrayList<>();

        proAnalytErgebnisStatusChoiceList.add(new ProAnalytErgebnisStatusChoiceConverter().convertDvCodedText(observation));
        proAnalytErgebnisStatusChoiceList.add(new ProAnalytErgebnisStatusChoiceConverter().convertDvText(observation));

        proAnalytErgebnisStatusElement.setValue2(proAnalytErgebnisStatusChoiceList);

        return proAnalytErgebnisStatusElement;

    }


}
