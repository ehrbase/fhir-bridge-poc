package org.ehrbase.fhirbridge.fhir.bundle.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Specimen;
import org.hl7.fhir.r4.model.DiagnosticReport;

import org.hl7.fhir.r4.model.Reference;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VirologischerBefundConverter extends AbstractBundleConverter<Observation> {


    @Override
    public Observation convert(@NonNull Bundle bundle) {
        Observation observation = getRoot(bundle, Profile.VIROLOGISCHER_BEFUND);

        List<Resource> contains = new ArrayList<>();

        Resource resourcedia = bundle.getEntry().get(1).getResource();
        Resource resourcespe = bundle.getEntry().get(2).getResource();

        resourcedia.setId((String) null);
        resourcespe.setId((String) null);

        contains.add(resourcedia);
        contains.add(resourcespe);

        observation.setContained(contains);
        return observation;
    }

}

