package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ReferenzbereichsHinweiseDefiningcode implements EnumValueSet {
  OFF_SCALE_LOW("Off scale low", null, "http", "<"),

  OFF_SCALE_HIG("Off scale hig", null, "http", ">"),

  CARRIER("Carrier", null, "http", "CAR"),

  WORSE("Worse", null, "http", "W"),

  SIGNIFICANT_CHANGE_UP("Significant change up", null, "http", "U"),

  BETTER("Better", null, "http", "B"),

  SIGNIFICANT_CHANGE_DOWN("Significant change down", null, "http", "D");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ReferenzbereichsHinweiseDefiningcode(
      String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
    return this.value;
  }

  public String getDescription() {
    return this.description;
  }

  public String getTerminologyId() {
    return this.terminologyId;
  }

  public String getCode() {
    return this.code;
  }
}
