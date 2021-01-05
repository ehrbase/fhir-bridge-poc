package org.ehrbase.fhirbridge.ehr.opt.sofacomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.quantity.DvOrdinal;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.sofa_score.v0")
public class SOFAScoreObservation {
  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value")
  private DvOrdinal atemtatigkeit;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0005]/value")
  private DvOrdinal zentralesNervensystem;

  @Path("/protocol[at0014]/items[at0015]")
  private List<Cluster> erweiterung;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0006]/value")
  private DvOrdinal herzKreislaufSystem;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0007]/value")
  private DvOrdinal leberfunktion;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0008]/value")
  private DvOrdinal blutgerinnung;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0009]/value")
  private DvOrdinal nierenfunktion;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0010]/value|magnitude")
  private Long sofaScoreMagnitude;

  public void setAtemtatigkeit(DvOrdinal atemtatigkeit) {
    this.atemtatigkeit = atemtatigkeit;
  }

  public DvOrdinal getAtemtatigkeit() {
    return this.atemtatigkeit;
  }

  public void setZentralesNervensystem(DvOrdinal zentralesNervensystem) {
    this.zentralesNervensystem = zentralesNervensystem;
  }

  public DvOrdinal getZentralesNervensystem() {
    return this.zentralesNervensystem;
  }

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

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setHerzKreislaufSystem(DvOrdinal herzKreislaufSystem) {
    this.herzKreislaufSystem = herzKreislaufSystem;
  }

  public DvOrdinal getHerzKreislaufSystem() {
    return this.herzKreislaufSystem;
  }

  public void setLeberfunktion(DvOrdinal leberfunktion) {
    this.leberfunktion = leberfunktion;
  }

  public DvOrdinal getLeberfunktion() {
    return this.leberfunktion;
  }

  public void setBlutgerinnung(DvOrdinal blutgerinnung) {
    this.blutgerinnung = blutgerinnung;
  }

  public DvOrdinal getBlutgerinnung() {
    return this.blutgerinnung;
  }

  public void setNierenfunktion(DvOrdinal nierenfunktion) {
    this.nierenfunktion = nierenfunktion;
  }

  public DvOrdinal getNierenfunktion() {
    return this.nierenfunktion;
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

  public void setSofaScoreMagnitude(Long sofaScoreMagnitude) {
    this.sofaScoreMagnitude = sofaScoreMagnitude;
  }

  public Long getSofaScoreMagnitude() {
    return this.sofaScoreMagnitude;
  }
}
