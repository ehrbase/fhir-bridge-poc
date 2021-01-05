package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Id;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.annotations.Template;
import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.fhirbridge.ehr.Composition;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.AusgeschlossenesSymptomEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.KategorieDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.StatusDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.UnbekanntesSymptomEvaluation;
import org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition.VorliegendesSymptomObservation;

@Entity
@Archetype("openEHR-EHR-COMPOSITION.registereintrag.v1")
@Template("Symptom")
public class SymptomComposition implements Composition {
  @Id private VersionUid versionUid;

  @Path("/context/end_time|value")
  private TemporalAccessor endTimeValue;

  @Path("/context/participations")
  private List<Participation> participations;

  @Path("/language")
  private Language language;

  @Path("/context/health_care_facility")
  private PartyIdentified healthCareFacility;

  @Path("/context/other_context[at0001]/items[at0004]/value|defining_code")
  private StatusDefiningcode statusDefiningcode;

  @Path("/context/other_context[at0001]/items[at0005]/value|defining_code")
  private KategorieDefiningcode kategorieDefiningcode;

  @Path("/territory")
  private Territory territory;

  @Path(
      "/content[openEHR-EHR-EVALUATION.exclusion_specific.v1 and name/value='Ausgeschlossenes Symptom']")
  private AusgeschlossenesSymptomEvaluation ausgeschlossenesSymptom;

  @Path("/context/start_time|value")
  private TemporalAccessor startTimeValue;

  @Path("/composer")
  private PartyProxy composer;

  @Path("/content[openEHR-EHR-EVALUATION.absence.v2 and name/value='Unbekanntes Symptom']")
  private UnbekanntesSymptomEvaluation unbekanntesSymptom;

  @Path("/context/setting|defining_code")
  private SettingDefiningcode settingDefiningcode;

  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  @Path("/context/location")
  private String location;

  @Path("/content[openEHR-EHR-OBSERVATION.symptom_sign.v0 and name/value='Vorliegendes Symptom']")
  private VorliegendesSymptomObservation vorliegendesSymptom;

  @Path("/category|defining_code")
  private CategoryDefiningcode categoryDefiningcode;

  @Path("/context/other_context[at0001]/items[at0002]")
  private List<Cluster> erweiterung;

  public VersionUid getVersionUid() {
    return this.versionUid;
  }

  public void setVersionUid(VersionUid versionUid) {
    this.versionUid = versionUid;
  }

  public TemporalAccessor getEndTimeValue() {
    return this.endTimeValue;
  }

  public void setEndTimeValue(TemporalAccessor endTimeValue) {
    this.endTimeValue = endTimeValue;
  }

  public List<Participation> getParticipations() {
    return this.participations;
  }

  public void setParticipations(List<Participation> participations) {
    this.participations = participations;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public PartyIdentified getHealthCareFacility() {
    return this.healthCareFacility;
  }

  public void setHealthCareFacility(PartyIdentified healthCareFacility) {
    this.healthCareFacility = healthCareFacility;
  }

  public StatusDefiningcode getStatusDefiningcode() {
    return this.statusDefiningcode;
  }

  public void setStatusDefiningcode(StatusDefiningcode statusDefiningcode) {
    this.statusDefiningcode = statusDefiningcode;
  }

  public KategorieDefiningcode getKategorieDefiningcode() {
    return this.kategorieDefiningcode;
  }

  public void setKategorieDefiningcode(KategorieDefiningcode kategorieDefiningcode) {
    this.kategorieDefiningcode = kategorieDefiningcode;
  }

  public Territory getTerritory() {
    return this.territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }

  public AusgeschlossenesSymptomEvaluation getAusgeschlossenesSymptom() {
    return this.ausgeschlossenesSymptom;
  }

  public void setAusgeschlossenesSymptom(
      AusgeschlossenesSymptomEvaluation ausgeschlossenesSymptom) {
    this.ausgeschlossenesSymptom = ausgeschlossenesSymptom;
  }

  public TemporalAccessor getStartTimeValue() {
    return this.startTimeValue;
  }

  public void setStartTimeValue(TemporalAccessor startTimeValue) {
    this.startTimeValue = startTimeValue;
  }

  public PartyProxy getComposer() {
    return this.composer;
  }

  public void setComposer(PartyProxy composer) {
    this.composer = composer;
  }

  public UnbekanntesSymptomEvaluation getUnbekanntesSymptom() {
    return this.unbekanntesSymptom;
  }

  public void setUnbekanntesSymptom(UnbekanntesSymptomEvaluation unbekanntesSymptom) {
    this.unbekanntesSymptom = unbekanntesSymptom;
  }

  public SettingDefiningcode getSettingDefiningcode() {
    return this.settingDefiningcode;
  }

  public void setSettingDefiningcode(SettingDefiningcode settingDefiningcode) {
    this.settingDefiningcode = settingDefiningcode;
  }

  public FeederAudit getFeederAudit() {
    return this.feederAudit;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
    this.feederAudit = feederAudit;
  }

  public String getLocation() {
    return this.location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public VorliegendesSymptomObservation getVorliegendesSymptom() {
    return this.vorliegendesSymptom;
  }

  public void setVorliegendesSymptom(VorliegendesSymptomObservation vorliegendesSymptom) {
    this.vorliegendesSymptom = vorliegendesSymptom;
  }

  public CategoryDefiningcode getCategoryDefiningcode() {
    return this.categoryDefiningcode;
  }

  public void setCategoryDefiningcode(CategoryDefiningcode categoryDefiningcode) {
    this.categoryDefiningcode = categoryDefiningcode;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }
}
