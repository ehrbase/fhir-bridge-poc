package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-CLUSTER.anatomical_location.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.683370900+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class AnatomischeLokalisationCluster implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Probe/Anatomische Lokalisation/Name der Körperstelle
   * Description: Identifikation einer einzelnen physischen Stelle entweder am oder innerhalb des menschlichen Körpers.
   * Comment: Dieses Datenelement ist der einzige verpflichtend auszufüllende Datenpunkt in diesem Archetypen und sollte als primärer Datenpunkt verwendet werden, um eine anatomische Lokalisation mit einem häufig verwendeten Namen aufzuzeichnen. Es wird dringend empfohlen, dass der Name der Körperstelle so genau aufgezeichnet wird, wie es anatomisch möglich ist. Zum Beispiel: zeichne "oberes Augenlid" auf und nicht "Augenlid" mit "oberer" als Qualifier; "fünfte Rippe" statt "Rippe" mit einem numerischen Qualifier. Verwenden Sie die anderen Datenelemente für Lateralität, Sichtweise, Region und anatomische Linie, um mehr Details anzugeben. 
   *
   * Dieses Datenelement sollte mit einer Terminologie kodiert werden, die nach Möglichkeit Entscheidungsunterstützung auslösen kann - ein geeignetes Termset für die Verwendung hier könnte aus einzelnen Konzepten oder einer Liste von vorab abgestimmten Begriffen zusammengesetzt sein. Freitext sollte nur verwendet werden, wenn keine entsprechende Terminologie vorhanden ist. 
   *
   * Wenn der Name der Körperstelle bereits im übergeordneten Archetyp angegeben ist, kann dieses Datenelement redundant sein. Alternativ wurde ein Anwendungsfall ermittelt, bei dem der Wert in dieses Element dupliziert sein könnte, um semantische Abfragen unter Verwendung dieses Archetyps und nicht das Datenelement innerhalb des übergeordneten Elements zu unterstützen.
   */
  @Path("/items[at0001]/value")
  private DvCodedText nameDerKoerperstelle;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Probe/Anatomische Lokalisation/Name der Körperstelle/null_flavour
   */
  @Path("/items[at0001]/null_flavour|defining_code")
  private NullFlavour nameDerKoerperstelleNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Probe/Anatomische Lokalisation/Alternative Struktur
   * Description: Zusätzliche Informationen über die anatomische Lage mit alternativen Ansätzen zur Beschreibung der gleichen Körperstelle.
   * Comment: Zum Beispiel, relative oder exakte Positionen unter Verwendung von Koordinaten.
   */
  @Path("/items[at0053]")
  private List<Cluster> alternativeStruktur;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Probe/Anatomische Lokalisation/Multimediale Darstellung
   * Description: Bilder oder andere Medien, die der Identifizierung der Körperstelle dienen.
   */
  @Path("/items[at0054]")
  private List<Cluster> multimedialeDarstellung;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Probe/Anatomische Lokalisation/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setNameDerKoerperstelle(DvCodedText nameDerKoerperstelle) {
     this.nameDerKoerperstelle = nameDerKoerperstelle;
  }

  public DvCodedText getNameDerKoerperstelle() {
     return this.nameDerKoerperstelle ;
  }

  public void setNameDerKoerperstelleNullFlavourDefiningCode(
      NullFlavour nameDerKoerperstelleNullFlavourDefiningCode) {
     this.nameDerKoerperstelleNullFlavourDefiningCode = nameDerKoerperstelleNullFlavourDefiningCode;
  }

  public NullFlavour getNameDerKoerperstelleNullFlavourDefiningCode() {
     return this.nameDerKoerperstelleNullFlavourDefiningCode ;
  }

  public void setAlternativeStruktur(List<Cluster> alternativeStruktur) {
     this.alternativeStruktur = alternativeStruktur;
  }

  public List<Cluster> getAlternativeStruktur() {
     return this.alternativeStruktur ;
  }

  public void setMultimedialeDarstellung(List<Cluster> multimedialeDarstellung) {
     this.multimedialeDarstellung = multimedialeDarstellung;
  }

  public List<Cluster> getMultimedialeDarstellung() {
     return this.multimedialeDarstellung ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
