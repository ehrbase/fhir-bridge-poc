package org.ehrbase.fhirbridge.ehr.converter;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.TemporalAccessor;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.intensivmedizinischesmonitoringkorpertemperaturcomposition.definition.KorpertemperaturBeliebigesEreignisPointEvent;
import org.ehrbase.fhirbridge.ehr.opt.kennzeichnungerregernachweissarscov2composition.KennzeichnungErregernachweisSARSCoV2Composition;
import org.ehrbase.fhirbridge.ehr.opt.kennzeichnungerregernachweissarscov2composition.definition.KennzeichnungErregernachweisEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.ErregernameDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CoronavirusNachweisTestCompositionConverter
    implements CompositionConverter<KennzeichnungErregernachweisSARSCoV2Composition, Observation> {

  private static final Logger LOG =
      LoggerFactory.getLogger(CoronavirusNachweisTestCompositionConverter.class);

  @Override
  public Observation fromComposition(KennzeichnungErregernachweisSARSCoV2Composition composition) {
    Observation result = new Observation();

    TemporalAccessor temporal;
    KorpertemperaturBeliebigesEreignisPointEvent event;
    Coding coding;

    // evaluation time -> effective_time
    temporal = composition.getKennzeichnungErregernachweis().getZeitpunktDerKennzeichnungValue();
    result.getEffectiveDateTimeType().setValue(Date.from(Instant.from(temporal)));

    // FIXME: cant map the code back because the composition has a boolean derived from the code in
    // the FHIR resource
    if (composition.getKennzeichnungErregernachweis().isErregernachweisValue()) {
      // This is not right, could not the value that came initially in the FHIR result
      coding = result.getCode().addCoding();
      coding.setSystem("http://loing.org");
      coding.setCode("94532-9");
      coding.setDisplay(
          "SARS coronavirus+SARS-like coronavirus+SARS coronavirus 2+MERS coronavirus RNA [Presence] in Respiratory specimen by NAA with probe detection");
    }

    // set patient
    // result.getSubject().setReference("Patient/"+ subjectId.getValue());

    result.setStatus(Observation.ObservationStatus.FINAL);

    result.getMeta().addProfile(Profile.CORONARIRUS_NACHWEIS_TEST.getUri());

    // TODO: we are also not storing referenceRange

    // FIXME: all FHIR resources need an ID, currently we are using the composition.uid as the
    // resource ID,
    // this is a workaround, might not work on all cases.
    result.setId(composition.getVersionUid().toString()); // workaround

    return result;
  }

  @Override
  public KennzeichnungErregernachweisSARSCoV2Composition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    KennzeichnungErregernachweisSARSCoV2Composition result =
        new KennzeichnungErregernachweisSARSCoV2Composition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    // TODO: I'm not sure this is a complete list of "positive" results in LOINC, these are just
    // "SARS"+"presence" search
    // https://search.loinc.org/searchLOINC/search.zul?query=sars+presence
    List<String> positiveResultLoincCodes =
        Arrays.asList(
            "33972-1", "33968-9", "33970-5", "33966-3", "33967-1", "33975-4", "33965-5", "33964-8",
            "41459-9", "42956-3", "41991-1", "60275-5", "60534-5", "41458-1", "94532-9");

    // ========================================================================================
    // FHIR values
    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();
    String fhirValue =
        observation
            .getCode()
            .getCoding()
            .get(0)
            .getDisplay(); // FIXME: the code and value should be assigned to the pathogen name node
    // in the Compo, but the template binds just one specific value there
    // (hardcoded)
    String fhirCode = observation.getCode().getCoding().get(0).getCode();
    String fhirTerminology = observation.getCode().getCoding().get(0).getSystem();

    // mapping to openEHR
    KennzeichnungErregernachweisEvaluation evaluation =
        new KennzeichnungErregernachweisEvaluation();
    evaluation.setLanguage(Language.EN);
    evaluation.setSubject(new PartySelf());
    evaluation.setZuletztAktualisiertValue(OffsetDateTime.now());
    evaluation.setZeitpunktDerKennzeichnungValue(
        fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    boolean pathogenDetection = positiveResultLoincCodes.contains(fhirCode);
    evaluation.setErregernachweisValue(
        pathogenDetection); // FIXME: this needs to come from positive or negative result code from
    // FHIR, I didn't validate the list of positive result codes.

    evaluation.setErregernachweisInDerKlinikValue(
        false); // FIXME: FHIR don't have enough data to know if the pathogen was detected in the
    // clinic.

    // FIXME: Can't map with the code from FHIR since the code in the openEHR template is fixed
    ErregernameDefiningcode code =
        ErregernameDefiningcode
            .COV; // new ErregernameDefiningcode(fhirValue, null, fhirTerminology, fhirCode);
    evaluation.setErregernameDefiningcode(code);

    result.setKennzeichnungErregernachweis(evaluation);

    // ======================================================================================
    // Required fields by API
    result.setLanguage(Language.EN);
    result.setLocation("test");
    result.setSettingDefiningcode(SettingDefiningcode.EMERGENCY_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setStartTimeValue(OffsetDateTime.now());

    // FIXME: https://github.com/ehrbase/ehrbase_client_library/issues/31
    //        PartyProxy composer = new PartyIdentified();
    //        result.setComposer(composer);

    result.setComposer(new PartySelf());

    return result;
  }
}
