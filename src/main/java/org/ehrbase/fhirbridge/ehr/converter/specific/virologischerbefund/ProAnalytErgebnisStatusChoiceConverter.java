package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.support.identification.TerminologyId;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvCodedText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ErgebnisStatusDefiningCode;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Observation;

import java.lang.String;
import java.util.ArrayList;
import java.util.List;


public class ProAnalytErgebnisStatusChoiceConverter extends ProAnalytErgebnisStatusDvText {

    public ProAnalytErgebnisStatusChoice convertDvText(Observation observation){

        ProAnalytErgebnisStatusDvText proAnalytErgebnisStatusDvText = new ProAnalytErgebnisStatusDvText();

        String codeString = observation.getStatus().toString();
        proAnalytErgebnisStatusDvText.setErgebnisStatusValue(codeString);

        return proAnalytErgebnisStatusDvText;
    }

    public ProAnalytErgebnisStatusChoice convertDvCodedText(Observation observation){

        ProAnalytErgebnisStatusDvCodedText proAnalytErgebnisStatusDvCodedText = new ProAnalytErgebnisStatusDvCodedText();

        switch(observation.getStatus()){
            case FINAL:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND);
                break;
            case REGISTERED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ERFASST);
                break;
            case CORRECTED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND_KORRIGIERT);
                break;
            case AMENDED :
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND_GEAENDERT);
                break;
            case NULL:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.STORNIERT);
                break;
            case PRELIMINARY:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.VORLAEUFIG);
                break;
            case CANCELLED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND_WIDERRUFEN);
                break;
            default:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.UNVOLLSTAENDIG);
        }
        return proAnalytErgebnisStatusDvCodedText;
    }

}
