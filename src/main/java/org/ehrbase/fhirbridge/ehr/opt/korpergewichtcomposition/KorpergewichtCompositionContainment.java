package org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition;

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
import org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition.definition.KorpergewichtObservation;
import org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;

public class KorpergewichtCompositionContainment extends Containment {
  public SelectAqlField<KorpergewichtComposition> KORPERGEWICHT_COMPOSITION =
      new AqlFieldImp<KorpergewichtComposition>(
          KorpergewichtComposition.class,
          "",
          "KorpergewichtComposition",
          KorpergewichtComposition.class,
          this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KorpergewichtComposition.class,
          "/context/end_time|value",
          "endTimeValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Participation> PARTICIPATIONS =
      new ListAqlFieldImp<Participation>(
          KorpergewichtComposition.class,
          "/context/participations",
          "participations",
          Participation.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          KorpergewichtComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY =
      new AqlFieldImp<PartyIdentified>(
          KorpergewichtComposition.class,
          "/context/health_care_facility",
          "healthCareFacility",
          PartyIdentified.class,
          this);

  public SelectAqlField<StatusDefiningcode> STATUS_DEFININGCODE =
      new AqlFieldImp<StatusDefiningcode>(
          KorpergewichtComposition.class,
          "/context/other_context[at0001]/items[at0004]/value|defining_code",
          "statusDefiningcode",
          StatusDefiningcode.class,
          this);

  public SelectAqlField<String> KATEGORIE_VALUE =
      new AqlFieldImp<String>(
          KorpergewichtComposition.class,
          "/context/other_context[at0001]/items[at0005]/value|value",
          "kategorieValue",
          String.class,
          this);

  public SelectAqlField<Territory> TERRITORY =
      new AqlFieldImp<Territory>(
          KorpergewichtComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KorpergewichtComposition.class,
          "/context/start_time|value",
          "startTimeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<PartyProxy> COMPOSER =
      new AqlFieldImp<PartyProxy>(
          KorpergewichtComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE =
      new AqlFieldImp<SettingDefiningcode>(
          KorpergewichtComposition.class,
          "/context/setting|defining_code",
          "settingDefiningcode",
          SettingDefiningcode.class,
          this);

  public SelectAqlField<KorpergewichtObservation> KORPERGEWICHT =
      new AqlFieldImp<KorpergewichtObservation>(
          KorpergewichtComposition.class,
          "/content[openEHR-EHR-OBSERVATION.body_weight.v2]",
          "korpergewicht",
          KorpergewichtObservation.class,
          this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT =
      new AqlFieldImp<FeederAudit>(
          KorpergewichtComposition.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<String> LOCATION =
      new AqlFieldImp<String>(
          KorpergewichtComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE =
      new AqlFieldImp<CategoryDefiningcode>(
          KorpergewichtComposition.class,
          "/category|defining_code",
          "categoryDefiningcode",
          CategoryDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          KorpergewichtComposition.class,
          "/context/other_context[at0001]/items[at0002]",
          "erweiterung",
          Cluster.class,
          this);

  private KorpergewichtCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.registereintrag.v1");
  }

  public static KorpergewichtCompositionContainment getInstance() {
    return new KorpergewichtCompositionContainment();
  }
}
