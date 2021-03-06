package org.ehrbase.fhirbridge.ehr.converter.specific.patient;

import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.ehr.converter.generic.EntryEntityConverter;
import org.ehrbase.fhirbridge.ehr.converter.generic.TimeConverter;
import org.ehrbase.fhirbridge.ehr.opt.geccopersonendatencomposition.definition.AlterObservation;

import org.hl7.fhir.r4.model.Age;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Patient;

import java.time.Period;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAccessor;

public class AlterObservationConverter extends EntryEntityConverter<Patient, AlterObservation> {

    @Override
    protected AlterObservation convertInternal(Patient resource) {
        AlterObservation age = new AlterObservation();
        Extension extensionAge = resource.getExtensionByUrl("https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/age");
        if (extensionAge != null) {
            TemporalAccessor time = TimeConverter.convertAgeExtensionTime(extensionAge); //should be sth. generic in TimeConverter?
            age.setOriginValue(time);
            age.setTimeValue(time);
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
            throw new ConversionException("No age value for the Patient was found");
        }
    }

    private Period getCodeAsInt(String code) {
        try{
            return Period.ofYears(Integer.parseInt(code));
        }catch (NumberFormatException numberFormatException){
            throw new ConversionException("The code " + code + " is not a valid age. Please enter an integer");
        }
    }
}

