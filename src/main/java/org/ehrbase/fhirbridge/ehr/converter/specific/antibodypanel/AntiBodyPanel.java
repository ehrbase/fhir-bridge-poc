package org.ehrbase.fhirbridge.ehr.converter.specific.antibodypanel;

import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.ehr.opt.geccoserologischerbefundcomposition.definition.VirusnachweistestDefiningCode;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Resource;

import java.util.List;
import java.util.Optional;

public class AntiBodyPanel {

    private Optional<Observation> antiBodyPanel = Optional.empty();
    private Optional<Immunoassay> aBPresence = Optional.empty();
    private Optional<Immunoassay> aBUnitsVolume = Optional.empty();
    private Optional<Immunoassay> igAAbPresence = Optional.empty();
    private Optional<Immunoassay> igAAbUnitVolume = Optional.empty();
    private Optional<Immunoassay> igMAbPresence = Optional.empty();
    private Optional<Immunoassay> igMAbUnitsVolume = Optional.empty();
    private Optional<Immunoassay> igGAbPresence = Optional.empty();
    private Optional<Immunoassay> igGAbUnitsVolume = Optional.empty();

    public AntiBodyPanel(Observation observation) {
        setObservations(observation);
    }

    private void setObservations(Observation observation) {
        antiBodyPanel = Optional.of(observation);
        for (Resource resource : observation.getContained()) {
            setProfiles(resource);
        }
    }

    private void setProfiles(Resource resource) {
        try {
            String profileUrl = resource.getMeta().getProfile().get(0).getValue();
            resoulveProfile(resource, profileUrl);
        } catch (IndexOutOfBoundsException e) {
            throw new ConversionException("Make sure only the for Anti body panel supported Profiles are contained in the Bundle");
        }
    }

    private void resoulveProfile(Resource resource, String profileUrl) {
        if (AntiBodyProfileUrl.AB_PRESENCE.getUrl().equals(profileUrl)) {
            this.aBPresence = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.AB_UNITS_VOLUME.getUrl().equals(profileUrl)) {
            this.aBUnitsVolume = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_AB_UNITS_VOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGA_AB_PRESENCE.getUrl().equals(profileUrl)) {
            this.igAAbPresence = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGA_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGA_AB_UNITS_VOLUME.getUrl().equals(profileUrl)) {
            this.igAAbUnitVolume = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGA_AB_UNITS_VOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGM_AB_PRESENCE.getUrl().equals(profileUrl)) {
            this.igMAbPresence = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGM_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGM_AB_UNITS_VOLUME.getUrl().equals(profileUrl)) {
            this.igMAbUnitsVolume = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGM_AB_UNITS_VOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGG_AB_PRESENCE.getUrl().equals(profileUrl)) {
            this.igGAbPresence = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGG_AB_PRESENCE_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else if (AntiBodyProfileUrl.IGG_AB_UNITS_VOLUME.getUrl().equals(profileUrl)) {
            this.igGAbUnitsVolume = Optional.of(new Immunoassay((Observation) resource, VirusnachweistestDefiningCode.SARS_COV2_COVID19_IGG_AB_UNITS_VOLUME_IN_SERUM_OR_PLASMA_BY_IMMUNOASSAY));

        } else {
            throw new ConversionException("Anti body panel bundle needs to contain only the profiles for the Anti body panel. Please delete profile " + profileUrl + " from the Bundle.");
        }
    }

    public List<Optional<Immunoassay>> getAllNonPanel() {
        return List.of(aBPresence, aBUnitsVolume, igAAbPresence, igAAbUnitVolume, igMAbPresence, igMAbUnitsVolume, igGAbPresence, igGAbUnitsVolume);
    }
}
