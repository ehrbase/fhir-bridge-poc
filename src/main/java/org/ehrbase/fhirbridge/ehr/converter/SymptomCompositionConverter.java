package org.ehrbase.fhirbridge.ehr.converter;

import com.nedap.archie.rm.generic.PartySelf;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConversionException;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.SymptomComposition;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.AusgeschlossenesSymptomEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.AussageUberDenAusschlussDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.Definingcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.KategorieDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.ProblemDiagnoseDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.SchweregradDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.UnbekanntesSymptomAussageUberDieFehlendeInformationElement;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.UnbekanntesSymptomEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.VorliegendesSymptomAnatomischeLokalisationElement;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.VorliegendesSymptomObservation;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.Condition;

public class SymptomCompositionConverter
    implements CompositionConverter<SymptomComposition, Condition> {

  private static final Map<String, ProblemDiagnoseDefiningcode> krankheitszeichenMap =
      new HashMap<>();

  private static final Map<String, SchweregradDefiningcode> schweregradMap = new HashMap<>();

  static {
    for (ProblemDiagnoseDefiningcode krankheitszeichen : ProblemDiagnoseDefiningcode.values()) {
      krankheitszeichenMap.put(krankheitszeichen.getCode(), krankheitszeichen);
    }

    for (SchweregradDefiningcode schweregrad : SchweregradDefiningcode.values()) {
      schweregradMap.put(schweregrad.getCode(), schweregrad);
    }
  }

  @Override
  public Condition fromComposition(SymptomComposition composition)
      throws CompositionConversionException {
    // TODO: Implement
    return null;
  }

  @Override
  public SymptomComposition toComposition(Condition condition)
      throws CompositionConversionException {
    if (condition == null) {
      return null;
    }

    SymptomComposition result = new SymptomComposition();

    if (condition.getVerificationStatus().isEmpty()) {
      mapUnknown(condition, result);
    } else if (condition.getVerificationStatus().getCoding().get(0).getCode().equals("confirmed")) {
      mapPresent(condition, result);
    } else {
      mapAbsent(condition, result);
    }

    result.setStartTimeValue(
        condition.getRecordedDateElement().getValueAsCalendar().toZonedDateTime());

    // ======================================================================================
    // Required fields by API

    result.setStatusDefiningcode(StatusDefiningcode.FINAL);
    result.setKategorieDefiningcode(KategorieDefiningcode.N753251);

    result.setLanguage(Language.DE);
    result.setLocation("test");
    result.setSettingDefiningcode(SettingDefiningcode.SECONDARY_MEDICAL_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setComposer(new PartySelf());

    return result;
  }

  private void mapPresent(Condition condition, SymptomComposition composition) {
    VorliegendesSymptomObservation vorliegendesSymptom = new VorliegendesSymptomObservation();

    try {

      Coding coding = condition.getCode().getCoding().get(0);

      ProblemDiagnoseDefiningcode krankheitszeichen = null;

      // Neue Systeme werden eingepflegt sobald sie in KrankheitsanzeichenDefiningcode definiert
      // sind.
      if (coding.getSystem().equals("http://snomed.info/sct")) {
        krankheitszeichen = krankheitszeichenMap.get(coding.getCode());
      }

      if (krankheitszeichen == null) {
        throw new CompositionConversionException("Unbekanntes Krankheitszeichen.");
      }

      vorliegendesSymptom.setNameDesSymptomsKrankheitsanzeichensDefiningcode(krankheitszeichen);

      if (condition.getOnset() != null && !condition.getOnset().isEmpty()) {
        vorliegendesSymptom.setBeginnDerEpisodeValue(
            condition.getOnsetDateTimeType().getValueAsCalendar().toZonedDateTime());
      }

      vorliegendesSymptom.setTimeValue(
          condition.getRecordedDateElement().getValueAsCalendar().toZonedDateTime());

      if (condition.getAbatement() != null && !condition.getAbatement().isEmpty()) {
        vorliegendesSymptom.setDatumUhrzeitDesRuckgangsValue(
            condition.getAbatementDateTimeType().getValueAsCalendar().toZonedDateTime());
      }

      if (!condition.getBodySite().isEmpty()) {
        for (CodeableConcept bodySite : condition.getBodySite()) {

          VorliegendesSymptomAnatomischeLokalisationElement lokalisation =
              new VorliegendesSymptomAnatomischeLokalisationElement();
          lokalisation.setValue(bodySite.getCoding().get(0).getCode());

          vorliegendesSymptom.getAnatomischeLokalisation().add(lokalisation);
        }
      }

      if (condition.getSeverity() != null && !condition.getSeverity().isEmpty()) {

        SchweregradDefiningcode schweregrad = null;

        if (condition
            .getSeverity()
            .getCoding()
            .get(0)
            .getSystem()
            .equals("http://snomed.info/sct")) {
          schweregrad = schweregradMap.get(condition.getSeverity().getCoding().get(0).getCode());
        }

        if (schweregrad == null) {
          throw new CompositionConversionException("Schweregrad has unknown system");
        }

        vorliegendesSymptom.setSchweregradDefiningcode(schweregrad);
      }

      vorliegendesSymptom.setOriginValue(
          condition.getRecordedDateElement().getValueAsCalendar().toZonedDateTime());

    } catch (Exception e) {
      throw new CompositionConversionException(
          "Some parts of the condition did not contain the required elements. " + e.getMessage(),
          e);
    }

    vorliegendesSymptom.setLanguage(Language.DE);
    vorliegendesSymptom.setSubject(new PartySelf());

    composition.setVorliegendesSymptom(vorliegendesSymptom);
  }

  private void mapAbsent(Condition condition, SymptomComposition composition) {

    AusgeschlossenesSymptomEvaluation ausgeschlossenesSymptom =
        new AusgeschlossenesSymptomEvaluation();

    try {
      Coding coding = condition.getCode().getCoding().get(0);

      ProblemDiagnoseDefiningcode krankheitszeichen = null;

      if (coding.getSystem().equals("http://snomed.info/sct")) {
        krankheitszeichen = krankheitszeichenMap.get(coding.getCode());
      }

      if (krankheitszeichen == null) {
        throw new CompositionConversionException("Unbekanntes Diagnose/Problem.");
      }

      ausgeschlossenesSymptom.setProblemDiagnoseDefiningcode(krankheitszeichen);
    } catch (Exception e) {
      throw new CompositionConversionException(
          "Some parts of the condition did not contain the required elements. " + e.getMessage(),
          e);
    }

    // Only one value possible.
    ausgeschlossenesSymptom.setAussageUberDenAusschlussDefiningcode(
        AussageUberDenAusschlussDefiningcode.N410594000);

    ausgeschlossenesSymptom.setSubject(new PartySelf());
    ausgeschlossenesSymptom.setLanguage(Language.DE);

    composition.setAusgeschlossenesSymptom(ausgeschlossenesSymptom);
  }

  private void mapUnknown(Condition condition, SymptomComposition composition) {

    UnbekanntesSymptomEvaluation unbekanntesSymptom = new UnbekanntesSymptomEvaluation();

    try {
      Coding coding = condition.getCode().getCoding().get(0);

      ProblemDiagnoseDefiningcode krankheitszeichen = null;

      // Neue Systeme werden eingepflegt sobald sie in KrankheitsanzeichenDefiningcode definiert
      // sind.
      if (coding.getSystem().equals("http://snomed.info/sct")) {
        krankheitszeichen = krankheitszeichenMap.get(coding.getCode());
      }

      if (krankheitszeichen == null) {
        throw new CompositionConversionException("Unbekanntes <unbekanntes Symptom>");
      }

      unbekanntesSymptom.setUnbekanntesSymptomDefiningcode(krankheitszeichen);

    } catch (Exception e) {
      throw new CompositionConversionException(
          "Some parts of the condition did not contain the required elements. " + e.getMessage(),
          e);
    }

    // UnbekanntesSymptomAussage can only have one value.
    UnbekanntesSymptomAussageUberDieFehlendeInformationElement
        aussageUberDieFehlendeInformationElement =
            new UnbekanntesSymptomAussageUberDieFehlendeInformationElement();
    aussageUberDieFehlendeInformationElement.setDefiningcode(Definingcode.N261665006);

    if (unbekanntesSymptom.getAussageUberDieFehlendeInformation() == null) {
      unbekanntesSymptom.setAussageUberDieFehlendeInformation(new ArrayList<>());
    }

    unbekanntesSymptom
        .getAussageUberDieFehlendeInformation()
        .add(aussageUberDieFehlendeInformationElement);
    unbekanntesSymptom.setSubject(new PartySelf());
    unbekanntesSymptom.setLanguage(Language.DE);

    composition.setUnbekanntesSymptom(unbekanntesSymptom);
  }
}
