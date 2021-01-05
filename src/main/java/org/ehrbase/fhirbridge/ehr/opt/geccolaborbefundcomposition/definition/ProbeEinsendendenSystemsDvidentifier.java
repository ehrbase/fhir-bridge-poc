package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datavalues.DvIdentifier;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_IDENTIFIER")
public class ProbeEinsendendenSystemsDvidentifier implements ProbeEinsendendenSystemsChoice {
  @Path("")
  private DvIdentifier einsendendenSystems;

  public void setEinsendendenSystems(DvIdentifier einsendendenSystems) {
    this.einsendendenSystems = einsendendenSystems;
  }

  public DvIdentifier getEinsendendenSystems() {
    return this.einsendendenSystems;
  }
}
