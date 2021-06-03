package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.lang.Long;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.710449700+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class ProAnalytCluster implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Analyseergebnis-Reihenfolge
   * Description: Die beabsichtigte Position dieses Analyseergebnisses in der Reihenfolge aller Analyseergebnisse.
   * Comment: z.B. '1', '2', '3'. Werden mehrere Analysenergebnisse berichtet, gibt die Analyseergebnis-Reihenfolge explizit die Reihenfolge der Analyseergebnisse an.
   */
  @Path("/items[at0027]/value|magnitude")
  private Long analyseergebnisReihenfolgeMagnitude;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Analyseergebnis-Reihenfolge/null_flavour
   */
  @Path("/items[at0027]/null_flavour|defining_code")
  private NullFlavour analyseergebnisReihenfolgeNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Virusnachweistest
   * Description: Der Name des untersuchten Analyts.
   * Comment: Der Wert dieses Elements wird normalerweise, meist durch eine Spezialisierung, in einem Template oder zur Laufzeit der Anwendung geliefert, um den aktuellen Analyt wiederzugeben. Zum Beispiel: 'Natrium im Serum', 'Hämoglobin'. 
   * Die Codierung mit einer externen Terminologie, wie LOINC, NPU, SNOMED-CT oder lokalen Labor-Terminologien wird dringend empfohlen.
   */
  @Path("/items[at0024 and name/value='Virusnachweistest']/value")
  private DvCodedText virusnachweistest;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Virusnachweistest/null_flavour
   */
  @Path("/items[at0024 and name/value='Virusnachweistest']/null_flavour|defining_code")
  private NullFlavour virusnachweistestNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Nachweis
   * Description: (Mess-)Wert des Analyt-Resultats.
   * Comment: z.B. "7,3 mmol/l", "Erhöht". Der "Any"-Datentyp wird dann durch eine Spezialisierung, eine Vorlage oder zur Laufzeit der Anwendung auf einen passenden Datentyp eingeschränkt werden müssen, um das aktuelle Analyt-Ergebnis wiederzugeben. Der "Quantity"-Datentyp hat Referenzmodell-Attribute, wie Kennungen für normal/abnormal, Referenzbereiche und Näherungen - für weitere Details s. https://specifications.openehr.org/releases/RM/latest/data_types.html#_dv_quantity_class .
   */
  @Path("/items[at0001 and name/value='Nachweis']/value")
  private DvCodedText nachweis;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Nachweis/null_flavour
   */
  @Path("/items[at0001 and name/value='Nachweis']/null_flavour|defining_code")
  private NullFlavour nachweisNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Quantitatives Ergebnis
   * Description: (Mess-)Wert des Analyt-Resultats.
   * Comment: z.B. "7,3 mmol/l", "Erhöht". Der "Any"-Datentyp wird dann durch eine Spezialisierung, eine Vorlage oder zur Laufzeit der Anwendung auf einen passenden Datentyp eingeschränkt werden müssen, um das aktuelle Analyt-Ergebnis wiederzugeben. Der "Quantity"-Datentyp hat Referenzmodell-Attribute, wie Kennungen für normal/abnormal, Referenzbereiche und Näherungen - für weitere Details s. https://specifications.openehr.org/releases/RM/latest/data_types.html#_dv_quantity_class .
   */
  @Path("/items[at0001 and name/value='Quantitatives Ergebnis']")
  private List<ProAnalytQuantitativesErgebnisElement> quantitativesErgebnis;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Analyseergebnis-Details
   * Description: Weitere Details zu einem einzelnen Ergebnis.
   */
  @Path("/items[at0014]")
  private List<Cluster> analyseergebnisDetails;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Interpretation
   * Description: Zusätzliche Hinweise zur Anwendbarkeit des Referenzbereichs für dieses Resultat oder (codierter) Text, ob das Resultat im Referenzbereich ist oder nicht.
   * Comment: z.B.: 'im Referenzbereich, bezogen auf Alter und Geschlecht'.
   */
  @Path("/items[at0004 and name/value='Interpretation']/value|value")
  private String interpretationValue;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Interpretation/null_flavour
   */
  @Path("/items[at0004 and name/value='Interpretation']/null_flavour|defining_code")
  private NullFlavour interpretationNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Testmethode/null_flavour
   */
  @Path("/items[at0028]/null_flavour|defining_code")
  private NullFlavour testmethodeNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Zeitpunkt der Validierung
   * Description: Datum und Zeit, an dem das Analyseergebnis im Labor medizinisch validiert wurde.
   * Comment: In vielen Gerichtsbarkeiten wird angenommen, dass der 'Ergebnisstatus' die medizinische Validierung einschliesst, in anderen wird diese anhand dieses Datenelements separat erfasst und befundet.
   */
  @Path("/items[at0025]/value|value")
  private TemporalAccessor zeitpunktDerValidierungValue;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Zeitpunkt der Validierung/null_flavour
   */
  @Path("/items[at0025]/null_flavour|defining_code")
  private NullFlavour zeitpunktDerValidierungNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Ergebnis-Status
   * Description: Status des Analyseergebnisses.
   * Comment: Die Werte wurden analog zum HL7 FHIR Diagnostic Report gewählt, die wiederum aus der HL7-Praxis stammen. Andere Codes/Ausdrücke können über den Text 'choice' verwendet werden.
   */
  @Path("/items[at0005]")
  private List<ProAnalytErgebnisStatusElement> ergebnisStatus;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Zeitpunkt Ergebnis-Status
   * Description: Datum und/oder Zeitpunkt an dem der Status für das Analyseergebnis gesetzt wurde.
   */
  @Path("/items[at0006]/value|value")
  private TemporalAccessor zeitpunktErgebnisStatusValue;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Zeitpunkt Ergebnis-Status/null_flavour
   */
  @Path("/items[at0006]/null_flavour|defining_code")
  private NullFlavour zeitpunktErgebnisStatusNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Zugehörige Laborprobe/null_flavour
   */
  @Path("/items[at0026 and name/value='Zugehörige Laborprobe']/null_flavour|defining_code")
  private NullFlavour zugehoerigeLaborprobeNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Kommentar
   * Description: Kommentar zum Analyt-Ergebnis, soweit noch nicht in anderen Feldern erfasst.
   */
  @Path("/items[at0003]/value|value")
  private String kommentarValue;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Kommentar/null_flavour
   */
  @Path("/items[at0003]/null_flavour|defining_code")
  private NullFlavour kommentarNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Zugehörige Laborprobe
   * Description: Kennung der Probe, die für das Analyseergebnis verwendet wurde.
   */
  @Path("/items[at0026 and name/value='Zugehörige Laborprobe']/value")
  @Choice
  private ProAnalytZugehoerigeLaborprobeChoice zugehoerigeLaborprobe;

  public void setAnalyseergebnisReihenfolgeMagnitude(Long analyseergebnisReihenfolgeMagnitude) {
     this.analyseergebnisReihenfolgeMagnitude = analyseergebnisReihenfolgeMagnitude;
  }

  public Long getAnalyseergebnisReihenfolgeMagnitude() {
     return this.analyseergebnisReihenfolgeMagnitude ;
  }

  public void setAnalyseergebnisReihenfolgeNullFlavourDefiningCode(
      NullFlavour analyseergebnisReihenfolgeNullFlavourDefiningCode) {
     this.analyseergebnisReihenfolgeNullFlavourDefiningCode = analyseergebnisReihenfolgeNullFlavourDefiningCode;
  }

  public NullFlavour getAnalyseergebnisReihenfolgeNullFlavourDefiningCode() {
     return this.analyseergebnisReihenfolgeNullFlavourDefiningCode ;
  }

  public void setVirusnachweistest(DvCodedText virusnachweistest) {
     this.virusnachweistest = virusnachweistest;
  }

  public DvCodedText getVirusnachweistest() {
     return this.virusnachweistest ;
  }

  public void setVirusnachweistestNullFlavourDefiningCode(
      NullFlavour virusnachweistestNullFlavourDefiningCode) {
     this.virusnachweistestNullFlavourDefiningCode = virusnachweistestNullFlavourDefiningCode;
  }

  public NullFlavour getVirusnachweistestNullFlavourDefiningCode() {
     return this.virusnachweistestNullFlavourDefiningCode ;
  }

  public void setNachweis(DvCodedText nachweis) {
     this.nachweis = nachweis;
  }

  public DvCodedText getNachweis() {
     return this.nachweis ;
  }

  public void setNachweisNullFlavourDefiningCode(NullFlavour nachweisNullFlavourDefiningCode) {
     this.nachweisNullFlavourDefiningCode = nachweisNullFlavourDefiningCode;
  }

  public NullFlavour getNachweisNullFlavourDefiningCode() {
     return this.nachweisNullFlavourDefiningCode ;
  }

  public void setQuantitativesErgebnis(
      List<ProAnalytQuantitativesErgebnisElement> quantitativesErgebnis) {
     this.quantitativesErgebnis = quantitativesErgebnis;
  }

  public List<ProAnalytQuantitativesErgebnisElement> getQuantitativesErgebnis() {
     return this.quantitativesErgebnis ;
  }

  public void setAnalyseergebnisDetails(List<Cluster> analyseergebnisDetails) {
     this.analyseergebnisDetails = analyseergebnisDetails;
  }

  public List<Cluster> getAnalyseergebnisDetails() {
     return this.analyseergebnisDetails ;
  }

  public void setInterpretationValue(String interpretationValue) {
     this.interpretationValue = interpretationValue;
  }

  public String getInterpretationValue() {
     return this.interpretationValue ;
  }

  public void setInterpretationNullFlavourDefiningCode(
      NullFlavour interpretationNullFlavourDefiningCode) {
     this.interpretationNullFlavourDefiningCode = interpretationNullFlavourDefiningCode;
  }

  public NullFlavour getInterpretationNullFlavourDefiningCode() {
     return this.interpretationNullFlavourDefiningCode ;
  }

  public void setTestmethodeNullFlavourDefiningCode(
      NullFlavour testmethodeNullFlavourDefiningCode) {
     this.testmethodeNullFlavourDefiningCode = testmethodeNullFlavourDefiningCode;
  }

  public NullFlavour getTestmethodeNullFlavourDefiningCode() {
     return this.testmethodeNullFlavourDefiningCode ;
  }

  public void setZeitpunktDerValidierungValue(TemporalAccessor zeitpunktDerValidierungValue) {
     this.zeitpunktDerValidierungValue = zeitpunktDerValidierungValue;
  }

  public TemporalAccessor getZeitpunktDerValidierungValue() {
     return this.zeitpunktDerValidierungValue ;
  }

  public void setZeitpunktDerValidierungNullFlavourDefiningCode(
      NullFlavour zeitpunktDerValidierungNullFlavourDefiningCode) {
     this.zeitpunktDerValidierungNullFlavourDefiningCode = zeitpunktDerValidierungNullFlavourDefiningCode;
  }

  public NullFlavour getZeitpunktDerValidierungNullFlavourDefiningCode() {
     return this.zeitpunktDerValidierungNullFlavourDefiningCode ;
  }

  public void setErgebnisStatus(List<ProAnalytErgebnisStatusElement> ergebnisStatus) {
     this.ergebnisStatus = ergebnisStatus;
  }

  public List<ProAnalytErgebnisStatusElement> getErgebnisStatus() {
     return this.ergebnisStatus ;
  }

  public void setZeitpunktErgebnisStatusValue(TemporalAccessor zeitpunktErgebnisStatusValue) {
     this.zeitpunktErgebnisStatusValue = zeitpunktErgebnisStatusValue;
  }

  public TemporalAccessor getZeitpunktErgebnisStatusValue() {
     return this.zeitpunktErgebnisStatusValue ;
  }

  public void setZeitpunktErgebnisStatusNullFlavourDefiningCode(
      NullFlavour zeitpunktErgebnisStatusNullFlavourDefiningCode) {
     this.zeitpunktErgebnisStatusNullFlavourDefiningCode = zeitpunktErgebnisStatusNullFlavourDefiningCode;
  }

  public NullFlavour getZeitpunktErgebnisStatusNullFlavourDefiningCode() {
     return this.zeitpunktErgebnisStatusNullFlavourDefiningCode ;
  }

  public void setZugehoerigeLaborprobeNullFlavourDefiningCode(
      NullFlavour zugehoerigeLaborprobeNullFlavourDefiningCode) {
     this.zugehoerigeLaborprobeNullFlavourDefiningCode = zugehoerigeLaborprobeNullFlavourDefiningCode;
  }

  public NullFlavour getZugehoerigeLaborprobeNullFlavourDefiningCode() {
     return this.zugehoerigeLaborprobeNullFlavourDefiningCode ;
  }

  public void setKommentarValue(String kommentarValue) {
     this.kommentarValue = kommentarValue;
  }

  public String getKommentarValue() {
     return this.kommentarValue ;
  }

  public void setKommentarNullFlavourDefiningCode(NullFlavour kommentarNullFlavourDefiningCode) {
     this.kommentarNullFlavourDefiningCode = kommentarNullFlavourDefiningCode;
  }

  public NullFlavour getKommentarNullFlavourDefiningCode() {
     return this.kommentarNullFlavourDefiningCode ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setZugehoerigeLaborprobe(ProAnalytZugehoerigeLaborprobeChoice zugehoerigeLaborprobe) {
     this.zugehoerigeLaborprobe = zugehoerigeLaborprobe;
  }

  public ProAnalytZugehoerigeLaborprobeChoice getZugehoerigeLaborprobe() {
     return this.zugehoerigeLaborprobe ;
  }
}
