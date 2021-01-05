package org.ehrbase.fhirbridge.ehr.opt.sofacomposition;

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
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.ehr.opt.sofacomposition.definition.SOFAScoreObservation;
import org.ehrbase.fhirbridge.ehr.opt.sofacomposition.definition.StatusDefiningcode;

public class SOFACompositionContainment extends Containment {
  public SelectAqlField<SOFAComposition> S_O_F_A_COMPOSITION =
      new AqlFieldImp<SOFAComposition>(
          SOFAComposition.class, "", "SOFAComposition", SOFAComposition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          SOFAComposition.class,
          "/context/end_time|value",
          "endTimeValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Participation> PARTICIPATIONS =
      new ListAqlFieldImp<Participation>(
          SOFAComposition.class,
          "/context/participations",
          "participations",
          Participation.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          SOFAComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY =
      new AqlFieldImp<PartyIdentified>(
          SOFAComposition.class,
          "/context/health_care_facility",
          "healthCareFacility",
          PartyIdentified.class,
          this);

  public SelectAqlField<StatusDefiningcode> STATUS_DEFININGCODE =
      new AqlFieldImp<StatusDefiningcode>(
          SOFAComposition.class,
          "/context/other_context[at0001]/items[at0004]/value|defining_code",
          "statusDefiningcode",
          StatusDefiningcode.class,
          this);

  public SelectAqlField<String> KATEGORIE_VALUE =
      new AqlFieldImp<String>(
          SOFAComposition.class,
          "/context/other_context[at0001]/items[at0005]/value|value",
          "kategorieValue",
          String.class,
          this);

  public SelectAqlField<SOFAScoreObservation> SOFA_SCORE =
      new AqlFieldImp<SOFAScoreObservation>(
          SOFAComposition.class,
          "/content[openEHR-EHR-OBSERVATION.sofa_score.v0]",
          "sofaScore",
          SOFAScoreObservation.class,
          this);

  public SelectAqlField<Territory> TERRITORY =
      new AqlFieldImp<Territory>(
          SOFAComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          SOFAComposition.class,
          "/context/start_time|value",
          "startTimeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<PartyProxy> COMPOSER =
      new AqlFieldImp<PartyProxy>(
          SOFAComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE =
      new AqlFieldImp<SettingDefiningcode>(
          SOFAComposition.class,
          "/context/setting|defining_code",
          "settingDefiningcode",
          SettingDefiningcode.class,
          this);

  public SelectAqlField<String> LOCATION =
      new AqlFieldImp<String>(
          SOFAComposition.class, "/context/location", "location", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE =
      new AqlFieldImp<CategoryDefiningcode>(
          SOFAComposition.class,
          "/category|defining_code",
          "categoryDefiningcode",
          CategoryDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          SOFAComposition.class,
          "/context/other_context[at0001]/items[at0002]",
          "erweiterung",
          Cluster.class,
          this);

  private SOFACompositionContainment() {
    super("openEHR-EHR-COMPOSITION.registereintrag.v1");
  }

  public static SOFACompositionContainment getInstance() {
    return new SOFACompositionContainment();
  }
}
