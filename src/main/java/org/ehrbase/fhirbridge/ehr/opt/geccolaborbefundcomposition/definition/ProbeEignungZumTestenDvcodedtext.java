package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_CODED_TEXT")
public class ProbeEignungZumTestenDvcodedtext implements ProbeEignungZumTestenChoice {
  @Path("|defining_code")
  private EignungZumTestenDefiningcode eignungZumTestenDefiningcode;

  public void setEignungZumTestenDefiningcode(
      EignungZumTestenDefiningcode eignungZumTestenDefiningcode) {
    this.eignungZumTestenDefiningcode = eignungZumTestenDefiningcode;
  }

  public EignungZumTestenDefiningcode getEignungZumTestenDefiningcode() {
    return this.eignungZumTestenDefiningcode;
  }
}
