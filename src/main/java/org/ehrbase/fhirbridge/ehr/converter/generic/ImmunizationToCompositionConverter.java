package org.ehrbase.fhirbridge.ehr.converter.generic;

import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.hl7.fhir.r4.model.Immunization;
import org.springframework.lang.NonNull;

public abstract class ImmunizationToCompositionConverter<C extends CompositionEntity> extends CompositionConverter<Immunization, C>{

    @Override
    public C convert(@NonNull Immunization resource) {
        C composition = super.convert(resource);
        composition.setStartTimeValue(TimeConverter.convertImmunizationTime(resource)); // occurenceTime
        return composition;
    }
}
