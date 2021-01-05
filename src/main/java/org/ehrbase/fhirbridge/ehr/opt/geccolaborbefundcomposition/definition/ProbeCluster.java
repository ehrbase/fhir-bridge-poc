package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-CLUSTER.specimen.v1")
public class ProbeCluster {
  @Path("/items[at0071]")
  private List<Cluster> angabenZumProbennehmer;

  @Path("/items[at0093]")
  private List<Cluster> angabenZumTransport;

  @Path("/items[at0088]/value")
  private DvIdentifier externerIdentifikator;

  @Path("/items[at0087]/value|value")
  private String probenentnahmestelleValue;

  @Path("/items[at0083]")
  private List<Cluster> zusatzlicheAngabenZurProbennahme;

  @Path("/items[at0007]/value|value")
  private String probenentnahmemethodeValue;

  @Path("/items[at0085]")
  private List<Cluster> behalterDetails;

  @Path("/items[at0096]")
  private List<Cluster> digitaleDarstellung;

  @Path("/items[at0034]/value|value")
  private TemporalAccessor zeitpunktDesProbeneingangsValue;

  @Path("/items[at0041]/value")
  @Choice
  private ProbeEignungZumTestenChoice eignungZumTesten;

  @Path("/items[at0045]/value|value")
  private String kommentarValue;

  @Path("/items[at0029]/value|defining_code")
  private ProbenartDefiningcode probenartDefiningcode;

  @Path("/items[at0001]/value")
  private DvIdentifier laborprobenidentifikator;

  @Path("/items[at0013]")
  private List<Cluster> anatomischeProbenentnahmestelle;

  @Path("/items[at0068]")
  private List<Cluster> angabenZurVerarbeitung;

  @Path("/items[at0087]/name|value")
  private String probenentnahmestelleValueName;

  @Path("/items[at0003]")
  private List<ProbeIdentifikatorDerUbergeordnetenProbeElement> identifikatorDerUbergeordnetenProbe;

  @Path("/items[at0070]/value")
  private DvIdentifier identifikatorDesProbennehmers;

  @Path("/items[at0027]")
  private List<Cluster> physischeEigenschaften;

  @Path("/items[at0008]")
  private List<ProbeProbenentahmebedingungElement> probenentahmebedingung;

  @Path("/items[at0015]/value")
  @Choice
  private ProbeZeitpunktDerProbenentnahmeChoice zeitpunktDerProbenentnahme;

  public void setAngabenZumProbennehmer(List<Cluster> angabenZumProbennehmer) {
    this.angabenZumProbennehmer = angabenZumProbennehmer;
  }

  public List<Cluster> getAngabenZumProbennehmer() {
    return this.angabenZumProbennehmer;
  }

  public void setAngabenZumTransport(List<Cluster> angabenZumTransport) {
    this.angabenZumTransport = angabenZumTransport;
  }

  public List<Cluster> getAngabenZumTransport() {
    return this.angabenZumTransport;
  }

  public void setExternerIdentifikator(DvIdentifier externerIdentifikator) {
    this.externerIdentifikator = externerIdentifikator;
  }

  public DvIdentifier getExternerIdentifikator() {
    return this.externerIdentifikator;
  }

  public void setProbenentnahmestelleValue(String probenentnahmestelleValue) {
    this.probenentnahmestelleValue = probenentnahmestelleValue;
  }

  public String getProbenentnahmestelleValue() {
    return this.probenentnahmestelleValue;
  }

  public void setZusatzlicheAngabenZurProbennahme(List<Cluster> zusatzlicheAngabenZurProbennahme) {
    this.zusatzlicheAngabenZurProbennahme = zusatzlicheAngabenZurProbennahme;
  }

  public List<Cluster> getZusatzlicheAngabenZurProbennahme() {
    return this.zusatzlicheAngabenZurProbennahme;
  }

  public void setProbenentnahmemethodeValue(String probenentnahmemethodeValue) {
    this.probenentnahmemethodeValue = probenentnahmemethodeValue;
  }

  public String getProbenentnahmemethodeValue() {
    return this.probenentnahmemethodeValue;
  }

  public void setBehalterDetails(List<Cluster> behalterDetails) {
    this.behalterDetails = behalterDetails;
  }

  public List<Cluster> getBehalterDetails() {
    return this.behalterDetails;
  }

