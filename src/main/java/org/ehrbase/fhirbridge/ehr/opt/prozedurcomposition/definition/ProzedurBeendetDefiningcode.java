package org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ProzedurBeendetDefiningcode implements EnumValueSet {
  PROZEDUR_BEENDET(
      "Prozedur beendet",
      "Die Prozedur wurde durchgeführt und alle damit verbundenen klinischen Aktivitäten wurden beendet.",
      "local",
      "at0043");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ProzedurBeendetDefiningcode(String value, String description, String terminologyId, String code) {
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
