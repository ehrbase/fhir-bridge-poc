package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.encapsulated.DvMultimedia;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.RMEntity;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.718453800+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
@OptionFor("DV_MULTIMEDIA")
public class ProAnalytQuantitativesErgebnisDvMultimedia implements RMEntity, ProAnalytQuantitativesErgebnisChoice {
  /**
   * Path: Virologischer Befund/Befund/Jedes Ereignis/Labortest-Panel/Pro Analyt/Quantitatives Ergebnis/Quantitatives Ergebnis
   * Description: (Mess-)Wert des Analyt-Resultats.
   */
  @Path("")
  private List<DvMultimedia> quantitativesErgebnis;

  public void setQuantitativesErgebnis(List<DvMultimedia> quantitativesErgebnis) {
     this.quantitativesErgebnis = quantitativesErgebnis;
  }

  public List<DvMultimedia> getQuantitativesErgebnis() {
     return this.quantitativesErgebnis ;
  }
}
