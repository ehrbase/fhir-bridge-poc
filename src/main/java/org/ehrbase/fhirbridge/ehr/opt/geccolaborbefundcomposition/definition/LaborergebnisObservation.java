package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DataValue;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.laboratory_test_result.v1")
public class LaborergebnisObservation {
  @Path("/protocol[at0004]/items[at0110]")
  private List<Cluster> testDetails;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.specimen.v1]")
  private List<ProbeCluster> probe;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0005]/name|value")
  private String labortestBezeichnungValue;

  @Path("/protocol[at0004]/items[at0121]/value")
  private DataValue value;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0057]/value|value")
  private String schlussfolgerungValue;

  @Path("/protocol[at0004]/items[at0094]/items[at0062]/name|value")
  private String einsendendenSystemsValue;

  @Path("/protocol[at0004]/items[at0094]/items[at0090]")
  private Cluster einsender;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0118]")
  private List<Cluster> multimediaDarstellung;

  @Path("/protocol[at0004]/items[at0094]/items[at0062]/value")
  @Choice
  private ProbeEinsendendenSystemsChoice einsendendenSystems;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0005]/value|defining_code")
  private LabortestBezeichnungDefiningcode labortestBezeichnungDefiningcode;

  @Path("/data[at0001]/events[at0002]/state[at0112]/items[at0114]")
  private List<Cluster> strukturierteErfassungDerStorfaktoren;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0122]")
  private List<Cluster> strukturierteTestdiagnostik;

  @Path("/protocol[at0004]/items[at0117]")
  private List<Cluster> erweiterung;

  @Path(
      "/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.laboratory_test_analyte.v1 and name/value='Pro Laboranalyt']")
  private ProLaboranalytCluster proLaboranalyt;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/protocol[at0004]/items[at0094]/items[at0035]")
  private List<Cluster> verteilerliste;

  @Path("/protocol[at0004]/items[at0017]")
  private Cluster laborWelchesDenUntersuchungsauftragAnnimmt;

  public void setTestDetails(List<Cluster> testDetails) {
    this.testDetails = testDetails;
  }

  public List<Cluster> getTestDetails() {
    return this.testDetails;
  }

  public void setProbe(List<ProbeCluster> probe) {
    this.probe = probe;
  }

  public List<ProbeCluster> getProbe() {
    return this.probe;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setLabortestBezeichnungValue(String labortestBezeichnungValue) {
    this.labortestBezeichnungValue = labortestBezeichnungValue;
  }

  public String getLabortestBezeichnungValue() {
    return this.labortestBezeichnungValue;
  }

  public void setValue(DataValue value) {
    this.value = value;
  }

  public DataValue getValue() {
    return this.value;
  }

  public void setSchlussfolgerungValue(String schlussfolgerungValue) {
    this.schlussfolgerungValue = schlussfolgerungValue;
  }

  public String getSchlussfolgerungValue() {
    return this.schlussfolgerungValue;
  }

  public void setEinsendendenSystemsValue(String einsendendenSystemsValue) {
    this.einsendendenSystemsValue = einsendendenSystemsValue;
  }

  public String getEinsendendenSystemsValue() {
    return this.einsendendenSystemsValue;
  }

  public void setEinsender(Cluster einsender) {
    this.einsender = einsender;
  }

  public Cluster getEinsender() {
    return this.einsender;
  }

  public void setMultimediaDarstellung(List<Cluster> multimediaDarstellung) {
    this.multimediaDarstellung = multimediaDarstellung;
  }

  public List<Cluster> getMultimediaDarstellung() {
    return this.multimediaDarstellung;
  }

  public void setEinsendendenSystems(ProbeEinsendendenSystemsChoice einsendendenSystems) {
    this.einsendendenSystems = einsendendenSystems;
  }

  public ProbeEinsendendenSystemsChoice getEinsendendenSystems() {
    return this.einsendendenSystems;
  }

  public void setLabortestBezeichnungDefiningcode(
      LabortestBezeichnungDefiningcode labortestBezeichnungDefiningcode) {
    this.labortestBezeichnungDefiningcode = labortestBezeichnungDefiningcode;
  }

  public LabortestBezeichnungDefiningcode getLabortestBezeichnungDefiningcode() {
    return this.labortestBezeichnungDefiningcode;
  }

  public void setStrukturierteErfassungDerStorfaktoren(
      List<Cluster> strukturierteErfassungDerStorfaktoren) {
    this.strukturierteErfassungDerStorfaktoren = strukturierteErfassungDerStorfaktoren;
  }

  public List<Cluster> getStrukturierteErfassungDerStorfaktoren() {
    return this.strukturierteErfassungDerStorfaktoren;
  }

  public void setStrukturierteTestdiagnostik(List<Cluster> strukturierteTestdiagnostik) {
    this.strukturierteTestdiagnostik = strukturierteTestdiagnostik;
  }

  public List<Cluster> getStrukturierteTestdiagnostik() {
    return this.strukturierteTestdiagnostik;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
  }

  public void setProLaboranalyt(ProLaboranalytCluster proLaboranalyt) {
    this.proLaboranalyt = proLaboranalyt;
  }

  public ProLaboranalytCluster getProLaboranalyt() {
    return this.proLaboranalyt;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setSubject(PartyProxy subject) {
    this.subject = subject;
  }

  public PartyProxy getSubject() {
    return this.subject;
  }

  public void setOriginValue(TemporalAccessor originValue) {
    this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
    return this.originValue;
  }

  public void setVerteilerliste(List<Cluster> verteilerliste) {
    this.verteilerliste = verteilerliste;
  }

  public List<Cluster> getVerteilerliste() {
    return this.verteilerliste;
  }

  public void setLaborWelchesDenUntersuchungsauftragAnnimmt(
      Cluster laborWelchesDenUntersuchungsauftragAnnimmt) {
    this.laborWelchesDenUntersuchungsauftragAnnimmt = laborWelchesDenUntersuchungsauftragAnnimmt;
  }

  public Cluster getLaborWelchesDenUntersuchungsauftragAnnimmt() {
    return this.laborWelchesDenUntersuchungsauftragAnnimmt;
  }
}
