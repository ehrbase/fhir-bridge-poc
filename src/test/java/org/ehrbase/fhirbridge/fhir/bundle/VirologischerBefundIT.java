package org.ehrbase.fhirbridge.fhir.bundle;

import org.ehrbase.fhirbridge.comparators.CustomTemporalAcessorComparator;
import org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund.VirologischerBefundCompositionConverter;

import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.VirologischerBefundComposition;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.AnatomischeLokalisationCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.BefundJedesEreignisPointEvent;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.BefundObservation;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.EinsenderstandortCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.EmpfaengerstandortCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.FallidentifikationCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.LabortestPanelCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytCluster;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvCodedText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusDvText;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytErgebnisStatusElement;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisChoice;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisDvCount;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisDvQuantity;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytQuantitativesErgebnisElement;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeDvIdentifier;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProAnalytZugehoerigeLaborprobeDvUri;
import org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition.ProbeCluster;

import org.ehrbase.fhirbridge.fhir.AbstractBundleMappingTestSetupIT;
import org.ehrbase.fhirbridge.fhir.bundle.validator.VirologischerBefundBundleValidator;
import org.ehrbase.fhirbridge.fhir.bundle.converter.VirologischerBefundConverter;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Observation;
import org.javers.core.Javers;
import org.javers.core.JaversBuilder;
import org.javers.core.diff.Diff;
import org.javers.core.metamodel.clazz.ValueObjectDefinition;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.temporal.TemporalAccessor;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class VirologischerBefundIT extends AbstractBundleMappingTestSetupIT {

    public VirologischerBefundIT(){ super( "Bundle/VirologischerBefund/", Bundle.class);}

    @Test
    public void createVirologischerBefund() throws IOException {
        create("create-virologischer-befund.json");
    }

    @Test
    public void createVirologischerBefundQuantity() throws IOException {
        create("create-virologischer-befund-quantity.json");
    }

    @Test
    void createInvalidUrn() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-invalid-urn.json");
        assertEquals("urn:uid:61ebe359-bfdc-4613-8bf2-c5e300945f0a is not a valid format. The fullUrl has to be an UUID and start with: urn:uuid:, example urn:uuid:04121321-4af5-424c-a0e1-ed3aab1c349d", exception.getMessage());
    }

    @Test
    void createMappingVirologischerBefund() throws IOException{
        testMapping("create-virologischer-befund.json", "paragon-create-virologischer-befund.json");
    }

    @Test
    void createMappingVirologischerBefundQuantity() throws IOException{
        testMappingQuantity("create-virologischer-befund-quantity.json", "paragon-create-virologischer-befund-quantity.json");
    }

    @Test
    void createInvalidRequest() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-invalid-request.json");
        assertEquals("Only the request method POST is supported !", exception.getMessage());
    }

    @Test
    void createInvalidSubjectIdFormat() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-invalid-subject-ids.json");
        assertEquals("Ensure that the subject id has the following format :         " +
                "\"subject\": {\n" +
                "          \"identifier\": {\n" +
                "            \"system\": \"urn:ietf:rfc:4122\",\n" +
                "            \"value\": \"example\"\n" +
                "          }\n" +
                "        },", exception.getMessage());
    }

    @Test
    void createInvalidProfile() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-invalid-profile.json");
        assertEquals("Virologischer Befund bundle needs to contain only the profiles for the Virologischer Befund. Please delete profile " + "http://highmed.org/StructureDefinition" + " from the Bundle.", exception.getMessage());
    }

    @Test
    void createDuplicatedProfile() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-duplicated.json");
        assertEquals("Virologischer Befund profile is duplicated within the bundle, please delete one of them", exception.getMessage());
    }

    @Test
    void createinsufficientProfiles() throws IOException {
        Exception exception = executeValidatorException("create-virologischer-befund-not-all-present.json");
        assertEquals("Virologischer Befund needs to contain at least one profile of VirologischerBefund, DiagnosticReport and Specimen.", exception.getMessage());
    }




    @Override
    public Javers getJavers() {
        return JaversBuilder.javers()
                .registerValue(TemporalAccessor.class, new CustomTemporalAcessorComparator())
                .registerValueObject(new ValueObjectDefinition(VirologischerBefundComposition.class, List.of("location", "feederAudit")))
                .registerValueObject(AnatomischeLokalisationCluster.class)
                .registerValueObject(BefundJedesEreignisPointEvent.class)
                .registerValueObject(BefundObservation.class)
                .registerValueObject(EinsenderstandortCluster.class)
                .registerValueObject(EmpfaengerstandortCluster.class)
                .registerValueObject(FallidentifikationCluster.class)
                .registerValueObject(LabortestPanelCluster.class)
                .registerValueObject(ProAnalytCluster.class)
                .registerValueObject(ProAnalytErgebnisStatusDvCodedText.class)
                .registerValueObject(ProAnalytErgebnisStatusDvText.class)
                .registerValueObject(ProAnalytErgebnisStatusElement.class)
                .registerValueObject(ProAnalytQuantitativesErgebnisDvCount.class)
                .registerValueObject(ProAnalytQuantitativesErgebnisDvQuantity.class)
                .registerValueObject(ProAnalytQuantitativesErgebnisElement.class)
                .registerValueObject(ProAnalytZugehoerigeLaborprobeDvIdentifier.class)
                .registerValueObject(ProAnalytZugehoerigeLaborprobeDvUri.class)
                .registerValueObject(ProbeCluster.class)
                .build();
    }

    @Override
    public Exception executeMappingException(String path) throws IOException {
        Bundle bundle = (Bundle) testFileLoader.loadResource(path);
        return assertThrows(Exception.class, () -> {
            new VirologischerBefundCompositionConverter().convert(new VirologischerBefundConverter().convert(bundle));
        });
    }

    @Override
    public void testMapping(String resourcePath, String paragonPath) throws IOException{
        Bundle bundle = (Bundle) super.testFileLoader.loadResource(resourcePath);
        VirologischerBefundConverter virologischerBefundConverter = new VirologischerBefundConverter();
        Observation observation = virologischerBefundConverter.convert(bundle);
        VirologischerBefundCompositionConverter virologischerBefundCompositionConverter = new VirologischerBefundCompositionConverter();
        VirologischerBefundComposition mappedVirologischerBefundComposition = virologischerBefundCompositionConverter.convert(observation);
        Diff diff = compareCompositions(getJavers(), paragonPath, mappedVirologischerBefundComposition);
        assertEquals(diff.getChanges().size(), 3);
    }

    public void testMappingQuantity(String resourcePath, String paragonPath) throws IOException{
        Bundle bundle = (Bundle) super.testFileLoader.loadResource(resourcePath);
        VirologischerBefundConverter virologischerBefundConverter = new VirologischerBefundConverter();
        Observation observation = virologischerBefundConverter.convert(bundle);
        VirologischerBefundCompositionConverter virologischerBefundCompositionConverter = new VirologischerBefundCompositionConverter();
        VirologischerBefundComposition mappedVirologischerBefundComposition = virologischerBefundCompositionConverter.convert(observation);
        Diff diff = compareCompositions(getJavers(), paragonPath, mappedVirologischerBefundComposition);
        assertEquals(diff.getChanges().size(), 3);
    }

    public Exception executeValidatorException(String path) throws IOException {
        Bundle bundle = (Bundle) testFileLoader.loadResource(path);
        return assertThrows(Exception.class, () -> {
           new VirologischerBefundBundleValidator().validateRequest(bundle, null);
        });
    }

}
