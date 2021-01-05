package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_TEXT")
public class ProbeEignungZumTestenDvtext implements ProbeEignungZumTestenChoice {
  @Path("|value")
  private String eignungZumTestenValue;

  public void setEignungZumTestenValue(String eignungZumTestenValue) {
    this.eignungZumTestenValue = eignungZumTestenValue;
  }

  public String getEignungZumTestenValue() {
    return this.eignungZumTestenValue;
  }
}
