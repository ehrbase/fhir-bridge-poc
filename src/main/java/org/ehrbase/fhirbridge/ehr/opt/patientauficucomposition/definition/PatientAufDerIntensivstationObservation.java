package org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.WurdeDieAktivitatDurchgefuhrtDefiningcode;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.management_screening.v0")
public class PatientAufDerIntensivstationObservation {
  @Path("/language")
  private Language language;

  @Path("/protocol[at0007]/items[at0021]")
  private List<Cluster> erweiterung;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0004]/value|value")
  private String nameDerAktivitatValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/value|defining_code")
  private WurdeDieAktivitatDurchgefuhrtDefiningcode wurdeDieAktivitatDurchgefuhrtDefiningcode;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0036]")
  private List<Cluster> detaillierteAngabenZurAktivitat;

  @Path("/data[at0001]/events[at0002]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/name|value")
  private String wurdeDieAktivitatDurchgefuhrtValue;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setErweiterung(List<Cluster> erweiterung) {
    this.erweiterung = erweiterung;
  }

  public List<Cluster> getErweiterung() {
    return this.erweiterung;
  }

  public void setNameDerAktivitatValue(String nameDerAktivitatValue) {
    this.nameDerAktivitatValue = nameDerAktivitatValue;
  }

  public String getNameDerAktivitatValue() {
    return this.nameDerAktivitatValue;
  }

  public void setWurdeDieAktivitatDurchgefuhrtDefiningcode(
      WurdeDieAktivitatDurchgefuhrtDefiningcode wurdeDieAktivitatDurchgefuhrtDefiningcode) {
    this.wurdeDieAktivitatDurchgefuhrtDefiningcode = wurdeDieAktivitatDurchgefuhrtDefiningcode;
  }

  public WurdeDieAktivitatDurchgefuhrtDefiningcode getWurdeDieAktivitatDurchgefuhrtDefiningcode() {
    return this.wurdeDieAktivitatDurchgefuhrtDefiningcode;
  }

  public void setDetaillierteAngabenZurAktivitat(List<Cluster> detaillierteAngabenZurAktivitat) {
    this.detaillierteAngabenZurAktivitat = detaillierteAngabenZurAktivitat;
  }

  public List<Cluster> getDetaillierteAngabenZurAktivitat() {
    return this.detaillierteAngabenZurAktivitat;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setWurdeDieAktivitatDurchgefuhrtValue(String wurdeDieAktivitatDurchgefuhrtValue) {
    this.wurdeDieAktivitatDurchgefuhrtValue = wurdeDieAktivitatDurchgefuhrtValue;
  }

  public String getWurdeDieAktivitatDurchgefuhrtValue() {
    return this.wurdeDieAktivitatDurchgefuhrtValue;
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
