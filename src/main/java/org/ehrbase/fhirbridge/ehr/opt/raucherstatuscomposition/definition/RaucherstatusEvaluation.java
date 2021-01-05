package org.ehrbase.fhirbridge.ehr.opt.raucherstatuscomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-EVALUATION.tobacco_smoking_summary.v1")
public class RaucherstatusEvaluation {
  @Path("/protocol[at0021]/items[at0073]")
  private List<Cluster> erweiterung;

  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/items[at0043]/value|defining_code")
  private RauchverhaltenDefiningcode rauchverhaltenDefiningcode;

  @Path("/data[at0001]/items[at0086]")
  private List<Cluster> allgemeineDetails;

  @Path("/language")
  private Language language;

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

  public void setRauchverhaltenDefiningcode(RauchverhaltenDefiningcode rauchverhaltenDefiningcode) {
    this.rauchverhaltenDefiningcode = rauchverhaltenDefiningcode;
  }

  public RauchverhaltenDefiningcode getRauchverhaltenDefiningcode() {
    return this.rauchverhaltenDefiningcode;
  }

  public void setAllgemeineDetails(List<Cluster> allgemeineDetails) {
    this.allgemeineDetails = allgemeineDetails;
  }

  public List<Cluster> getAllgemeineDetails() {
    return this.allgemeineDetails;
  }

  public void setLanguage(Language language) {
    this.language = language;
  }

  public Language getLanguage() {
    return this.language;
  }
}
