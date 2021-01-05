package org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition.PatientAufDerIntensivstationObservation;
import org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;

public class PatientAufICUCompositionContainment extends Containment {
  public SelectAqlField<PatientAufICUComposition> PATIENT_AUF_I_C_U_COMPOSITION =
      new AqlFieldImp<PatientAufICUComposition>(
          PatientAufICUComposition.class,
          "",
          "PatientAufICUComposition",
          PatientAufICUComposition.class,
          this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          PatientAufICUComposition.class,
          "/context/end_time|value",
          "endTimeValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Participation> PARTICIPATIONS =
      new ListAqlFieldImp<Participation>(
          PatientAufICUComposition.class,
          "/context/participations",
          "participations",
          Participation.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          PatientAufICUComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY =
      new AqlFieldImp<PartyIdentified>(
          PatientAufICUComposition.class,
          "/context/health_care_facility",
          "healthCareFacility",
          PartyIdentified.class,
          this);

  public SelectAqlField<StatusDefiningcode> STATUS_DEFININGCODE =
      new AqlFieldImp<StatusDefiningcode>(
          PatientAufICUComposition.class,
          "/context/other_context[at0001]/items[at0004]/value|defining_code",
          "statusDefiningcode",
          StatusDefiningcode.class,
          this);

  public SelectAqlField<Territory> TERRITORY =
      new AqlFieldImp<Territory>(
          PatientAufICUComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          PatientAufICUComposition.class,
          "/context/start_time|value",
          "startTimeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<PatientAufDerIntensivstationObservation> PATIENT_AUF_DER_INTENSIVSTATION =
      new AqlFieldImp<PatientAufDerIntensivstationObservation>(
          PatientAufICUComposition.class,
          "/content[openEHR-EHR-OBSERVATION.management_screening.v0 and name/value='Patient auf der Intensivstation']",
          "patientAufDerIntensivstation",
          PatientAufDerIntensivstationObservation.class,
          this);

  public SelectAqlField<PartyProxy> COMPOSER =
      new AqlFieldImp<PartyProxy>(
          PatientAufICUComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE =
      new AqlFieldImp<SettingDefiningcode>(
          PatientAufICUComposition.class,
          "/context/setting|defining_code",
          "settingDefiningcode",
          SettingDefiningcode.class,
          this);

  public SelectAqlField<String> LOCATION =
      new AqlFieldImp<String>(
          PatientAufICUComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE =
      new AqlFieldImp<CategoryDefiningcode>(
          PatientAufICUComposition.class,
          "/category|defining_code",
          "categoryDefiningcode",
          CategoryDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          PatientAufICUComposition.class,
          "/context/other_context[at0001]/items[at0002]",
          "erweiterung",
          Cluster.class,
          this);

  private PatientAufICUCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.registereintrag.v1");
  }

  public static PatientAufICUCompositionContainment getInstance() {
    return new PatientAufICUCompositionContainment();
  }
}
