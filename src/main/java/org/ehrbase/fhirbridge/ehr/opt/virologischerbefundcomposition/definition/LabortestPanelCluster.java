package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;

@Entity
@Archetype("openEHR-EHR-CLUSTER.laboratory_test_panel.v0")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.702450300+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class LabortestPanelCluster implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt
   * Description: Ergebnis einer Laboranalyse für einen bestimmten Analytwert.
   * Comment: Beispiele: "Natrium", "Leukozytenzahl", "T3". Üblicherweise über eine externe Terminologie codiert.
   */
  @Path("/items[openEHR-EHR-CLUSTER.laboratory_test_analyte.v1 and name/value='Pro Analyt']")
  private List<ProAnalytCluster> proAnalyt;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setProAnalyt(List<ProAnalytCluster> proAnalyt) {
     this.proAnalyt = proAnalyt;
  }

  public List<ProAnalytCluster> getProAnalyt() {
     return this.proAnalyt ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
