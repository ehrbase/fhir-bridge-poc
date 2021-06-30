package org.ehrbase.fhirbridge.ehr.converter.specific.impfstatus;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.converter.generic.EntryEntityConverter;
import org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition.AussageUeberAbwesenheitDefiningCode;
import org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition.UnbekannterImpfstatusEvaluation;
import org.hl7.fhir.r4.model.Immunization;

public class UnbekannterImpfstatusEvaluationConverter extends EntryEntityConverter<Immunization, UnbekannterImpfstatusEvaluation> {

    @Override
    protected UnbekannterImpfstatusEvaluation convertInternal(Immunization resource) {
        UnbekannterImpfstatusEvaluation unbekannterImpfstatusEvaluation = new UnbekannterImpfstatusEvaluation();
        unbekannterImpfstatusEvaluation.setAussageUeberAbwesenheitDefiningCode(mapAussageUeberAbwesenheitCode(resource));
        return unbekannterImpfstatusEvaluation;
    }

    private AussageUeberAbwesenheitDefiningCode mapAussageUeberAbwesenheitCode(Immunization resource) {
        if(resource.getVaccineCode().getCoding().get(0).getCode().equals(AussageUeberAbwesenheitDefiningCode.NO_KNOWN_IMMUNIZATIONS.getCode())){
            return AussageUeberAbwesenheitDefiningCode.NO_KNOWN_IMMUNIZATIONS;
        }else if(resource.getVaccineCode().getCoding().get(0).getCode().equals(AussageUeberAbwesenheitDefiningCode.NO_INFORMATION_ABOUT_IMMUNIZATIONS.getCode())){
            return AussageUeberAbwesenheitDefiningCode.NO_INFORMATION_ABOUT_IMMUNIZATIONS;
        }else{
            throw new UnprocessableEntityException("The code "+resource.getVaccineCode().getCoding().get(0).getCode()+" is not supported by the fhir bridge ");
        }
    }
}
