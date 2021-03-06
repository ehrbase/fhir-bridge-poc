package org.ehrbase.fhirbridge.ehr.converter.generic;

import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;

public abstract class PatientToCompositionConverter<C extends CompositionEntity> extends CompositionConverter<Patient, C> {

    @Override
    public C convert(@NonNull Patient resource) {
        C composition = super.convert(resource);
        Extension extensionAge = resource.getExtensionByUrl("https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/age");
        composition.setStartTimeValue(TimeConverter.convertAgeExtensionTime(extensionAge));
        return composition;
    }
}
