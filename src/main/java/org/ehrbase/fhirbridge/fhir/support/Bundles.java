package org.ehrbase.fhirbridge.fhir.support;

import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.hl7.fhir.r4.model.Bundle;

public class Bundles {

    private Bundles() {
    }

    public static Profile getTransactionProfile(Bundle bundle) {
        for (Bundle.BundleEntryComponent entry : bundle.getEntry()) {
            if (Resources.hasProfile(entry.getResource(), Profile.BLOOD_GAS_PANEL)) {
                return Profile.BLOOD_GAS_PANEL;
            } else if (Resources.hasProfile(entry.getResource(), Profile.ANTI_BODY_PANEL)) {
                return Profile.ANTI_BODY_PANEL;
            } else if (Resources.hasProfile(entry.getResource(), Profile.DIAGNOSTIC_REPORT_LAB)) {
                return Profile.DIAGNOSTIC_REPORT_LAB;
            } else if (Resources.hasProfile(entry.getResource(), Profile.VIROLOGISCHER_BEFUND)) {
                return Profile.VIROLOGISCHER_BEFUND;
            }
        }
        return null;
    }
}
