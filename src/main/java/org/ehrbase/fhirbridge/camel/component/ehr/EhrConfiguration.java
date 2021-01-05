package org.ehrbase.fhirbridge.camel.component.ehr;

import org.apache.camel.RuntimeCamelException;
import org.ehrbase.client.openehrclient.OpenEhrClient;

@SuppressWarnings("java:S2157")
public class EhrConfiguration implements Cloneable {

  private OpenEhrClient openEhrClient;

  public EhrConfiguration copy() {
    try {
      return (EhrConfiguration) clone();
    } catch (CloneNotSupportedException e) {
      throw new RuntimeCamelException(e);
    }
  }

  public OpenEhrClient getOpenEhrClient() {
    return openEhrClient;
  }

  public void setOpenEhrClient(OpenEhrClient openEhrClient) {
    this.openEhrClient = openEhrClient;
  }
}
