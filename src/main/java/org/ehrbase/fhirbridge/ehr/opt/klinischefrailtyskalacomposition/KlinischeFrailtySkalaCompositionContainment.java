package org.ehrbase.fhirbridge.ehr.opt.klinischefrailtyskalacomposition;

import com.nedap.archie.rm.archetyped.FeederAudit;
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
import org.ehrbase.fhirbridge.ehr.opt.klinischefrailtyskalacomposition.definition.KlinischeFrailtySkalaCfsObservation;
import org.ehrbase.fhirbridge.ehr.opt.klinischefrailtyskalacomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;

public class KlinischeFrailtySkalaCompositionContainment extends Containment {
  public SelectAqlField<KlinischeFrailtySkalaComposition> KLINISCHE_FRAILTY_SKALA_COMPOSITION =
      new AqlFieldImp<KlinischeFrailtySkalaComposition>(
          KlinischeFrailtySkalaComposition.class,
          "",
          "KlinischeFrailtySkalaComposition",
          KlinischeFrailtySkalaComposition.class,
          this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KlinischeFrailtySkalaComposition.class,
          "/context/end_time|value",
          "endTimeValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Participation> PARTICIPATIONS =
      new ListAqlFieldImp<Participation>(
          KlinischeFrailtySkalaComposition.class,
          "/context/participations",
          "participations",
          Participation.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          KlinischeFrailtySkalaComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY =
      new AqlFieldImp<PartyIdentified>(
          KlinischeFrailtySkalaComposition.class,
          "/context/health_care_facility",
          "healthCareFacility",
          PartyIdentified.class,
          this);

  public SelectAqlField<StatusDefiningcode> STATUS_DEFININGCODE =
      new AqlFieldImp<StatusDefiningcode>(
          KlinischeFrailtySkalaComposition.class,
          "/context/other_context[at0001]/items[at0004]/value|defining_code",
          "statusDefiningcode",
          StatusDefiningcode.class,
          this);

  public SelectAqlField<String> KATEGORIE_VALUE =
      new AqlFieldImp<String>(
          KlinischeFrailtySkalaComposition.class,
          "/context/other_context[at0001]/items[at0005]/value|value",
          "kategorieValue",
          String.class,
          this);

  public SelectAqlField<Territory> TERRITORY =
      new AqlFieldImp<Territory>(
          KlinischeFrailtySkalaComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KlinischeFrailtySkalaComposition.class,
          "/context/start_time|value",
          "startTimeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<KlinischeFrailtySkalaCfsObservation> KLINISCHE_FRAILTY_SKALA_CFS =
      new AqlFieldImp<KlinischeFrailtySkalaCfsObservation>(
          KlinischeFrailtySkalaComposition.class,
          "/content[openEHR-EHR-OBSERVATION.clinical_frailty_scale.v1]",
          "klinischeFrailtySkalaCfs",
          KlinischeFrailtySkalaCfsObservation.class,
          this);

  public SelectAqlField<PartyProxy> COMPOSER =
      new AqlFieldImp<PartyProxy>(
          KlinischeFrailtySkalaComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE =
      new AqlFieldImp<SettingDefiningcode>(
          KlinischeFrailtySkalaComposition.class,
          "/context/setting|defining_code",
          "settingDefiningcode",
          SettingDefiningcode.class,
          this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT =
      new AqlFieldImp<FeederAudit>(
          KlinischeFrailtySkalaComposition.class,
          "/feeder_audit",
          "feederAudit",
          FeederAudit.class,
          this);

  public SelectAqlField<String> LOCATION =
      new AqlFieldImp<String>(
          KlinischeFrailtySkalaComposition.class,
          "/context/location",
          "location",
          String.class,
          this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE =
      new AqlFieldImp<CategoryDefiningcode>(
          KlinischeFrailtySkalaComposition.class,
          "/category|defining_code",
          "categoryDefiningcode",
          CategoryDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          KlinischeFrailtySkalaComposition.class,
          "/context/other_context[at0001]/items[at0002]",
          "erweiterung",
          Cluster.class,
          this);

  private KlinischeFrailtySkalaCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.registereintrag.v1");
  }

  public static KlinischeFrailtySkalaCompositionContainment getInstance() {
    return new KlinischeFrailtySkalaCompositionContainment();
  }
}
