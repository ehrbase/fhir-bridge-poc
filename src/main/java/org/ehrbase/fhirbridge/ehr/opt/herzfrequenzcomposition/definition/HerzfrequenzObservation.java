package org.ehrbase.fhirbridge.ehr.opt.herzfrequenzcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.pulse.v2")
public class HerzfrequenzObservation {
  @Path("/protocol[at0010]/items[at1056]")
  private List<Cluster> erweiterung;

  @Path("/language")
  private Language language;

  @Path("/protocol[at0010]/items[at1013]")
  private Cluster gerat;

  @Path("/data[at0002]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0002]/events[at0003]/state[at0012]/items[at1017]")
  private List<Cluster> anstrengung;

  @Path("/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|magnitude")
  private Double frequenzMagnitude;

  @Path("/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|units")
  private String frequenzUnits;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0002]/events[at0003]/time|value")
  private TemporalAccessor timeValue;

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setGerat(Cluster gerat) {
    this.gerat = gerat;
  }

  public Cluster getGerat() {
    return this.gerat;
  }

  public void setOriginValue(TemporalAccessor originValue) {
    this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
    return this.originValue;
  }

  public void setAnstrengung(List<Cluster> anstrengung) {
    this.anstrengung = anstrengung;
  }

  public List<Cluster> getAnstrengung() {
    return this.anstrengung;
  }

  public void setFrequenzMagnitude(Double frequenzMagnitude) {
    this.frequenzMagnitude = frequenzMagnitude;
  }

  public Double getFrequenzMagnitude() {
    return this.frequenzMagnitude;
  }

  public void setFrequenzUnits(String frequenzUnits) {
    this.frequenzUnits = frequenzUnits;
  }

  public String getFrequenzUnits() {
    return this.frequenzUnits;
  }

  public void setSubject(PartyProxy subject) {
    this.subject = subject;
  }

  public PartyProxy getSubject() {
    return this.subject;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }
}
