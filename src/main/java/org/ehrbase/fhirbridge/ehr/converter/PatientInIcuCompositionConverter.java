package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.PartySelf;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.PatientAufICUComposition;
import org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition.PatientAufDerIntensivstationObservation;
import org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.WurdeDieAktivitatDurchgefuhrtDefiningcode;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Observation;

public class PatientInIcuCompositionConverter
    implements CompositionConverter<PatientAufICUComposition, Observation> {

  @Override
  public Observation fromComposition(PatientAufICUComposition composition) {
    // TODO: Implement
    return null;
  }

  @Override
  public PatientAufICUComposition toComposition(Observation observation) {
    if (observation == null) {
      return null;
    }

    PatientAufICUComposition result = new PatientAufICUComposition();

    // set feeder audit
    FeederAudit fa = CommonData.constructFeederAudit(observation);
    result.setFeederAudit(fa);

    Observation.ObservationStatus status = observation.getStatus();

    if (status.toCode().equals("final")) {
      result.setStatusDefiningcode(StatusDefiningcode.FINAL);
    } else {
      throw new UnprocessableEntityException("Status has invalid code " + status.toCode());
    }

    PatientAufDerIntensivstationObservation patientAufDerIntensivstationObservation =
        new PatientAufDerIntensivstationObservation();

    patientAufDerIntensivstationObservation.setNameDerAktivitatValue(
        "Behandlung auf der Intensivstation");

    String code = observation.getValueCodeableConcept().getCoding().get(0).getCode();

    if (code.equals("74964007")) {
      patientAufDerIntensivstationObservation.setWurdeDieAktivitatDurchgefuhrtDefiningcode(
          WurdeDieAktivitatDurchgefuhrtDefiningcode.N74964007);
    } else if (code.equals("373066001")) {
      patientAufDerIntensivstationObservation.setWurdeDieAktivitatDurchgefuhrtDefiningcode(
          WurdeDieAktivitatDurchgefuhrtDefiningcode.N373066001);
    } else if (code.equals("261665006")) {
      patientAufDerIntensivstationObservation.setWurdeDieAktivitatDurchgefuhrtDefiningcode(
          WurdeDieAktivitatDurchgefuhrtDefiningcode.N261665006);
    } else if (code.equals("385432009")) {
      patientAufDerIntensivstationObservation.setWurdeDieAktivitatDurchgefuhrtDefiningcode(
          WurdeDieAktivitatDurchgefuhrtDefiningcode.N385432009);
    } else if (code.equals("373067005")) {
      patientAufDerIntensivstationObservation.setWurdeDieAktivitatDurchgefuhrtDefiningcode(
          WurdeDieAktivitatDurchgefuhrtDefiningcode.N373067005);
    } else {
      throw new UnprocessableEntityException("Aktivität durchgeführt has invalid code " + code);
    }

    DateTimeType fhirEffectiveDateTime = observation.getEffectiveDateTimeType();

    patientAufDerIntensivstationObservation.setLanguage(Language.DE);
    patientAufDerIntensivstationObservation.setTimeValue(
        fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());
    patientAufDerIntensivstationObservation.setOriginValue(
        fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());
    patientAufDerIntensivstationObservation.setSubject(new PartySelf());

    result.setPatientAufDerIntensivstation(patientAufDerIntensivstationObservation);

    // obligatory stuff block
    result.setLanguage(Language.DE); // FIXME: we need to grab the language from the template
    result.setLocation("test"); // FIXME: sensible value
    result.setSettingDefiningcode(SettingDefiningcode.SECONDARY_MEDICAL_CARE);
    result.setTerritory(Territory.DE);
    result.setCategoryDefiningcode(CategoryDefiningcode.EVENT);
    result.setStartTimeValue(fhirEffectiveDateTime.getValueAsCalendar().toZonedDateTime());
    result.setComposer(new PartySelf()); // FIXME: sensible value
    return result;
  }
}
