package org.ehrbase.fhirbridge.ehr.converter.specific.patient;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.converter.generic.EntryEntityConverter;
import org.ehrbase.fhirbridge.ehr.opt.geccopersonendatencomposition.definition.AlterObservation;

import org.hl7.fhir.r4.model.Age;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Patient;

import java.time.Period;
import java.time.ZonedDateTime;

public class AlterObservationConverter extends EntryEntityConverter<Patient, AlterObservation> {

    @Override
    protected AlterObservation convertInternal(Patient resource) {

        AlterObservation age = null;

        Extension extensionAge = resource.getExtensionByUrl("https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/age");

        if (extensionAge != null) {

            DateTimeType dateTimeOfDocumentationDt = (DateTimeType) extensionAge.getExtensionByUrl("dateTimeOfDocumentation").getValue();
            ZonedDateTime dateTimeOfDocumentation = dateTimeOfDocumentationDt.getValueAsCalendar().toZonedDateTime();

            //TODO refactor

            age = new AlterObservation();
            age.setOriginValue(dateTimeOfDocumentation);
            age.setTimeValue(dateTimeOfDocumentation);
            //age - Alter (ISO8601 duration e.g. P67Y)
            age.setAlterValue(getAge(extensionAge));
        }

        return age;
    }

    private Period getAge(Extension extensionAge){
        Age ageValue = (Age) extensionAge.getExtensionByUrl("age").getValue();
        if(ageValue.hasValue()){
            return Period.ofYears(ageValue.getValue().intValue());
        }else if(ageValue.hasCode()){
          return getCodeAsInt(ageValue.getCode());
        }else{
            throw new UnprocessableEntityException("No age value for the Patient was found");
        }
    }

    private Period getCodeAsInt(String code) {
        try{
            return Period.ofYears(Integer.parseInt(code));
        }catch (NumberFormatException numberFormatException){
            throw new UnprocessableEntityException("The code " + code + " is not a valid age. Please enter an integer");
        }
    }
}

