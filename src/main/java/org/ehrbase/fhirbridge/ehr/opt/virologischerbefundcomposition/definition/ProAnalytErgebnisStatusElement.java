package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.729695700+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class ProAnalytErgebnisStatusElement implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Ergebnis-Status/null_flavour
   */
  @Path("/null_flavour|defining_code")
  private NullFlavour value;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Ergebnis-Status
   * Description: Status des Analyseergebnisses.
   */
  @Path("/value")
  @Choice
  private List<ProAnalytErgebnisStatusChoice> value2;

  public void setValue(NullFlavour value) {
     this.value = value;
  }

  public NullFlavour getValue() {
     return this.value ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setValue2(List<ProAnalytErgebnisStatusChoice> value2) {
     this.value2 = value2;
  }

  public List<ProAnalytErgebnisStatusChoice> getValue2() {
     return this.value2 ;
  }
}
