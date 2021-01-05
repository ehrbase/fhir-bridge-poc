package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.quantity.DvInterval;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_INTERVAL")
public class ProbeZeitpunktDerProbenentnahmeDvinterval
    implements ProbeZeitpunktDerProbenentnahmeChoice {
  @Path("")
  private DvInterval zeitpunktDerProbenentnahme;

  public void setZeitpunktDerProbenentnahme(DvInterval zeitpunktDerProbenentnahme) {
    this.zeitpunktDerProbenentnahme = zeitpunktDerProbenentnahme;
  }

  public DvInterval getZeitpunktDerProbenentnahme() {
    return this.zeitpunktDerProbenentnahme;
  }
}
