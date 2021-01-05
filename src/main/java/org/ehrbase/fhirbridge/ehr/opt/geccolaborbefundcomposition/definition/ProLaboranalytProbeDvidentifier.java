package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.DvIdentifier;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_IDENTIFIER")
public class ProLaboranalytProbeDvidentifier implements ProLaboranalytProbeChoice {
  @Path("")
  private DvIdentifier probe;

  public void setProbe(DvIdentifier probe) {
    this.probe = probe;
  }

  public DvIdentifier getProbe() {
    return this.probe;
  }
}
