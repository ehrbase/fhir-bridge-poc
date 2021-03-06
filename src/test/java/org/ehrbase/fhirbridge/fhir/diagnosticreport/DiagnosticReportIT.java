package org.ehrbase.fhirbridge.fhir.diagnosticreport;

import ca.uhn.fhir.rest.gclient.ICreateTyped;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.ehr.converter.ConversionException;
import org.ehrbase.fhirbridge.comparators.CustomTemporalAcessorComparator;
import org.ehrbase.fhirbridge.fhir.AbstractMappingTestSetupIT;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.temporal.TemporalAccessor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration tests for {@link org.hl7.fhir.r4.model.DiagnosticReport DiagnosticReport} resource.
 */
class DiagnosticReportIT extends AbstractMappingTestSetupIT {

    public DiagnosticReportIT() {
        super("DiagnosticReport/", DiagnosticReport.class);
    }

    @Test
    void createDiagnosticReport() throws IOException {
        create("create-diagnosticReport.json");
    }

    @Test
    void createWithDefaultProfile() throws IOException {
        String resource = super.testFileLoader.loadResourceToString("create-diagnosticReport-with-default-profile.json");
        ICreateTyped createTyped = client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
        Exception exception = Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

        assertEquals("HTTP 422 : Default profile is not supported for DiagnosticReport. One of the following profiles is expected: " +
                "[https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab, https://www.netzwerk-universitaetsmedizin.de/fhir/StructureDefinition/diagnostic-report-radiology]", exception.getMessage());
    }

    @Test
    void createWithInvalidCode() throws IOException {
        String resource = super.testFileLoader.loadResourceToString("create-diagnosticReport-with-invalid-code.json");

        ICreateTyped createTyped = client.create().resource(resource.replaceAll(PATIENT_ID_TOKEN, PATIENT_ID));
        Exception exception = Assertions.assertThrows(UnprocessableEntityException.class, createTyped::execute);

        assertEquals("HTTP 422 : This element does not match any known slice defined in the profile https://www.medizininformatik-initiative.de/fhir/core/modul-labor/StructureDefinition/DiagnosticReportLab", exception.getMessage());
    }

    @Override
    public Javers getJavers() {
        return JaversBuilder.javers()
                .registerValue(TemporalAccessor.class, new CustomTemporalAcessorComparator())
                // .registerValueObject(new ValueObjectDefinition(YourComposition.class, List.of("location")))
                .build();
    }

    @Override
    public Exception executeMappingException(String path) throws IOException {
        DiagnosticReport diagnosticReport = (DiagnosticReport) testFileLoader.loadResource(path);
        return assertThrows(ConversionException.class, () -> {
           // new YourConverter().convert(@NonNull  radiologyReport);
        });
    }

    @Override
    public void testMapping(String resourcePath, String paragonPath) throws IOException {
        // your mapping compared to paragon file
    }
}
