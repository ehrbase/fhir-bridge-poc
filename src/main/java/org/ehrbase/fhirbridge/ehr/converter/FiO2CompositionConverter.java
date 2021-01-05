package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datavalues.quantity.DvProportion;
import com.nedap.archie.rm.generic.PartySelf;
import java.time.ZonedDateTime;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.beatmungswertecomposition.BeatmungswerteComposition;
import org.ehrbase.fhirbridge.ehr.opt.beatmungswertecomposition.definition.BeobachtungenAmBeatmungsgeratObservation;
import org.ehrbase.fhirbridge.ehr.opt.beatmungswertecomposition.definition.EingeatmeterSauerstoffCluster;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.hl7.fhir.r4.model.Observation;

public class FiO2CompositionConverter
    implements CompositionConverter<BeatmungswerteComposition, Observation> {

  @Override
  public Observation fromComposition(BeatmungswerteComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public BeatmungswerteComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    BeatmungswerteComposition result = new BeatmungswerteComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    BeobachtungenAmBeatmungsgeratObservation beobachtungenAmBeatmungsgeratObservation =
        new BeobachtungenAmBeatmungsgeratObservation();
    ZonedDateTime effectiveDateTime = null;
    EingeatmeterSauerstoffCluster eingeatmeterSauerstoff = new EingeatmeterSauerstoffCluster();
    DvProportion inspiratorischeSauerstofffraktion = new DvProportion();

    // map values of interest from FHIR observation
    try {
      // obligatory stuff block
      effectiveDateTime =
          observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime();
      beobachtungenAmBeatmungsgeratObservation.setOriginValue(effectiveDateTime); // mandatory
      beobachtungenAmBeatmungsgeratObservation.setTimeValue(effectiveDateTime);
      beobachtungenAmBeatmungsgeratObservation.setLanguage(
          Language.DE); // FIXME: we need to grab the language from the template
      beobachtungenAmBeatmungsgeratObservation.setSubject(new PartySelf());

      // inspiratorische Sauerstofffraktion numerator and denominator
      inspiratorischeSauerstofffraktion.setNumerator(
          observation.getValueQuantity().getValue().doubleValue());
      inspiratorischeSauerstofffraktion.setDenominator(100.0);
      inspiratorischeSauerstofffraktion.setType((long) 2); // 2=percent
      // (https://specifications.openehr.org/releases/RM/latest/data_types.html#_proportion_kind_class)
      eingeatmeterSauerstoff.setInspiratorischeSauerstofffraktion(
          inspiratorischeSauerstofffraktion);

      // compose result
      beobachtungenAmBeatmungsgeratObservation.setEingeatmeterSauerstoff(eingeatmeterSauerstoff);
      result.setBeobachtungenAmBeatmungsgerat(beobachtungenAmBeatmungsgeratObservation);
    } catch (Exception e) {
      throw new UnprocessableEntityException(e.getMessage());
    }

    // obligatory stuff block
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
