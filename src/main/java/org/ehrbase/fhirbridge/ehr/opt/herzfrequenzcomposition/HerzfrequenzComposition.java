package org.ehrbase.fhirbridge.ehr.opt.herzfrequenzcomposition;

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
import org.ehrbase.fhirbridge.ehr.opt.herzfrequenzcomposition.definition.HerzfrequenzObservation;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Territory;

@Entity
@Archetype("openEHR-EHR-COMPOSITION.registereintrag.v1")
@Template("Herzfrequenz")
public class HerzfrequenzComposition implements Composition {
  @Id private VersionUid versionUid;

  @Path("/context/end_time|value")
  private TemporalAccessor endTimeValue;

  @Path("/context/participations")
  private List<Participation> participations;

  @Path("/language")
  private Language language;

  @Path("/context/health_care_facility")
  private PartyIdentified healthCareFacility;

  @Path("/territory")
  private Territory territory;

  @Path("/context/start_time|value")
  private TemporalAccessor startTimeValue;

  @Path("/content[openEHR-EHR-OBSERVATION.pulse.v2 and name/value='Herzfrequenz']")
  private HerzfrequenzObservation herzfrequenz;

  @Path("/composer")
  private PartyProxy composer;

  @Path("/context/setting|defining_code")
  private SettingDefiningcode settingDefiningcode;

  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  @Path("/context/location")
  private String location;

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

  public Territory getTerritory() {
    return this.territory;
  }

  public void setTerritory(Territory territory) {
    this.territory = territory;
  }

  public TemporalAccessor getStartTimeValue() {
    return this.startTimeValue;
  }

  public void setStartTimeValue(TemporalAccessor startTimeValue) {
    this.startTimeValue = startTimeValue;
  }

  public HerzfrequenzObservation getHerzfrequenz() {
    return this.herzfrequenz;
  }

  public void setHerzfrequenz(HerzfrequenzObservation herzfrequenz) {
    this.herzfrequenz = herzfrequenz;
  }

  public PartyProxy getComposer() {
    return this.composer;
  }

  public void setComposer(PartyProxy composer) {
    this.composer = composer;
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
