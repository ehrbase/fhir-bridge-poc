package org.ehrbase.fhirbridge.ehr.opt.korpergrossecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.height.v2")
public class GrosseLangeObservation {
  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|magnitude")
  private Double grosseLangeMagnitude;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|units")
  private String grosseLangeUnits;

  @Path("/language")
  private Language language;

  @Path("/protocol[at0007]/items[at0011]")
  private Cluster gerat;

  @Path("/protocol[at0007]/items[at0022]")
  private List<Cluster> erweiterung;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  public void setGrosseLangeMagnitude(Double grosseLangeMagnitude) {
    this.grosseLangeMagnitude = grosseLangeMagnitude;
  }

  public Double getGrosseLangeMagnitude() {
    return this.grosseLangeMagnitude;
  }

  public void setGrosseLangeUnits(String grosseLangeUnits) {
    this.grosseLangeUnits = grosseLangeUnits;
  }

  public String getGrosseLangeUnits() {
    return this.grosseLangeUnits;
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

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
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
}
