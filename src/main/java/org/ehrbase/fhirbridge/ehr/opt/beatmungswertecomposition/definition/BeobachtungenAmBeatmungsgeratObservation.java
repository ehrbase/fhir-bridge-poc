package org.ehrbase.fhirbridge.ehr.opt.beatmungswertecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.ventilator_vital_signs.v0")
public class BeobachtungenAmBeatmungsgeratObservation {
  @Path("/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.inspired_oxygen.v1]")
  private EingeatmeterSauerstoffCluster eingeatmeterSauerstoff;

  @Path("/data[at0001]/events[at0002]/state[at0010]/items[at0011]")
  private Cluster einstellungenDesBeatmungsgerates;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/protocol[at0012]/items[at0014]")
  private Cluster gerat;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  public void setEingeatmeterSauerstoff(EingeatmeterSauerstoffCluster eingeatmeterSauerstoff) {
    this.eingeatmeterSauerstoff = eingeatmeterSauerstoff;
  }

  public EingeatmeterSauerstoffCluster getEingeatmeterSauerstoff() {
    return this.eingeatmeterSauerstoff;
  }

  public void setEinstellungenDesBeatmungsgerates(Cluster einstellungenDesBeatmungsgerates) {
    this.einstellungenDesBeatmungsgerates = einstellungenDesBeatmungsgerates;
  }

  public Cluster getEinstellungenDesBeatmungsgerates() {
    return this.einstellungenDesBeatmungsgerates;
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

  public void setGerat(Cluster gerat) {
    this.gerat = gerat;
  }

  public Cluster getGerat() {
    return this.gerat;
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
