package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.EntryEntity;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;
import org.ehrbase.client.classgenerator.shareddefinition.Transition;

@Entity
@Archetype("openEHR-EHR-ACTION.medication.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-06-30T11:44:02.752999+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.4.0"
)
public class ImpfungAction implements EntryEntity {
  /**
   * Path: Impfstatus/Impfung/Impfstoff
   * Description: Name des Arzneimittels, eines Impfstoffs oder eines anderen therapeutischen Mittels, welches im Mittelpunkt der Aktivität steht.
   * Comment: Zum Beispiel: "Atenolol 100 mg" oder "Tenormin Tabletten 100 mg".
   * Es wird dringend empfohlen, dass das Element "Arzneimittel" mit einer Terminologie kodiert wird, die nach Möglichkeit eine Entscheidungsunterstützung auslösen kann. Der Umfang der Kodierung kann vom einfachen Namen des Arzneimittels bis hin zu strukturierten Details über die tatsächlich verwendete Medikamentenpackung variieren. Die Freitext-Eingabe sollte nur dann verwendet werden, wenn keine entsprechende Terminologie vorhanden ist.
   */
  @Path("/description[at0017]/items[at0020 and name/value='Impfstoff']/value|defining_code")
  private ImpfstoffDefiningCode impfstoffDefiningCode;

  /**
   * Path: Impfstatus/Impfung/Tree/Impfstoff/null_flavour
   */
  @Path("/description[at0017]/items[at0020 and name/value='Impfstoff']/null_flavour|defining_code")
  private NullFlavour impfstoffNullFlavourDefiningCode;

  /**
   * Path: Impfstatus/Impfung/Arzneimitteldetails
   * Description: Strukturierte Details über das Arzneimittel inklusive Stärke, Form und Inhaltsstoffe.
   * Comment: Verwenden Sie diesen SLOT, wenn die detaillierte Beschreibung des ausgegebenen, autorisierten oder verabreichten Arzneimittels ausdrücklich angegeben werden muss. Zum Beispiel: die Form, Stärke, alle Verdünner oder Mischung von Inhaltsstoffen.
   */
  @Path("/description[at0017]/items[at0104]")
  private Cluster arzneimitteldetails;

  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen
   * Description: Kombination von Medikamentendosis und Verabreichungszeit an einem Tag im Kontext einer Medikamentenverordnung oder der Arzneimittelverwaltung.
   * Comment: Zum Beispiel: "2 Tabletten um 18 Uhr" oder "20 mg dreimal täglich". Bitte beachten Sie: Dieser Cluster kann mehrfach vorkommen, um einen vollständigen Satz von Dosismustern für eine einzelne Dosisanweisung darzustellen.
   */
  @Path("/description[at0017]/items[openEHR-EHR-CLUSTER.dosage.v1 and name/value='Verabreichte Dosen']")
  private VerabreichteDosenCluster verabreichteDosen;

  /**
   * Path: Impfstatus/Impfung/Impfung gegen
   * Description: Begründung, warum der Prozessschritt für das identifizierte Arzneimittel durchgeführt wurde.
   * Comment: Zum Beispiel: "Verschoben - Patient war zum Zeitpunkt der Arzneimittelgabe nicht verfügbar", "abgesagt - Nebenwirkung". Merke: Dies ist nicht der Grund für die Arzneimittelverordnung, sondern der spezifische Grund, warum ein Behandlungsschritt durchgeführt wurde. Wird oft verwendet, um Abweichungen von der ursprünglichen Verordnung zu dokumentieren.
   */
  @Path("/description[at0017]/items[at0021 and name/value='Impfung gegen']")
  private List<ImpfungImpfungGegenElement> impfungGegen;

  /**
   * Path: Impfstatus/Impfung/Zusätzliche Details
   * Description: Weitere strukturierte Details zu einer Aktivität, möglicherweise speziell zu einem Prozessschritt.
   */
  @Path("/description[at0017]/items[at0053]")
  private List<Cluster> zusaetzlicheDetails;

