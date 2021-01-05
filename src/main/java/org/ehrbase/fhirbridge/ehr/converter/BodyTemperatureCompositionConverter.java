package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.intensivmedizinischesmonitoringkorpertemperaturcomposition.IntensivmedizinischesMonitoringKorpertemperaturComposition;
import org.ehrbase.fhirbridge.ehr.opt.intensivmedizinischesmonitoringkorpertemperaturcomposition.definition.KorpertemperaturBeliebigesEreignisChoice;
import org.ehrbase.fhirbridge.ehr.opt.intensivmedizinischesmonitoringkorpertemperaturcomposition.definition.KorpertemperaturBeliebigesEreignisPointEvent;
import org.ehrbase.fhirbridge.ehr.opt.intensivmedizinischesmonitoringkorpertemperaturcomposition.definition.KorpertemperaturObservation;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.fhir.common.Profile;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Quantity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BodyTemperatureCompositionConverter
    implements CompositionConverter<
        IntensivmedizinischesMonitoringKorpertemperaturComposition, Observation> {

  private static final Logger LOG =
      LoggerFactory.getLogger(BodyTemperatureCompositionConverter.class);

  @Override
  public Observation fromComposition(
      IntensivmedizinischesMonitoringKorpertemperaturComposition composition) {
    if (composition == null) {
      return null;
    }

    Observation result = new Observation();

    TemporalAccessor temporal;
    KorpertemperaturBeliebigesEreignisPointEvent event;
    Coding coding;

    // observations [0] . origin => effective_time
    temporal = composition.getKorpertemperatur().get(0).getOriginValue();
    result.getEffectiveDateTimeType().setValue(Date.from(Instant.from(temporal)));

    // observations [0] . events [0] . value -> result . value
    event =
        (KorpertemperaturBeliebigesEreignisPointEvent)
            composition.getKorpertemperatur().get(0).getBeliebigesEreignis().get(0);
    result.getValueQuantity().setValue(event.getTemperaturMagnitude());
    result.getValueQuantity().setUnit(event.getTemperaturUnits());

    // set patient
    // result.getSubject().setReference("Patient/"+ subjectId.getValue());

    // set codes that come hardcoded in the inbound resources
    result.getCategory().add(new CodeableConcept());
    coding = result.getCategory().get(0).addCoding();
    coding.setSystem("http://terminology.hl7.org/CodeSystem/result-category");
    coding.setCode("vital-signs");

    coding = result.getCode().addCoding();
    coding.setSystem("http://loing.org");
    coding.setCode("8310-5");

    result.setStatus(Observation.ObservationStatus.FINAL);

    result.getMeta().addProfile(Profile.BODY_TEMP.getUri());

    // FIXME: all FHIR resources need an ID, currently we are using the compo.uid as the resource
    // ID,
    // this is a workaround, might not work on all cases.
    result.setId(composition.getVersionUid().toString());

    return result;
  }

  @Override
  public IntensivmedizinischesMonitoringKorpertemperaturComposition toComposition(
      Observation observation) {
    if (observation == null) {
      return null;
    }

    IntensivmedizinischesMonitoringKorpertemperaturComposition result =
        new IntensivmedizinischesMonitoringKorpertemperaturComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    // ========================================================================================
    // value quantity is expected
    Quantity fhirValue = null;
    BigDecimal fhirValueNumeric = null;
    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();

    try {
      fhirValue = observation.getValueQuantity();
      fhirValueNumeric = fhirValue.getValue();
      LOG.debug("Value numeric: {}", fhirValueNumeric);
    } catch (Exception e) {
      throw new UnprocessableEntityException(e.getMessage());
    }

    if (fhirValueNumeric == null) {
      throw new UnprocessableEntityException(
          "Value is required in FHIR Observation and should be Quantity");
    }

    // mapping to openEHR
    KorpertemperaturBeliebigesEreignisPointEvent tempEvent =
        new KorpertemperaturBeliebigesEreignisPointEvent();
    tempEvent.setTimeValue(
        fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime()); // mandatory
    tempEvent.setTemperaturMagnitude(fhirValueNumeric.doubleValue());
    tempEvent.setTemperaturUnits(fhirValue.getUnit());

    KorpertemperaturObservation tempObs = new KorpertemperaturObservation();
    List<KorpertemperaturBeliebigesEreignisChoice> events = new ArrayList<>();
    events.add(tempEvent);
    tempObs.setBeliebigesEreignis(events);
    tempObs.setOriginValue(
        fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime()); // mandatory
    tempObs.setLanguage(Language.EN); // FIXME: we need to grab the language from the template
    tempObs.setSubject(new PartySelf());

    List<KorpertemperaturObservation> observations = new ArrayList<>();
    observations.add(tempObs);
    result.setKorpertemperatur(observations);

    // ======================================================================================
    // Required fields by API
    result.setLanguage(Language.EN); // FIXME: we need to grab the language from the template
    result.setLocation("test");
    result.setSettingDefiningcode(SettingDefiningcode.EMERGENCY_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setStartTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    // FIXME: https://github.com/ehrbase/ehrbase_client_library/issues/31
    //        PartyProxy composer = new PartyIdentified();
    //        result.setComposer(composer);

    result.setComposer(new PartySelf());

    return result;
  }
}