  public void setDigitaleDarstellung(List<Cluster> digitaleDarstellung) {
    this.digitaleDarstellung = digitaleDarstellung;
  }

  public List<Cluster> getDigitaleDarstellung() {
    return this.digitaleDarstellung;
  }

  public void setZeitpunktDesProbeneingangsValue(TemporalAccessor zeitpunktDesProbeneingangsValue) {
    this.zeitpunktDesProbeneingangsValue = zeitpunktDesProbeneingangsValue;
  }

  public TemporalAccessor getZeitpunktDesProbeneingangsValue() {
    return this.zeitpunktDesProbeneingangsValue;
  }

  public void setEignungZumTesten(ProbeEignungZumTestenChoice eignungZumTesten) {
    this.eignungZumTesten = eignungZumTesten;
  }

  public ProbeEignungZumTestenChoice getEignungZumTesten() {
    return this.eignungZumTesten;
  }

  public void setKommentarValue(String kommentarValue) {
    this.kommentarValue = kommentarValue;
  }

  public String getKommentarValue() {
    return this.kommentarValue;
  }

  public void setProbenartDefiningcode(ProbenartDefiningcode probenartDefiningcode) {
    this.probenartDefiningcode = probenartDefiningcode;
  }

  public ProbenartDefiningcode getProbenartDefiningcode() {
    return this.probenartDefiningcode;
  }

  public void setLaborprobenidentifikator(DvIdentifier laborprobenidentifikator) {
    this.laborprobenidentifikator = laborprobenidentifikator;
  }

  public DvIdentifier getLaborprobenidentifikator() {
    return this.laborprobenidentifikator;
  }

  public void setAnatomischeProbenentnahmestelle(List<Cluster> anatomischeProbenentnahmestelle) {
    this.anatomischeProbenentnahmestelle = anatomischeProbenentnahmestelle;
  }

  public List<Cluster> getAnatomischeProbenentnahmestelle() {
    return this.anatomischeProbenentnahmestelle;
  }

  public void setAngabenZurVerarbeitung(List<Cluster> angabenZurVerarbeitung) {
    this.angabenZurVerarbeitung = angabenZurVerarbeitung;
  }

  public List<Cluster> getAngabenZurVerarbeitung() {
    return this.angabenZurVerarbeitung;
  }

  public void setProbenentnahmestelleValueName(String probenentnahmestelleValueName) {
    this.probenentnahmestelleValueName = probenentnahmestelleValueName;
  }

  public String getProbenentnahmestelleValueName() {
    return this.probenentnahmestelleValueName;
  }

  public void setIdentifikatorDerUbergeordnetenProbe(
      List<ProbeIdentifikatorDerUbergeordnetenProbeElement> identifikatorDerUbergeordnetenProbe) {
    this.identifikatorDerUbergeordnetenProbe = identifikatorDerUbergeordnetenProbe;
  }

  public List<ProbeIdentifikatorDerUbergeordnetenProbeElement>
      getIdentifikatorDerUbergeordnetenProbe() {
    return this.identifikatorDerUbergeordnetenProbe;
  }

  public void setIdentifikatorDesProbennehmers(DvIdentifier identifikatorDesProbennehmers) {
    this.identifikatorDesProbennehmers = identifikatorDesProbennehmers;
  }

  public DvIdentifier getIdentifikatorDesProbennehmers() {
    return this.identifikatorDesProbennehmers;
  }

  public void setPhysischeEigenschaften(List<Cluster> physischeEigenschaften) {
    this.physischeEigenschaften = physischeEigenschaften;
  }

  public List<Cluster> getPhysischeEigenschaften() {
    return this.physischeEigenschaften;
  }

  public void setProbenentahmebedingung(
      List<ProbeProbenentahmebedingungElement> probenentahmebedingung) {
    this.probenentahmebedingung = probenentahmebedingung;
  }

  public List<ProbeProbenentahmebedingungElement> getProbenentahmebedingung() {
    return this.probenentahmebedingung;
  }

  public void setZeitpunktDerProbenentnahme(
      ProbeZeitpunktDerProbenentnahmeChoice zeitpunktDerProbenentnahme) {
    this.zeitpunktDerProbenentnahme = zeitpunktDerProbenentnahme;
  }

  public ProbeZeitpunktDerProbenentnahmeChoice getZeitpunktDerProbenentnahme() {
    return this.zeitpunktDerProbenentnahme;
  }
}
