package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;


import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusElement;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisElement;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeChoice;


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.Observation;

import java.util.ArrayList;
import java.util.List;

public class ProAnalytClusterConverter extends ProAnalytCluster {

    public ProAnalytCluster convert(Observation observation) throws FHIRException {

        ProAnalytCluster proAnalytCluster = new ProAnalytCluster();

        if (observation.hasValueCodeableConcept()){
            mapNachweistest(observation, proAnalytCluster);
            mapVirusnachweistest(observation, proAnalytCluster);
        } else if (observation.hasValueQuantity()) {
            List<ProAnalytQuantitativesErgebnisElement>  proAnalytQuantitativesErgebnisElementList = new ArrayList<>();
            proAnalytQuantitativesErgebnisElementList.add(new ProAnalytQuantitativesErgebnisElementConverter().convert(observation));
            proAnalytCluster.setQuantitativesErgebnis(proAnalytQuantitativesErgebnisElementList);

            proAnalytCluster.setNachweis(NachweisDefiningCode.DETECTED_QUALIFIER_VALUE.toDvCodedText());
        } else{
            throw new UnprocessableEntityException ("Observation needs either ValueCodeableConcept or ValueQuantity.");
        }

        List <ProAnalytErgebnisStatusElement> proAnalytErgebnisStatusElementList = new ArrayList<>();
        proAnalytErgebnisStatusElementList.add(new ProAnalytErgebnisStatusElementConverter().convert(observation));
        proAnalytCluster.setErgebnisStatus(proAnalytErgebnisStatusElementList);

        ProAnalytZugehoerigeLaborprobeChoice proAnalytZugehoerigeLaborprobeChoice = new ProAnalytZugehoerigeLaborprobeChoiceConverter().convertDvIdentifier(observation);
        proAnalytCluster.setZugehoerigeLaborprobe(proAnalytZugehoerigeLaborprobeChoice);

        if (proAnalytCluster.getZugehoerigeLaborprobe() == null){
            ProAnalytZugehoerigeLaborprobeChoice proAnalytZugehoerigeLaborprobeChoice2 = new ProAnalytZugehoerigeLaborprobeChoiceConverter().convertDvUri(observation);
            proAnalytCluster.setZugehoerigeLaborprobe(proAnalytZugehoerigeLaborprobeChoice2);
        }

        return proAnalytCluster;

    }

    private void mapVirusnachweistest(Observation observation, ProAnalytCluster proAnalytCluster){

        switch (observation.getCode().getCoding().get(0).getCode()){
            case "94500-6":
                proAnalytCluster.setVirusnachweistest(VirusnachweistestDefiningCode.SARS_COV2_COVID19_RNA_PRESENCE_IN_RESPIRATORY_SPECIMEN_BY_NAA_WITH_PROBE_DETECTION.toDvCodedText());
                break;
            case "94558-4":
                proAnalytCluster.setVirusnachweistest(VirusnachweistestDefiningCode.SARS_COV2_AG.toDvCodedText());
                break;
            case "94745-7":
                proAnalytCluster.setVirusnachweistest(VirusnachweistestDefiningCode.SARS_COV2_COVID19_RNA_CYCLE_THRESHOLD_IN_RESPIRATORY_SPECIMEN_BY_NAA_WITH_PROBE_DETECTION.toDvCodedText());
                break;
            default:
                throw new UnprocessableEntityException("Value code Virusnachweistest " + observation.getCode().getCoding().get(0).getCode() + " is not supported");
        }
    }

    private void mapNachweistest(Observation observation, ProAnalytCluster proAnalytCluster) throws FHIRException {
        switch(observation.getValueCodeableConcept().getCoding().get(0).getCode()){
            case "260373001":
                proAnalytCluster.setNachweis(NachweisDefiningCode.DETECTED_QUALIFIER_VALUE.toDvCodedText());
                break;
            case "419984006":
                proAnalytCluster.setNachweis(NachweisDefiningCode.INCONCLUSIVE_QUALIFIER_VALUE.toDvCodedText());
                break;
            case "260415000":
                proAnalytCluster.setNachweis(NachweisDefiningCode.NOT_DETECTED_QUALIFIER_VALUE.toDvCodedText());
                break;
            default:
                throw new UnprocessableEntityException("Value code Nachweistest " + observation.getValueCodeableConcept().getCoding().get(0).getCode() + " is not supported");
        }
    }

}
