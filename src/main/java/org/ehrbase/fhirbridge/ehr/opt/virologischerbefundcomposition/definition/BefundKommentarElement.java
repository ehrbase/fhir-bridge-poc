package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import java.lang.String;
import javax.annotation.processing.Generated;
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
public class BefundKommentarElement implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Kommentar
   * Description: Weitere Informationen über das Laborergebnis, welche bisher nicht in den anderen Feldern erfasst wurden.
   */
  @Path("/value|value")
  private String value;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Kommentar/null_flavour
   */
  @Path("/null_flavour|defining_code")
  private NullFlavour value2;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setValue(String value) {
     this.value = value;
  }

  public String getValue() {
     return this.value ;
  }

  public void setValue2(NullFlavour value2) {
     this.value2 = value2;
  }

  public NullFlavour getValue2() {
     return this.value2 ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
