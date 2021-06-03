package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.BefundJedesEreignisPointEvent;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.LabortestPanelCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProbeCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.AnatomischeLokalisationCluster;


import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Extension;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Specimen;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;
import java.time.ZonedDateTime;

public class BefundJedesEreignisPointEventConverter extends BefundJedesEreignisPointEvent {

    protected BefundJedesEreignisPointEvent convert(Observation observation) throws FHIRException {

        Specimen specimen = observation.getSpecimenTarget();

        BefundJedesEreignisPointEvent befundevent = new BefundJedesEreignisPointEvent();

        befundevent.setTimeValue(observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());

        mapLabortestbezeichnung(observation, befundevent);
        mapProbe(befundevent, specimen);

        List<ProAnalytCluster> proAnalytClusterlist = new ArrayList<>();
        LabortestPanelCluster labortestPanelCluster = new LabortestPanelCluster();

        proAnalytClusterlist.add(new ProAnalytClusterConverter().convert(observation));
        labortestPanelCluster.setProAnalyt(proAnalytClusterlist);
        befundevent.setLabortestPanel(labortestPanelCluster);

        return befundevent;

    }

    private void mapLabortestbezeichnung(Observation observation, BefundJedesEreignisPointEvent befundevent) {

        if(observation.getCategory().get(0).getCoding().get(0).getCode().equals("122442008")) {
            befundevent.setLabortestBezeichnung(LabortestBezeichnungDefiningCode.DETECTION_OF_VIRUS_PROCEDURE.toDvCodedText());
        }else{
            throw new UnprocessableEntityException("createLabortestBezeichnungDefiningCode failed.");
        }
    }

    private void mapProbe(BefundJedesEreignisPointEvent befundevent, Specimen specimen) throws FHIRException {

        ProbeCluster probecluster = new ProbeCluster();

        AnatomischeLokalisationCluster anatomischeLokalisationCluster = new AnatomischeLokalisationCluster();

        if (specimen.getCollection().hasCollectedPeriod()){
            if (specimen.getCollection().getCollectedPeriod().hasStart() && specimen.getCollection().getCollectedPeriod().hasEnd()) {
                Date start = specimen.getCollection().getCollectedPeriod().getStart();
                Date end = specimen.getCollection().getCollectedPeriod().getEnd();
                probecluster.setZeitpunktDesProbeneingangsValue((new DateTimeType(start)).getValueAsCalendar().toZonedDateTime());
                probecluster.setZeitpunktDesProbeneingangsValue((new DateTimeType(end)).getValueAsCalendar().toZonedDateTime());
                befundevent.setProbe(probecluster);
            }
        } else {
            DateTimeType date = specimen.getCollection().getCollectedDateTimeType();
            probecluster.setZeitpunktDerProbenentnahmeValue(date.getValueAsCalendar().toZonedDateTime());
            befundevent.setProbe(probecluster);
        }

        switch (specimen.getCollection().getBodySite().getCoding().get(0).getCode()) {

            case "367592002":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.STRUCTURE_OF_POSTERIOR_NASOPHARYNX_BODY_STRUCTURE.toDvCodedText());
                break;
            case "12999009":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.STRUCTURE_OF_POSTERIOR_WALL_OF_OROPHARYNX_BODY_STRUCTURE.toDvCodedText());
                break;
            case "700016008":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.STRUCTURE_OF_INTERNAL_PART_OF_MOUTH.toDvCodedText());
                break;
            case "44567001":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.TRACHEAL_STRUCTURE_BODY_STRUCTURE.toDvCodedText());
                break;
            case "82094008":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.LOWER_RESPIRATORY_TRACT_STRUCTURE_BODY_STRUCTURE.toDvCodedText());
                break;
            case "91724006":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.TRACHEOBRONCHIAL_STRUCTURE_BODY_STRUCTURE.toDvCodedText());
                break;
            case "955009":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.BRONCHIAL_STRUCTURE_BODY_STRUCTURE.toDvCodedText());
                break;
            case "113253006":
                anatomischeLokalisationCluster.setNameDerKoerperstelle(NameDerKoerperstelleDefiningCode.PULMONARY_ALVEOLAR_STRUCTURE_BODY_STRUCTURE.toDvCodedText());
                break;
            default:
                throw new UnprocessableEntityException("createNameDerKoerperstelleDefiningCode failed. Code not found for: " + specimen.getCollection().getBodySite().getCoding().get(0).getCode());

        }
        probecluster.setAnatomischeLokalisation(anatomischeLokalisationCluster);
        befundevent.setProbe(probecluster);
    }

}


