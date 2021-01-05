package org.ehrbase.fhirbridge.ehr.opt.blutdruckcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.blood_pressure.v2")
public class BlutdruckObservation {
  @Path("/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value|magnitude")
  private Double systolischMagnitude;

  @Path("/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value|units")
  private String systolischUnits;

  @Path("/data[at0001]/events[at0006]/state[at0007]/items[at1030]")
  private Cluster anstrengung;

  @Path("/protocol[at0011]/items[at1057]")
  private List<Cluster> strukturierteStelleDerMessung;

  @Path("/protocol[at0011]/items[at1025]")
  private Cluster gerat;

  @Path("/protocol[at0011]/items[at1058]")
  private List<Cluster> erweiterung;

  @Path("/data[at0001]/events[at0006]/data[at0003]/items[at0005]/value|magnitude")
  private Double diastolischMagnitude;

  @Path("/data[at0001]/events[at0006]/data[at0003]/items[at0005]/value|units")
  private String diastolischUnits;

  @Path("/language")
  private Language language;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0001]/events[at0006]/time|value")
  private TemporalAccessor timeValue;

  public void setSystolischMagnitude(Double systolischMagnitude) {
    this.systolischMagnitude = systolischMagnitude;
  }

  public Double getSystolischMagnitude() {
    return this.systolischMagnitude;
  }

  public void setSystolischUnits(String systolischUnits) {
    this.systolischUnits = systolischUnits;
  }

  public String getSystolischUnits() {
    return this.systolischUnits;
  }

  public void setAnstrengung(Cluster anstrengung) {
    this.anstrengung = anstrengung;
  }

  public Cluster getAnstrengung() {
    return this.anstrengung;
  }

  public void setStrukturierteStelleDerMessung(List<Cluster> strukturierteStelleDerMessung) {
    this.strukturierteStelleDerMessung = strukturierteStelleDerMessung;
  }

  public List<Cluster> getStrukturierteStelleDerMessung() {
    return this.strukturierteStelleDerMessung;
  }

  public void setGerat(Cluster gerat) {
    this.gerat = gerat;
  }

  public Cluster getGerat() {
    return this.gerat;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
  }

  public void setDiastolischMagnitude(Double diastolischMagnitude) {
    this.diastolischMagnitude = diastolischMagnitude;
  }

  public Double getDiastolischMagnitude() {
    return this.diastolischMagnitude;
  }

  public void setDiastolischUnits(String diastolischUnits) {
    this.diastolischUnits = diastolischUnits;
  }

  public String getDiastolischUnits() {
    return this.diastolischUnits;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
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

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }
}
