package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.PointEventEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.745332800+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
@OptionFor("POINT_EVENT")
public class BefundJedesEreignisPointEvent implements PointEventEntity, BefundJedesEreignisChoice {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Bezeichnung
   * Description: Name der Laboruntersuchung, die an der/den Probe(n) durchgeführt wurde.
   * Comment: Ein Laborergebnis kann sich auf ein einzelnes Analyt oder eine Analytgruppe beziehen. Dazu zählen auch komplette Panel an Parametern. 
   * Es wird dringend empfohlen, die "Labortest-Bezeichnung" anhand einer Terminologie zu kodiereren, wie zum Beispiel LOINC oder SNOMED CT. Beispiel: "Glukose", "Harnstoff", "Abstrich", "Cortisol", "Leberbiopsie". Der Name kann u.U. auch das Probenmaterial oder den Patientenstatus (z.B. "Blutzuckerspiegel nüchtern") oder andere Informationen beinhalten wie "Kalium (Blutgas)".
   */
  @Path("/data[at0003]/items[at0005]/value")
  private DvCodedText labortestBezeichnung;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Bezeichnung/null_flavour
   */
  @Path("/data[at0003]/items[at0005]/null_flavour|defining_code")
  private NullFlavour labortestBezeichnungNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Probe
   * Description: Eine physikalische Probe zur Erforschung, Untersuchung oder Analyse, die von einer Person entnommen wurde oder die sich auf die Person bezieht.
   * Comment: Zum Beispiel: Gewebe, Körperflüssigkeit oder Lebensmittel.
   */
  @Path("/data[at0003]/items[openEHR-EHR-CLUSTER.specimen.v1]")
  private ProbeCluster probe;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel
   * Description: Laborergebnis als Panel/Profil von Einzelresultaten. Verbreitet im medizinischen Labor.
   */
  @Path("/data[at0003]/items[openEHR-EHR-CLUSTER.laboratory_test_panel.v0]")
  private LabortestPanelCluster labortestPanel;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Strukturierte Testdiagnostik
   * Description: Eine strukturierte oder komplexe Diagnose für die Laboruntersuchung.
   * Comment: Zum Beispiel: Anatomische Pathologiediagnosen, die aus mehreren verschiedenen Schwerpunkten wie Morphologie, Ätiologie und Funktion zusammengesetzt sind.
   */
  @Path("/data[at0003]/items[at0122]")
  private List<Cluster> strukturierteTestdiagnostik;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Multimedia-Darstellung
   * Description: Bild, Video oder Diagramm zur Visualisierung des Testergebnisses.
   * Comment: Mehrere Formate sind erlaubt - diese sollten aber einen äquivalenten klinischen Inhalt darstellen.
   */
  @Path("/data[at0003]/items[at0118]")
  private List<Cluster> multimediaDarstellung;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Kommentar
   * Description: Weitere Informationen über das Laborergebnis, welche bisher nicht in den anderen Feldern erfasst wurden.
   */
  @Path("/data[at0003]/items[at0101]")
  private List<BefundKommentarElement> kommentar;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Strukturierte Erfassung der Störfaktoren
   * Description: Einzelheiten zu Problemen oder Umständen, die sich auf die genaue Interpretation der Messung oder des Prüfergebnisses auswirken.
   * Comment: Zum Beispiel: Letzte normale Menstruationsperiode (LNMP).
   */
  @Path("/state[at0112]/items[at0114]")
  private List<Cluster> strukturierteErfassungDerStoerfaktoren;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/time
   */
  @Path("/time|value")
  private TemporalAccessor timeValue;

  public void setLabortestBezeichnung(DvCodedText labortestBezeichnung) {
     this.labortestBezeichnung = labortestBezeichnung;
  }

  public DvCodedText getLabortestBezeichnung() {
     return this.labortestBezeichnung ;
  }

  public void setLabortestBezeichnungNullFlavourDefiningCode(
      NullFlavour labortestBezeichnungNullFlavourDefiningCode) {
     this.labortestBezeichnungNullFlavourDefiningCode = labortestBezeichnungNullFlavourDefiningCode;
  }

  public NullFlavour getLabortestBezeichnungNullFlavourDefiningCode() {
     return this.labortestBezeichnungNullFlavourDefiningCode ;
  }

  public void setProbe(ProbeCluster probe) {
     this.probe = probe;
  }

  public ProbeCluster getProbe() {
     return this.probe ;
  }

  public void setLabortestPanel(LabortestPanelCluster labortestPanel) {
     this.labortestPanel = labortestPanel;
  }

  public LabortestPanelCluster getLabortestPanel() {
     return this.labortestPanel ;
  }

  public void setStrukturierteTestdiagnostik(List<Cluster> strukturierteTestdiagnostik) {
     this.strukturierteTestdiagnostik = strukturierteTestdiagnostik;
  }

  public List<Cluster> getStrukturierteTestdiagnostik() {
     return this.strukturierteTestdiagnostik ;
  }

  public void setMultimediaDarstellung(List<Cluster> multimediaDarstellung) {
     this.multimediaDarstellung = multimediaDarstellung;
  }

  public List<Cluster> getMultimediaDarstellung() {
     return this.multimediaDarstellung ;
  }

  public void setKommentar(List<BefundKommentarElement> kommentar) {
     this.kommentar = kommentar;
  }

  public List<BefundKommentarElement> getKommentar() {
     return this.kommentar ;
  }

  public void setStrukturierteErfassungDerStoerfaktoren(
      List<Cluster> strukturierteErfassungDerStoerfaktoren) {
     this.strukturierteErfassungDerStoerfaktoren = strukturierteErfassungDerStoerfaktoren;
  }

  public List<Cluster> getStrukturierteErfassungDerStoerfaktoren() {
     return this.strukturierteErfassungDerStoerfaktoren ;
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
}
