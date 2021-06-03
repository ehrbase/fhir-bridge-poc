package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import java.lang.Long;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.719449900+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
@OptionFor("DV_COUNT")
public class ProAnalytQuantitativesErgebnisDvCount implements RMEntity, ProAnalytQuantitativesErgebnisChoice {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Quantitatives Ergebnis/Quantitatives Ergebnis
   * Description: (Mess-)Wert des Analyt-Resultats.
   */
  @Path("|magnitude")
  private Long quantitativesErgebnisMagnitude;

  public void setQuantitativesErgebnisMagnitude(Long quantitativesErgebnisMagnitude) {
     this.quantitativesErgebnisMagnitude = quantitativesErgebnisMagnitude;
  }

  public Long getQuantitativesErgebnisMagnitude() {
     return this.quantitativesErgebnisMagnitude ;
  }
}
