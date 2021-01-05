package org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum StatusDefiningcode implements EnumValueSet {
  FINAL("final", "*", "local", "at0012"),

  GEANDERT("geändert", "*", "local", "at0013"),

  REGISTRIERT("registriert", "*", "local", "at0010"),

  VORLAUFIG("vorläufig", "*", "local", "at0011");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  StatusDefiningcode(String value, String description, String terminologyId, String code) {
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