  /**
   * Path: Impfstatus/Impfung/Erweiterung
   * Description: Zusätzliche Informationen zur Erfassung lokaler Inhalte oder Anpassung an andere Referenzmodelle/Formalismen.
   * Comment: Zum Beispiel: Lokaler Informationsbedarf oder zusätzliche Metadaten zur Anpassung an FHIR-Ressourcen oder CIMI-Modelle.
   */
  @Path("/protocol[at0030]/items[at0085]")
  private List<Cluster> erweiterung;

  /**
   * Path: Impfstatus/Impfung/subject
   */
  @Path("/subject")
  private PartyProxy subject;

  /**
   * Path: Impfstatus/Impfung/language
   */
  @Path("/language")
  private Language language;

  /**
   * Path: Impfstatus/Impfung/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Impfstatus/Impfung/time
   */
  @Path("/time|value")
  private TemporalAccessor timeValue;

  /**
   * Path: Impfstatus/Impfung/ism_transition/Careflow_step
   */
  @Path("/ism_transition/careflow_step|defining_code")
  private CareflowStepDefiningCode careflowStepDefiningCode;

  /**
   * Path: Impfstatus/Impfung/ism_transition/Current_state
   */
  @Path("/ism_transition/current_state|defining_code")
  private CurrentStateDefiningCode currentStateDefiningCode;

  /**
   * Path: Impfstatus/Impfung/ism_transition/transition
   */
  @Path("/ism_transition/transition|defining_code")
  private Transition transitionDefiningCode;

  public void setImpfstoffDefiningCode(ImpfstoffDefiningCode impfstoffDefiningCode) {
     this.impfstoffDefiningCode = impfstoffDefiningCode;
  }

  public ImpfstoffDefiningCode getImpfstoffDefiningCode() {
     return this.impfstoffDefiningCode ;
  }

  public void setImpfstoffNullFlavourDefiningCode(NullFlavour impfstoffNullFlavourDefiningCode) {
     this.impfstoffNullFlavourDefiningCode = impfstoffNullFlavourDefiningCode;
  }

  public NullFlavour getImpfstoffNullFlavourDefiningCode() {
     return this.impfstoffNullFlavourDefiningCode ;
  }

  public void setArzneimitteldetails(Cluster arzneimitteldetails) {
     this.arzneimitteldetails = arzneimitteldetails;
  }

  public Cluster getArzneimitteldetails() {
     return this.arzneimitteldetails ;
  }

  public void setVerabreichteDosen(VerabreichteDosenCluster verabreichteDosen) {
     this.verabreichteDosen = verabreichteDosen;
  }

  public VerabreichteDosenCluster getVerabreichteDosen() {
     return this.verabreichteDosen ;
  }

  public void setImpfungGegen(List<ImpfungImpfungGegenElement> impfungGegen) {
     this.impfungGegen = impfungGegen;
  }

  public List<ImpfungImpfungGegenElement> getImpfungGegen() {
     return this.impfungGegen ;
  }

  public void setZusaetzlicheDetails(List<Cluster> zusaetzlicheDetails) {
     this.zusaetzlicheDetails = zusaetzlicheDetails;
  }

  public List<Cluster> getZusaetzlicheDetails() {
     return this.zusaetzlicheDetails ;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
     this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
     return this.erweiterung ;
  }

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
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

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
  }

  public void setCareflowStepDefiningCode(CareflowStepDefiningCode careflowStepDefiningCode) {
     this.careflowStepDefiningCode = careflowStepDefiningCode;
  }

  public CareflowStepDefiningCode getCareflowStepDefiningCode() {
     return this.careflowStepDefiningCode ;
  }

  public void setCurrentStateDefiningCode(CurrentStateDefiningCode currentStateDefiningCode) {
     this.currentStateDefiningCode = currentStateDefiningCode;
  }

  public CurrentStateDefiningCode getCurrentStateDefiningCode() {
     return this.currentStateDefiningCode ;
  }

  public void setTransitionDefiningCode(Transition transitionDefiningCode) {
     this.transitionDefiningCode = transitionDefiningCode;
  }

  public Transition getTransitionDefiningCode() {
     return this.transitionDefiningCode ;
  }
}
