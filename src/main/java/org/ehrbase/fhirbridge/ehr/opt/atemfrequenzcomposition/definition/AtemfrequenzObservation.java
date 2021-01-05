package org.ehrbase.fhirbridge.ehr.opt.atemfrequenzcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.respiration.v2")
public class AtemfrequenzObservation {
  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|magnitude")
  private Double messwertMagnitude;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|units")
  private String messwertUnits;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0001]/events[at0002]/state[at0022]/items[at0037]")
  private Cluster anwendung;

  @Path("/protocol[at0057]/items[at0058]")
  private List<Cluster> erweiterung;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0001]/events[at0002]/state[at0022]/items[at0055]")
  private Cluster inspirierterSauerstoff;

  public void setMesswertMagnitude(Double messwertMagnitude) {
    this.messwertMagnitude = messwertMagnitude;
  }

  public Double getMesswertMagnitude() {
    return this.messwertMagnitude;
  }

  public void setMesswertUnits(String messwertUnits) {
    this.messwertUnits = messwertUnits;
  }

  public String getMesswertUnits() {
    return this.messwertUnits;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setAnwendung(Cluster anwendung) {
    this.anwendung = anwendung;
  }

  public Cluster getAnwendung() {
    return this.anwendung;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
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

  public void setInspirierterSauerstoff(Cluster inspirierterSauerstoff) {
    this.inspirierterSauerstoff = inspirierterSauerstoff;
  }

  public Cluster getInspirierterSauerstoff() {
    return this.inspirierterSauerstoff;
  }
}
