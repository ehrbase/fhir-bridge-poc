package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartySelf;
import java.time.OffsetDateTime;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.schwangerschaftsstatuscomposition.SchwangerschaftsstatusComposition;
import org.ehrbase.fhirbridge.ehr.opt.schwangerschaftsstatuscomposition.definition.SchwangerschaftsstatusObservation;
import org.ehrbase.fhirbridge.ehr.opt.schwangerschaftsstatuscomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;

public class PregnancyStatusCompositionConverter
    implements CompositionConverter<SchwangerschaftsstatusComposition, Observation> {

  @Override
  public Observation fromComposition(SchwangerschaftsstatusComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public SchwangerschaftsstatusComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    SchwangerschaftsstatusComposition result = new SchwangerschaftsstatusComposition();

    // map start time
    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();

    result.setStartTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    // FIXME: map other context status
    // Can't map because of https://github.com/ehrbase/openEHR_SDK/issues/84

    result.setSchwangerschaftsstatus(mapObservation(observation));

    // ======================================================================================
    // Required fields by API
    result.setLanguage(Language.DE);
    result.setLocation("test");
    result.setSettingDefiningcode(SettingDefiningcode.SECONDARY_MEDICAL_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setStartTimeValue(OffsetDateTime.now());

    PartyIdentified composer = new PartyIdentified();
    DvIdentifier identifier = new DvIdentifier();
    identifier.setId(observation.getPerformer().get(0).getReference());
    composer.addIdentifier(identifier);
    result.setComposer(composer);

    return result;
  }

  private SchwangerschaftsstatusObservation mapObservation(Observation observation) {
    SchwangerschaftsstatusObservation result = new SchwangerschaftsstatusObservation();

    // mandatory fields
    result.setSubject(new PartySelf());
    result.setLanguage(Language.DE);

    // map origin/time
    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();

    result.setTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());
    result.setOriginValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());

    // map result status
    Coding statusCode = observation.getValueCodeableConcept().getCoding().get(0);

    // TODO: this only considers LOINC cases
    switch (statusCode.getCode()) {
      case "LA15173-0": // pregnant
        result.setStatusDefiningcode(StatusDefiningcode.SCHWANGER);
        break;
      case "LA26683-5": // not pregnant
        result.setStatusDefiningcode(StatusDefiningcode.NICHT_SCHWANGER);
        break;
      case "LA4489-6": // unknown
        result.setStatusDefiningcode(StatusDefiningcode.UNBEKANNT);
        break;
      default:
        throw new UnprocessableEntityException(
            "Status code " + statusCode.getCode() + " is not supported");
    }

    return result;
  }
}
