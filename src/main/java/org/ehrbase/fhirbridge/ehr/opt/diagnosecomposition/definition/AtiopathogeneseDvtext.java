package org.ehrbase.fhirbridge.ehr.opt.diagnosecomposition.definition;

import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("DV_TEXT")
public class AtiopathogeneseDvtext
    implements AtiopathogeneseOrgEhrbaseEhrEncodeWrappersSnakecase6970140aChoice {
  @Path("|value")
  private String value;

  public void setValue(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }
}
