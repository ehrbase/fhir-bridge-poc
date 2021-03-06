package org.ehrbase.fhirbridge.ehr.converter.specific.patientenaufenthalt;

import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.ehr.converter.generic.EncounterToCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.patientenaufenthaltcomposition.PatientenaufenthaltComposition;
import org.ehrbase.fhirbridge.ehr.opt.patientenaufenthaltcomposition.definition.AbteilungsfallCluster;
import org.ehrbase.fhirbridge.ehr.opt.patientenaufenthaltcomposition.definition.VersorgungsfallCluster;
import org.ehrbase.fhirbridge.ehr.opt.patientenaufenthaltcomposition.definition.VersorgungstellenkontaktCluster;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Identifier;
import org.springframework.lang.NonNull;

import static org.ehrbase.fhirbridge.ehr.converter.specific.CodeSystem.KONTAKT_EBENE;


public class PatientenAufenthaltCompositionConverter extends EncounterToCompositionConverter<PatientenaufenthaltComposition> {

    @Override
    public PatientenaufenthaltComposition convertInternal(@NonNull Encounter encounter) {

        PatientenaufenthaltComposition retVal = new PatientenaufenthaltComposition();

        if (!encounter.getIdentifier().isEmpty() && !encounter.getType().isEmpty()) {

            setFallCluster(retVal, encounter);
        }

        retVal.setVersorgungsaufenthalt(new VersorgungsaufenthaltAdminEntryConverter().convert(encounter));

        return retVal;
    }

    private void setFallCluster(PatientenaufenthaltComposition composition, Encounter encounter) {

        Coding coding = encounter.getType().get(0).getCoding().get(0);

        if (!coding.getSystem().equals(KONTAKT_EBENE.getUrl())) {

            throw new ConversionException("Invalid Code system " + coding.getSystem() +
                    " valid code system: " + KONTAKT_EBENE.getUrl());
        }

        Identifier encounterIdentifier = encounter.getIdentifier().get(0);

        String typeCode = coding.getCode();

        switch (typeCode) {

            case "einrichtungskontakt": {
                VersorgungsfallCluster versorgungsfallCluster = new VersorgungsfallCluster();
                versorgungsfallCluster.setZugehoerigerVersorgungsfallKennungValue(encounterIdentifier.getValue());
                composition.setVersorgungsfall(versorgungsfallCluster);
                break;
            }
            case "abteilungskontakt": {
                AbteilungsfallCluster abteilungsfallCluster = new AbteilungsfallCluster();
                abteilungsfallCluster.setZugehoerigerAbteilungsfallKennungValue(encounterIdentifier.getValue());
                composition.setAbteilungsfall(abteilungsfallCluster);
                break;
            }
            case "versorgungsstellenkontakt": {
                VersorgungstellenkontaktCluster versorgungstellenkontaktCluster = new VersorgungstellenkontaktCluster();
                versorgungstellenkontaktCluster.setZugehoerigerVersorgungsstellenkontaktKennungValue(encounterIdentifier.getValue());
                composition.setVersorgungstellenkontakt(versorgungstellenkontaktCluster);
                break;
            }
            default: {
                throw new ConversionException("Invalid Code " + typeCode +
                        " or Code System as 'Kontaktebene', valid codes are einrichtungskontakt, abteilungskontakt, versorgungsstellenkontakt.");
            }
        }
    }

}
