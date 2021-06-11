package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvCodedText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ErgebnisStatusDefiningCode;
import org.hl7.fhir.r4.model.Observation;

import java.lang.String;


public class ProAnalytErgebnisStatusChoiceConverter {

    public ProAnalytErgebnisStatusChoice convertDvText(Observation observation){

        ProAnalytErgebnisStatusDvText proAnalytErgebnisStatusDvText = new ProAnalytErgebnisStatusDvText();

        String codeString = observation.getStatus().toString();
        proAnalytErgebnisStatusDvText.setErgebnisStatusValue(codeString);

        return proAnalytErgebnisStatusDvText;
    }

    public ProAnalytErgebnisStatusChoice convertDvCodedText(Observation observation){

        ProAnalytErgebnisStatusDvCodedText proAnalytErgebnisStatusDvCodedText = new ProAnalytErgebnisStatusDvCodedText();

        switch(observation.getStatus()){
            case REGISTERED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.REGISTRIERT);
                break;
            case PRELIMINARY:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.VORLAEUFIG);
                break;
            case FINAL:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND);
                break;
            case AMENDED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ERGAENZT);
                break;
            case CORRECTED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.KORRIGIERT);
                break;
            case CANCELLED:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.STORNIERT);
                break;
            case ENTEREDINERROR:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.ENDBEFUND_WIDERRUFEN);
                break;
            default:
                proAnalytErgebnisStatusDvCodedText.setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode.UNVOLLSTAENDIG);
        }
        return proAnalytErgebnisStatusDvCodedText;
    }

}
