package org.ehrbase.fhirbridge.ehr.opt.d4lquestionnairecomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-CLUSTER.symptom_sign.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-04-22T17:20:48.102395+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class SchuettelfrostInDenLetzten24StundenCluster implements LocatableEntity {
  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Name des Symptoms/Krankheitsanzeichens
   * Description: Der Name des berichteten Symptoms/Krankheitsanzeichens.
   * Comment: Der Name des Symptoms sollte, wenn möglich, mit einer Terminologie kodiert werden.
   */
  @Path("/items[at0001]/value|value")
  private String nameDesSymptomsKrankheitsanzeichensValue;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Structure/Schüttelfrost in den letzten 24 Stunden/Name des Symptoms/Krankheitsanzeichens/null_flavour
   */
  @Path("/items[at0001]/null_flavour|defining_code")
  private NullFlavour nameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Vorhanden?
   * Description: Das identifizierte Symptom/Krankheitsanzeichen wurde als nicht signifikant gemeldet.
   * Comment: Dokumentieren Sie diesen Wert als "wahr", wenn der Patient das Symptom als nicht signifikant gemeldet hat. Zum Beispiel: Wenn die Person das Symptom noch nie erlebt hat, ist es angebracht "nicht signifikant" zu erfassen; oder wenn die Person das Symptom gewöhnlich erlebt, kann es unter bestimmten Umständen als angemessen erachtet werden, "nicht signifikant" zu erfassen, wenn die Person dieses nicht als Abweichung von ihrem Normalzustand empfindet.
   */
  @Path("/items[at0035 and name/value='Vorhanden?']/value|value")
  private Boolean vorhandenValue;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Structure/Schüttelfrost in den letzten 24 Stunden/Vorhanden?/null_flavour
   */
  @Path("/items[at0035 and name/value='Vorhanden?']/null_flavour|defining_code")
  private NullFlavour vorhandenNullFlavourDefiningCode;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Spezifische anatomische Lokalisation
   * Description: Spezifische anatomische Lokalisation des Symptoms/Krankheitsanzeichens.
   * Comment: Wenn die anatomische Lokalisation über vordefinierte Codes in den Symptomnamen aufgenommen wird, wird die Verwendung dieses Slots überflüssig. Wenn die anatomische Lokalisation mit dem Datenelement "Anatomische Lokalisation" erfasst wird, ist die Verwendung von CLUSTER-Archetypen in diesem Slot nicht erlaubt - erfassen Sie entweder die grobe "Anatomische Lokalisation" oder die "Spezifische anatomische Lokalisation", nicht beides.
   */
  @Path("/items[at0147]")
  private List<Cluster> spezifischeAnatomischeLokalisation;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Spezifische Details
   * Description: Spezifische Datenelemente, die zusätzlich erforderlich sind, um eindeutige Attribute des identifizierten Symptoms/Krankheitsanzeichens zu erfassen.
   * Comment: Zum Beispiel: CTCAE Einteilung.
   */
  @Path("/items[at0153]")
  private List<Cluster> spezifischeDetails;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Vorangegangene Episoden
   * Description: Strukturierte Details des Symptoms/Befundes während einer früheren Episode.
   * Comment: In vernetzten klinischen Systemen ist es möglich, dass vorangegangene Episoden bereits in der elektronischen Gesundheitsakte (engl. Electronic Health Record - EHR) erfasst wurden. Die Systeme können es dem Arzt ermöglichen, auf relevante vorangegangene Episoden zu verweisen. In einem System oder einer Nachricht ohne eine Verlinkung zu bestehenden Daten oder bei einem neuen Patienten können zusätzliche Instanzen des Symptom-Archetyps aufgenommen werden, um frühere Episoden darzustellen. Es wird empfohlen, dass neue Instanzen des Symptom-Archetyps, die in diesen Slot eingefügt werden, eine oder mehrere vorangegangene Episoden dieser Symptom-Instanz darstellen.
   */
  @Path("/items[at0146]")
  private List<Cluster> vorangegangeneEpisoden;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/Assoziierte Symptome/Krankheitsanzeichen
   * Description: Strukturierte Details über alle assoziierten Symptome/Krankheitsanzeichen, die gleichzeitig auftreten.
   * Comment: In vernetzten klinischen Systemen ist es möglich, dass verbundene Symptome/Krankheitsanzeichen bereits in der elektronischen Gesundheitsakte (engl. Electronic Health Record - EHR) erfasst wurden. Die Systeme können es dem Arzt ermöglichen, auf relevante in Zusammenhang stehende Symptomen/Krankheitsanzeichen zu verweisen. In einem System oder einer Nachricht ohne eine Verlinkung zu bestehenden Daten oder bei einem neuen Patienten können zusätzliche Instanzen des Symptom-Archetyps hier aufgenommen werden, um damit verbundene Symptome/Krankheitsanzeichen darzustellen.
   */
  @Path("/items[at0063]")
  private List<Cluster> assoziierteSymptomeKrankheitsanzeichen;

  /**
   * Path: Selbstüberwachung/Symptome/Problem/Diagnose/Schüttelfrost in den letzten 24 Stunden/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setNameDesSymptomsKrankheitsanzeichensValue(
      String nameDesSymptomsKrankheitsanzeichensValue) {
     this.nameDesSymptomsKrankheitsanzeichensValue = nameDesSymptomsKrankheitsanzeichensValue;
  }

  public String getNameDesSymptomsKrankheitsanzeichensValue() {
     return this.nameDesSymptomsKrankheitsanzeichensValue ;
  }

  public void setNameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode(
      NullFlavour nameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode) {
     this.nameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode = nameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode;
  }

  public NullFlavour getNameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode() {
     return this.nameDesSymptomsKrankheitsanzeichensNullFlavourDefiningCode ;
  }

  public void setVorhandenValue(Boolean vorhandenValue) {
     this.vorhandenValue = vorhandenValue;
  }

  public Boolean isVorhandenValue() {
     return this.vorhandenValue ;
  }

  public void setVorhandenNullFlavourDefiningCode(NullFlavour vorhandenNullFlavourDefiningCode) {
     this.vorhandenNullFlavourDefiningCode = vorhandenNullFlavourDefiningCode;
  }

  public NullFlavour getVorhandenNullFlavourDefiningCode() {
     return this.vorhandenNullFlavourDefiningCode ;
  }

  public void setSpezifischeAnatomischeLokalisation(
      List<Cluster> spezifischeAnatomischeLokalisation) {
     this.spezifischeAnatomischeLokalisation = spezifischeAnatomischeLokalisation;
  }

  public List<Cluster> getSpezifischeAnatomischeLokalisation() {
     return this.spezifischeAnatomischeLokalisation ;
  }

  public void setSpezifischeDetails(List<Cluster> spezifischeDetails) {
     this.spezifischeDetails = spezifischeDetails;
  }

  public List<Cluster> getSpezifischeDetails() {
     return this.spezifischeDetails ;
  }

  public void setVorangegangeneEpisoden(List<Cluster> vorangegangeneEpisoden) {
     this.vorangegangeneEpisoden = vorangegangeneEpisoden;
  }

  public List<Cluster> getVorangegangeneEpisoden() {
     return this.vorangegangeneEpisoden ;
  }

  public void setAssoziierteSymptomeKrankheitsanzeichen(
      List<Cluster> assoziierteSymptomeKrankheitsanzeichen) {
     this.assoziierteSymptomeKrankheitsanzeichen = assoziierteSymptomeKrankheitsanzeichen;
  }

  public List<Cluster> getAssoziierteSymptomeKrankheitsanzeichen() {
     return this.assoziierteSymptomeKrankheitsanzeichen ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
