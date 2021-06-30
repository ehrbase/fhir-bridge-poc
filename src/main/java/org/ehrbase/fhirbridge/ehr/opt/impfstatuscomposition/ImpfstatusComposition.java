package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Id;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.annotations.Template;
import org.ehrbase.client.classgenerator.interfaces.CompositionEntity;
import org.ehrbase.client.classgenerator.shareddefinition.Category;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.Setting;
import org.ehrbase.client.classgenerator.shareddefinition.Territory;
import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition.ImpfungAction;
import org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition.UnbekannterImpfstatusEvaluation;

@Entity
@Archetype("openEHR-EHR-COMPOSITION.registereintrag.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-06-30T11:44:02.722457+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.4.0"
)
@Template("Impfstatus")
public class ImpfstatusComposition implements CompositionEntity {
  /**
   * Path: Impfstatus/category
   */
  @Path("/category|defining_code")
  private Category categoryDefiningCode;

  /**
   * Path: Impfstatus/context/Erweiterung
   * Description: Ergänzende Angaben zum Registereintrag.
   */
  @Path("/context/other_context[at0001]/items[at0002]")
  private List<Cluster> erweiterung;

  /**
   * Path: Impfstatus/context/start_time
   */
  @Path("/context/start_time|value")
  private TemporalAccessor startTimeValue;

  /**
   * Path: Impfstatus/context/participations
   */
  @Path("/context/participations")
  private List<Participation> participations;

  /**
   * Path: Impfstatus/context/end_time
   */
  @Path("/context/end_time|value")
  private TemporalAccessor endTimeValue;

  /**
   * Path: Impfstatus/context/location
   */
  @Path("/context/location")
  private String location;

  /**
   * Path: Impfstatus/context/health_care_facility
   */
  @Path("/context/health_care_facility")
  private PartyIdentified healthCareFacility;

  /**
   * Path: Impfstatus/context/setting
   */
  @Path("/context/setting|defining_code")
  private Setting settingDefiningCode;

  /**
   * Path: Impfstatus/Impfung
   * Description: Jede Aktivität in Bezug auf die Planung, Vorbereitung, Rezeptverwaltung, Ausgabe, Verabreichung, Einnahme, Absetzung und anderer Verwendung von Arzneimitteln, Impfstoffen, Nahrungsergänzungsmitteln und anderen therapeutischen Mitteln.
   * Comment: Dies beschränkt sich nicht nur auf Aktivitäten, die auf der Grundlage von Arzneimittelverordnungen von Ärzten durchgeführt werden, sondern kann sich auch z.B. auf die Einnahme von freiverkäuflichen Medikamenten beziehen.
   */
  @Path("/content[openEHR-EHR-ACTION.medication.v1 and name/value='Impfung']")
  private List<ImpfungAction> impfung;

  /**
   * Path: Impfstatus/Unbekannter Impfstatus
   * Description: Aussage darüber, dass bestimmte Gesundheitsinformationen zum Zeitpukt der Erfassung nicht in der Krankenakte oder einem Schriftstück erfasst werden können, da keine Kenntnisse darüber vorhanden sind.
   */
  @Path("/content[openEHR-EHR-EVALUATION.absence.v2 and name/value='Unbekannter Impfstatus']")
  private UnbekannterImpfstatusEvaluation unbekannterImpfstatus;

  /**
   * Path: Impfstatus/composer
   */
  @Path("/composer")
  private PartyProxy composer;

  /**
   * Path: Impfstatus/language
   */
  @Path("/language")
  private Language language;

  /**
   * Path: Impfstatus/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Impfstatus/territory
   */
  @Path("/territory")
  private Territory territory;

  @Id
  private VersionUid versionUid;

  public void setCategoryDefiningCode(Category categoryDefiningCode) {
     this.categoryDefiningCode = categoryDefiningCode;
  }

  public Category getCategoryDefiningCode() {
     return this.categoryDefiningCode ;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
     this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
     return this.erweiterung ;
  }

  public void setStartTimeValue(TemporalAccessor startTimeValue) {
     this.startTimeValue = startTimeValue;
  }

  public TemporalAccessor getStartTimeValue() {
     return this.startTimeValue ;
  }

  public void setParticipations(List<Participation> participations) {
     this.participations = participations;
  }

  public List<Participation> getParticipations() {
     return this.participations ;
  }

  public void setEndTimeValue(TemporalAccessor endTimeValue) {
     this.endTimeValue = endTimeValue;
  }

  public TemporalAccessor getEndTimeValue() {
     return this.endTimeValue ;
  }

  public void setLocation(String location) {
     this.location = location;
  }

  public String getLocation() {
     return this.location ;
  }

  public void setHealthCareFacility(PartyIdentified healthCareFacility) {
     this.healthCareFacility = healthCareFacility;
  }

  public PartyIdentified getHealthCareFacility() {
     return this.healthCareFacility ;
  }

  public void setSettingDefiningCode(Setting settingDefiningCode) {
     this.settingDefiningCode = settingDefiningCode;
  }

  public Setting getSettingDefiningCode() {
     return this.settingDefiningCode ;
  }

  public void setImpfung(List<ImpfungAction> impfung) {
     this.impfung = impfung;
  }

  public List<ImpfungAction> getImpfung() {
     return this.impfung ;
  }

  public void setUnbekannterImpfstatus(UnbekannterImpfstatusEvaluation unbekannterImpfstatus) {
     this.unbekannterImpfstatus = unbekannterImpfstatus;
  }

  public UnbekannterImpfstatusEvaluation getUnbekannterImpfstatus() {
     return this.unbekannterImpfstatus ;
  }

  public void setComposer(PartyProxy composer) {
     this.composer = composer;
  }

  public PartyProxy getComposer() {
     return this.composer ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setTerritory(Territory territory) {
     this.territory = territory;
  }

  public Territory getTerritory() {
     return this.territory ;
  }

  public VersionUid getVersionUid() {
     return this.versionUid ;
  }

  public void setVersionUid(VersionUid versionUid) {
     this.versionUid = versionUid;
  }
}
