package org.ehrbase.fhirbridge.ehr.opt.diagnosecomposition.definition;

import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
public class AtiopathogeneseAtiologieDerKrankheitElement {
  @Path("/value")
  @Choice
  private AtiopathogeneseOrgEhrbaseEhrEncodeWrappersSnakecase6970140aChoice value;

  public void setValue(AtiopathogeneseOrgEhrbaseEhrEncodeWrappersSnakecase6970140aChoice value) {
    this.value = value;
  }

  public AtiopathogeneseOrgEhrbaseEhrEncodeWrappersSnakecase6970140aChoice getValue() {
    return this.value;
  }
}
