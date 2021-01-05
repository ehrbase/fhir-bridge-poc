package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_DATE_TIME")
public class ProbeZeitpunktDerProbenentnahmeDvdatetime
    implements ProbeZeitpunktDerProbenentnahmeChoice {
  @Path("|value")
  private TemporalAccessor zeitpunktDerProbenentnahmeValue;

  public void setZeitpunktDerProbenentnahmeValue(TemporalAccessor zeitpunktDerProbenentnahmeValue) {
    this.zeitpunktDerProbenentnahmeValue = zeitpunktDerProbenentnahmeValue;
  }

  public TemporalAccessor getZeitpunktDerProbenentnahmeValue() {
    return this.zeitpunktDerProbenentnahmeValue;
  }
}
