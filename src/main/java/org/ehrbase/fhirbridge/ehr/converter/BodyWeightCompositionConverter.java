package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import java.time.ZonedDateTime;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition.KorpergewichtComposition;
import org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition.definition.KorpergewichtObservation;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.hl7.fhir.r4.model.Observation;

public class BodyWeightCompositionConverter
    implements CompositionConverter<KorpergewichtComposition, Observation> {

  @Override
  public Observation fromComposition(KorpergewichtComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public KorpergewichtComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    // create composition and observation objects
    KorpergewichtComposition result = new KorpergewichtComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    KorpergewichtObservation korpergewichtObservation = new KorpergewichtObservation();

    // map values of interest from FHIR observation
    ZonedDateTime effectiveDateTime = null;
    try {
      effectiveDateTime =
          observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime();
      korpergewichtObservation.setOriginValue(effectiveDateTime); // mandatory#
      korpergewichtObservation.setGewichtMagnitude(
          observation.getValueQuantity().getValue().doubleValue());
      korpergewichtObservation.setGewichtUnits(
          observation
              .getValueQuantity()
              .getCode()); // note that the textual value that openEHR template expects as unit is
      // stored in code for this entity
      korpergewichtObservation.setTimeValue(effectiveDateTime);
      korpergewichtObservation.setLanguage(
          Language.DE); // FIXME: we need to grab the language from the template
      korpergewichtObservation.setSubject(new PartySelf());
    } catch (Exception e) {
      throw new UnprocessableEntityException(e.getMessage());
    }

    result.setKorpergewicht(korpergewichtObservation);

    // Required fields by API
    result.setLanguage(Language.DE); // FIXME: we need to grab the language from the template
    result.setLocation("test"); // FIXME: sensible value
    result.setSettingDefiningcode(SettingDefiningcode.SECONDARY_MEDICAL_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setStartTimeValue(effectiveDateTime);
    result.setComposer(new PartySelf()); // FIXME: sensible value

    return result;
  }
}
