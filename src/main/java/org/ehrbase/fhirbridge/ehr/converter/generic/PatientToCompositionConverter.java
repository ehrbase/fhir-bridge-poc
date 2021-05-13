package org.ehrbase.fhirbridge.ehr.converter.generic;

import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Patient;
import org.springframework.lang.NonNull;

import java.time.Instant;
import java.time.ZonedDateTime;

public abstract class PatientToCompositionConverter<C extends CompositionEntity> extends CompositionConverter<Patient, C> {

    @Override
    public C convert(@NonNull Patient resource) {
        C composition = super.convert(resource);
        if (resource.hasExtension() && resource.hasBirthDate()) {
            Extension extensionAge = resource.getExtensionByUrl("https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/age");
            if (extensionAge != null) {
                DateTimeType dateTimeOfDocumentationDt = (DateTimeType) extensionAge.getExtensionByUrl("dateTimeOfDocumentation").getValue();
                ZonedDateTime dateTimeOfDocumentation = dateTimeOfDocumentationDt.getValueAsCalendar().toZonedDateTime();
                composition.setStartTimeValue(dateTimeOfDocumentation);
            }
        } else {
            composition.setStartTimeValue(Instant.now());
        }
        return composition;
    }
}
