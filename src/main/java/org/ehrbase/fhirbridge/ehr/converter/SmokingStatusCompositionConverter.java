package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import java.time.ZonedDateTime;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.raucherstatuscomposition.RaucherstatusComposition;
import org.ehrbase.fhirbridge.ehr.opt.raucherstatuscomposition.definition.RaucherstatusEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.raucherstatuscomposition.definition.RauchverhaltenDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Observation;

public class SmokingStatusCompositionConverter
    implements CompositionConverter<RaucherstatusComposition, Observation> {

  @Override
  public Observation fromComposition(RaucherstatusComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public RaucherstatusComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    // create composition and observation objects
    RaucherstatusComposition result = new RaucherstatusComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    RaucherstatusEvaluation evaluation = new RaucherstatusEvaluation();

    // map values of interest from FHIR observation
    ZonedDateTime effectiveDateTime = null;
    try {
      effectiveDateTime =
          observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime();

      Coding codin = observation.getValueCodeableConcept().getCoding().get(0);

      RauchverhaltenDefiningcode rauchverhaltenDefiningcode;
      switch (codin.getCode()) {
        case "LA18976-3":
          rauchverhaltenDefiningcode = RauchverhaltenDefiningcode.LA189763;
          break;
        case "LA18978-9":
          rauchverhaltenDefiningcode = RauchverhaltenDefiningcode.LA189789;
          break;
        case "LA15920-4":
          rauchverhaltenDefiningcode = RauchverhaltenDefiningcode.LA159204;
          break;
        case "LA18980-5":
          rauchverhaltenDefiningcode = RauchverhaltenDefiningcode.LA189805;
          break;
        default:
          throw new UnprocessableEntityException("Unexpected value: " + codin.getCode());
      }
      evaluation.setRauchverhaltenDefiningcode(rauchverhaltenDefiningcode);

      evaluation.setLanguage(Language.DE); // FIXME: we need to grab the language from the template
      evaluation.setSubject(new PartySelf());
    } catch (Exception e) {
      throw new UnprocessableEntityException(e.getMessage());
    }

    result.setRaucherstatus(evaluation);

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
