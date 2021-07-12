package org.ehrbase.fhirbridge.ehr.converter.specific.geccodiagnose;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.ehr.converter.generic.EntryEntityConverter;
import org.ehrbase.fhirbridge.ehr.converter.generic.TimeConverter;
import org.ehrbase.fhirbridge.ehr.converter.specific.CodeSystem;
import org.ehrbase.fhirbridge.ehr.opt.geccodiagnosecomposition.definition.KoerperstelleCluster;
import org.ehrbase.fhirbridge.ehr.opt.geccodiagnosecomposition.definition.VorliegendeDiagnoseEvaluation;
import org.hl7.fhir.r4.model.Annotation;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Condition;

import java.util.List;

public class VorliegendeDiagnoseEvaluationConverter extends EntryEntityConverter<Condition, VorliegendeDiagnoseEvaluation> {

    boolean isEmpty = true;

    @Override
    protected VorliegendeDiagnoseEvaluation convertInternal(Condition resource) {
        isEmpty = true;
        VorliegendeDiagnoseEvaluation vorliegendeDiagnose = new VorliegendeDiagnoseEvaluation();
        mapNameDesProblemsDerDiagnose(resource, vorliegendeDiagnose);
        mapBodySite(resource, vorliegendeDiagnose);
        mapSeverity(resource, vorliegendeDiagnose);
        mapKommentar(resource, vorliegendeDiagnose);
        mapDates(resource, vorliegendeDiagnose);
        return vorliegendeDiagnose;
    }

    private void mapKommentar(Condition condition, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (condition.hasNote()) {
            StringBuilder kommentar = new StringBuilder();
            for (Annotation annotation : condition.getNote()) {
                kommentar.append(annotation.getText());
            }
            vorliegendeDiagnose.setKommentarValue(kommentar.toString());
            isEmpty = false;
        }

    }

    private void mapDates(Condition condition, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (condition.hasOnset()) {
            vorliegendeDiagnose.setDatumZeitpunktDesAuftretensDerErstdiagnoseValue(TimeConverter.convertConditionTime(condition));
            isEmpty = false;
        }
        if (condition.hasAbatement() && TimeConverter.convertConditionAbatementTime(condition).isPresent()) {
            vorliegendeDiagnose.setDatumZeitpunktDerGenesungValue(TimeConverter.convertConditionAbatementTime(condition).get());
            isEmpty = false;
        }
    }

    private void mapSeverity(Condition condition, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (condition.hasSeverity()) {
            for (Coding coding : condition.getSeverity().getCoding()) {
                convertSevertiy(coding, vorliegendeDiagnose);
            }
        }
    }

    private void convertSevertiy(Coding coding, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (coding.getSystem().equals(CodeSystem.SNOMED.getUrl()) && GeccoDiagnoseCodeDefiningCodeMaps.getSchweregradMap().containsKey(coding.getCode())) {
            vorliegendeDiagnose.setSchweregradDefiningCode(GeccoDiagnoseCodeDefiningCodeMaps.getSchweregradMap().get(coding.getCode()));
            isEmpty = false;
        } else {
            throw new UnprocessableEntityException("Severity contains either a wrong code or code system.");
        }
    }

    private void mapBodySite(Condition condition, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (condition.hasBodySite()) {
            for (Coding bodySite : condition.getBodySite().get(0).getCoding()) {
                if (bodySite.getSystem().equals(CodeSystem.SNOMED.getUrl()) && GeccoDiagnoseCodeDefiningCodeMaps.getKoerperstelleMap().containsKey(bodySite.getCode())) {
                    KoerperstelleCluster korperstelleCluster = new KoerperstelleCluster();
                    korperstelleCluster.setNameDerKoerperstelleDefiningCode(GeccoDiagnoseCodeDefiningCodeMaps.getKoerperstelleMap().get(bodySite.getCode()));
                    addKoerperstelleCluster(korperstelleCluster, vorliegendeDiagnose);
                    isEmpty = false;
                } else {
                    throw new UnprocessableEntityException("Bodysite contains either a wrong code or code system.");
                }
            }
        }
    }

    private void addKoerperstelleCluster(KoerperstelleCluster korperstelleCluster, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        if (vorliegendeDiagnose.getKoerperstelle() == null || vorliegendeDiagnose.getKoerperstelle().size() == 0) {
            vorliegendeDiagnose.setKoerperstelle(List.of(korperstelleCluster));
        } else {
            vorliegendeDiagnose.getKoerperstelle().add(korperstelleCluster);
        }
        isEmpty = false;
    }

    private void mapNameDesProblemsDerDiagnose(Condition condition, VorliegendeDiagnoseEvaluation vorliegendeDiagnose) {
        for (Coding coding : condition.getCode().getCoding()) {
            if (coding.getSystem().equals(CodeSystem.SNOMED.getUrl()) &&
                    GeccoDiagnoseCodeDefiningCodeMaps.getNameDesProblemDiagnoseMap().containsKey(coding.getCode())) {
                vorliegendeDiagnose.setNameDesProblemsDerDiagnoseDefiningCode(GeccoDiagnoseCodeDefiningCodeMaps.getNameDesProblemDiagnoseMap().get(coding.getCode()));
                isEmpty = false;
            }else{
                throw new ConversionException("The SNOMED code is either not SNOMED code at all or one that is not supported by the FHIR profile.");
            }
        }
    }

    public boolean getIsEmpty() {
        return isEmpty;
    }
}

