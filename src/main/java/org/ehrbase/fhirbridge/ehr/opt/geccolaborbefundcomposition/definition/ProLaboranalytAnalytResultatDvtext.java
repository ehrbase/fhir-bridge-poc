package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_TEXT")
public class ProLaboranalytAnalytResultatDvtext implements ProLaboranalytAnalytResultatChoice {
  @Path("|value")
  private String analytResultatValue;

  public void setAnalytResultatValue(String analytResultatValue) {
    this.analytResultatValue = analytResultatValue;
  }

  public String getAnalytResultatValue() {
    return this.analytResultatValue;
  }
}
