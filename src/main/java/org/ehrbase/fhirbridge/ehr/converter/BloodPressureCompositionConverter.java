package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.blutdruckcomposition.BlutdruckComposition;
import org.ehrbase.fhirbridge.ehr.opt.blutdruckcomposition.definition.BlutdruckObservation;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BloodPressureCompositionConverter
    implements CompositionConverter<BlutdruckComposition, Observation> {

  private static final Logger LOG =
      LoggerFactory.getLogger(BloodPressureCompositionConverter.class);

  @Override
  public Observation fromComposition(BlutdruckComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public BlutdruckComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    BlutdruckComposition result = new BlutdruckComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    BlutdruckObservation bloodPressure = new BlutdruckObservation();

    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();

    try {
      // set systolic BP
      double systolicBPValue =
          observation.getComponent().get(0).getValueQuantity().getValue().doubleValue();
      String systolicBPUnit =
          observation.getComponent().get(0).getValueQuantity().getCode(); // mmHg, mm[Hg]

      bloodPressure.setSystolischMagnitude(systolicBPValue);
      bloodPressure.setSystolischUnits(systolicBPUnit);

      // set diastolic BP
      double diastolicBPValue =
          observation.getComponent().get(1).getValueQuantity().getValue().doubleValue();
      String diastolicBPUnit = observation.getComponent().get(1).getValueQuantity().getCode();

      bloodPressure.setDiastolischMagnitude(diastolicBPValue);
      bloodPressure.setDiastolischUnits(diastolicBPUnit);

    } catch (Exception e) {
      throw new UnprocessableEntityException(e.getMessage());
    }

    bloodPressure.setSubject(new PartySelf());
    bloodPressure.setLanguage(Language.DE); // FIXME: we need to grab the language from the template

    bloodPressure.setTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());
    bloodPressure.setOriginValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    result.setBlutdruck(bloodPressure);

    // ======================================================================================
    // Required fields by API
    result.setLanguage(Language.DE); // FIXME: we need to grab the language from the template
    result.setLocation("test"); // FIXME: Location abfangen?
    result.setSettingDefiningcode(SettingDefiningcode.SECONDARY_MEDICAL_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);

    result.setStartTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    result.setComposer(new PartySelf());

    return result;
  }
}
