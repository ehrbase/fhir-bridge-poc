package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.symptom_sign.v0")
public class VorliegendesSymptomObservation {
  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0021]/value|defining_code")
  private SchweregradDefiningcode schweregradDefiningcode;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0147]")
  private List<Cluster> spezifischeAnatomischeLokalisation;

  @Path("/language")
  private Language language;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0146]")
  private List<Cluster> vorangegangeneEpisoden;

  @Path("/data[at0190]/origin|value")
  private TemporalAccessor originValue;

  @Path("/protocol[at0193]/items[at0194]")
  private List<Cluster> extensionEn;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0001]/value|defining_code")
  private ProblemDiagnoseDefiningcode nameDesSymptomsKrankheitsanzeichensDefiningcode;

  @Path("/data[at0190]/events[at0191]/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0153]")
  private List<Cluster> spezifischeDetails;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0151]")
  private List<VorliegendesSymptomAnatomischeLokalisationElement> anatomischeLokalisation;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0063]")
  private List<Cluster> krankheitsanzeichen;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0152]/value|value")
  private TemporalAccessor beginnDerEpisodeValue;

  @Path("/data[at0190]/events[at0191]/data[at0192]/items[at0161]/value|value")
  private TemporalAccessor datumUhrzeitDesRuckgangsValue;

  public SchweregradDefiningcode getSchweregradDefiningcode() {
    return this.schweregradDefiningcode;
  }

  public void setSchweregradDefiningcode(SchweregradDefiningcode schweregradDefiningcode) {
    this.schweregradDefiningcode = schweregradDefiningcode;
  }

  public List<Cluster> getSpezifischeAnatomischeLokalisation() {
    return this.spezifischeAnatomischeLokalisation;
  }

  public void setSpezifischeAnatomischeLokalisation(
      List<Cluster> spezifischeAnatomischeLokalisation) {
    this.spezifischeAnatomischeLokalisation = spezifischeAnatomischeLokalisation;
  }

  public Language getLanguage() {
    return this.language;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public List<Cluster> getVorangegangeneEpisoden() {
    return this.vorangegangeneEpisoden;
  }

  public void setVorangegangeneEpisoden(List<Cluster> vorangegangeneEpisoden) {
    this.vorangegangeneEpisoden = vorangegangeneEpisoden;
  }

  public TemporalAccessor getOriginValue() {
    return this.originValue;
  }

  public void setOriginValue(TemporalAccessor originValue) {
    this.originValue = originValue;
  }

  public List<Cluster> getExtensionEn() {
    return this.extensionEn;
  }

  public void setExtensionEn(List<Cluster> extensionEn) {
    this.extensionEn = extensionEn;
  }

  public ProblemDiagnoseDefiningcode getNameDesSymptomsKrankheitsanzeichensDefiningcode() {
    return this.nameDesSymptomsKrankheitsanzeichensDefiningcode;
  }

  public void setNameDesSymptomsKrankheitsanzeichensDefiningcode(
      ProblemDiagnoseDefiningcode nameDesSymptomsKrankheitsanzeichensDefiningcode) {
    this.nameDesSymptomsKrankheitsanzeichensDefiningcode =
        nameDesSymptomsKrankheitsanzeichensDefiningcode;
  }

  public TemporalAccessor getTimeValue() {
    return this.timeValue;
  }

  public void setTimeValue(TemporalAccessor timeValue) {
    this.timeValue = timeValue;
  }

  public List<Cluster> getSpezifischeDetails() {
    return this.spezifischeDetails;
  }

  public void setSpezifischeDetails(List<Cluster> spezifischeDetails) {
    this.spezifischeDetails = spezifischeDetails;
  }

  public List<VorliegendesSymptomAnatomischeLokalisationElement> getAnatomischeLokalisation() {
    return this.anatomischeLokalisation;
  }

  public void setAnatomischeLokalisation(
      List<VorliegendesSymptomAnatomischeLokalisationElement> anatomischeLokalisation) {
    this.anatomischeLokalisation = anatomischeLokalisation;
  }

  public List<Cluster> getKrankheitsanzeichen() {
    return this.krankheitsanzeichen;
  }

  public void setKrankheitsanzeichen(List<Cluster> krankheitsanzeichen) {
    this.krankheitsanzeichen = krankheitsanzeichen;
  }

  public PartyProxy getSubject() {
    return this.subject;
  }

  public void setSubject(PartyProxy subject) {
    this.subject = subject;
  }

  public TemporalAccessor getBeginnDerEpisodeValue() {
    return this.beginnDerEpisodeValue;
  }

  public void setBeginnDerEpisodeValue(TemporalAccessor beginnDerEpisodeValue) {
    this.beginnDerEpisodeValue = beginnDerEpisodeValue;
  }

  public TemporalAccessor getDatumUhrzeitDesRuckgangsValue() {
    return this.datumUhrzeitDesRuckgangsValue;
  }

  public void setDatumUhrzeitDesRuckgangsValue(TemporalAccessor datumUhrzeitDesRuckgangsValue) {
    this.datumUhrzeitDesRuckgangsValue = datumUhrzeitDesRuckgangsValue;
  }
}
