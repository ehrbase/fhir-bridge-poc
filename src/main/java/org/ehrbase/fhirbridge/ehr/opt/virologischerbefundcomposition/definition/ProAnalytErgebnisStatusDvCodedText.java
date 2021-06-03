package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.729695700+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
@OptionFor("DV_CODED_TEXT")
public class ProAnalytErgebnisStatusDvCodedText implements RMEntity, ProAnalytErgebnisStatusChoice {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Ergebnis-Status/Ergebnis-Status
   * Description: Status des Analyseergebnisses.
   */
  @Path("|defining_code")
  private ErgebnisStatusDefiningCode ergebnisStatusDefiningCode;

  public void setErgebnisStatusDefiningCode(ErgebnisStatusDefiningCode ergebnisStatusDefiningCode) {
     this.ergebnisStatusDefiningCode = ergebnisStatusDefiningCode;
  }

  public ErgebnisStatusDefiningCode getErgebnisStatusDefiningCode() {
     return this.ergebnisStatusDefiningCode ;
  }
}
