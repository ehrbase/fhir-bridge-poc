package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.EntryEntity;
import org.ehrbase.client.classgenerator.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.laboratory_test_result.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.573986700+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class BefundObservation implements EntryEntity {
  /**
   * Path: Virologischer Befund/Befund/origin
   */
  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  /**
   * Path: Virologischer Befund/Befund/Empfängerstandort
   * Description: Eine fachliche Einheit, Organisation, Abteilung, Zusammenschluss, Gruppierung mit einem gemeinsamen Ziel.
   */
  @Path("/protocol[at0004]/items[openEHR-EHR-CLUSTER.organization.v0 and name/value='Empfängerstandort']")
  private EmpfaengerstandortCluster empfaengerstandort;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung
   * Description: Details zur Testanforderung.
   * Comment: In den meisten Fällen gibt es eine Testanfrage und ein einzelnes entsprechendes Testergebnis. Jedoch ermöglicht dieser wiederholte Cluster die Situation, dass mehrere Testanfragen mit einem einzigen Testergebnis gemeldet werden können.
   *
   * Als Beispiel: "Ein Arzt fordert in einer Anfrage Blutzucker und in einer zweiten Anfrage Harnstoff/Elektrolyte an, aber das Laboranalysegerät führt beides durch und das Labor möchte diese zusammen melden".
   */
  @Path("/protocol[at0004]/items[at0094]")
  private List<BefundDetailsDerTestanforderungCluster> detailsDerTestanforderung;

  /**
   * Path: Virologischer Befund/Befund/Test Details
   * Description: Strukturierte Details über die beim Labortest verwendete Methodik, das Gerät oder die Auswertung.
   * Comment: Zum Beispiel: "Details der ELISA/Nephelometrie".
   */
  @Path("/protocol[at0004]/items[at0110]")
  private List<Cluster> testDetails;

  /**
   * Path: Virologischer Befund/Befund/Erweiterung
   * Description: Weitere Informationen, die erforderlich sind, um lokale Inhalte abzubilden oder das Modell an andere Referenzmodelle anzupassen.
   * Comment: Zum Beispiel: Lokaler Informationsbedarf oder zusätzliche Metadaten, um ein Mapping auf FHIR oder CIMI Modelle zu ermöglichen.
   */
  @Path("/protocol[at0004]/items[at0117]")
  private List<Cluster> erweiterung;

  /**
   * Path: Virologischer Befund/Befund/subject
   */
  @Path("/subject")
  private PartyProxy subject;

  /**
   * Path: Virologischer Befund/Befund/language
   */
  @Path("/language")
  private Language language;

  /**
   * Path: Virologischer Befund/Befund/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis
   * Description: Jeder Zeitpunkt oder jedes Intervall, das in einem Template oder zur Laufzeit definiert werden kann.
   */
  @Path("/data[at0001]/events[at0002]")
  @Choice
  private List<BefundJedesEreignisChoice> jedesEreignis;

  public void setOriginValue(TemporalAccessor originValue) {
     this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
     return this.originValue ;
  }

  public void setEmpfaengerstandort(EmpfaengerstandortCluster empfaengerstandort) {
     this.empfaengerstandort = empfaengerstandort;
  }

  public EmpfaengerstandortCluster getEmpfaengerstandort() {
     return this.empfaengerstandort ;
  }

  public void setDetailsDerTestanforderung(
      List<BefundDetailsDerTestanforderungCluster> detailsDerTestanforderung) {
     this.detailsDerTestanforderung = detailsDerTestanforderung;
  }

  public List<BefundDetailsDerTestanforderungCluster> getDetailsDerTestanforderung() {
     return this.detailsDerTestanforderung ;
  }

  public void setTestDetails(List<Cluster> testDetails) {
     this.testDetails = testDetails;
  }

  public List<Cluster> getTestDetails() {
     return this.testDetails ;
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

  public void setJedesEreignis(List<BefundJedesEreignisChoice> jedesEreignis) {
     this.jedesEreignis = jedesEreignis;
  }

  public List<BefundJedesEreignisChoice> getJedesEreignis() {
     return this.jedesEreignis ;
  }
}
