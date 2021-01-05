package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

@Entity
@Archetype("openEHR-EHR-EVALUATION.absence.v2")
public class UnbekanntesSymptomEvaluation {
  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/items[at0002]/value|defining_code")
  private ProblemDiagnoseDefiningcode unbekanntesSymptomDefiningcode;

  @Path("/protocol[at0003]/items[at0006]")
  private List<Cluster> erweiterung;

  @Path("/language")
  private Language language;

  @Path("/data[at0001]/items[at0005]")
  private List<UnbekanntesSymptomAussageUberDieFehlendeInformationElement>
      aussageUberDieFehlendeInformation;

  public void setSubject(PartyProxy subject) {
    this.subject = subject;
  }

  public PartyProxy getSubject() {
    return this.subject;
  }

  public void setUnbekanntesSymptomDefiningcode(
      ProblemDiagnoseDefiningcode unbekanntesSymptomDefiningcode) {
    this.unbekanntesSymptomDefiningcode = unbekanntesSymptomDefiningcode;
  }

  public ProblemDiagnoseDefiningcode getUnbekanntesSymptomDefiningcode() {
    return this.unbekanntesSymptomDefiningcode;
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

  public void setAussageUberDieFehlendeInformation(
      List<UnbekanntesSymptomAussageUberDieFehlendeInformationElement>
          aussageUberDieFehlendeInformation) {
    this.aussageUberDieFehlendeInformation = aussageUberDieFehlendeInformation;
  }

  public List<UnbekanntesSymptomAussageUberDieFehlendeInformationElement>
      getAussageUberDieFehlendeInformation() {
    return this.aussageUberDieFehlendeInformation;
  }
}
