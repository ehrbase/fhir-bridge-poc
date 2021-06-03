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
    date = "2021-05-18T14:46:29.717453900+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class ProAnalytQuantitativesErgebnisElement implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Tree/Labortest-Panel/Pro Analyt/Quantitatives Ergebnis/null_flavour
   */
  @Path("/null_flavour|defining_code")
  private NullFlavour value;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Quantitatives Ergebnis
   * Description: (Mess-)Wert des Analyt-Resultats.
   */
  @Path("/value")
  @Choice
  private List<ProAnalytQuantitativesErgebnisChoice> value2;

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

  public void setValue2(List<ProAnalytQuantitativesErgebnisChoice> value2) {
     this.value2 = value2;
  }

  public List<ProAnalytQuantitativesErgebnisChoice> getValue2() {
     return this.value2 ;
  }
}
