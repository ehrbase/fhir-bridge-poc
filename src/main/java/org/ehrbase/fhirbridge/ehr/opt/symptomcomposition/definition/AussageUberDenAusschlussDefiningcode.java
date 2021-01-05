package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum AussageUberDenAusschlussDefiningcode implements EnumValueSet {
  N410594000("410594000", "410594000", "SNOMED Clinical Terms", "410594000");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  AussageUberDenAusschlussDefiningcode(
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
