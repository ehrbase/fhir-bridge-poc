package org.ehrbase.fhirbridge.ehr.opt.klinischefrailtyskalacomposition.definition;

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
@Archetype("openEHR-EHR-OBSERVATION.clinical_frailty_scale.v1")
public class KlinischeFrailtySkalaCfsObservation {
  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value")
  private DvOrdinal beurteilung;

  @Path("/protocol[at0014]/items[at0015]")
  private List<Cluster> erweiterungen;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/language")
  private Language language;

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setBeurteilung(DvOrdinal beurteilung) {
    this.beurteilung = beurteilung;
  }

  public DvOrdinal getBeurteilung() {
    return this.beurteilung;
  }

  public void setErweiterungen(List<Cluster> erweiterungen) {
    this.erweiterungen = erweiterungen;
  }

  public List<Cluster> getErweiterungen() {
    return this.erweiterungen;
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

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }
}
