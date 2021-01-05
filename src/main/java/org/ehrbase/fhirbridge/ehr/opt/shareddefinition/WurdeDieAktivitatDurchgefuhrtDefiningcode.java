package org.ehrbase.fhirbridge.ehr.opt.shareddefinition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum WurdeDieAktivitatDurchgefuhrtDefiningcode implements EnumValueSet {
  N74964007("74964007", "74964007", "SNOMED Clinical Terms", "74964007"),

  N373066001("373066001", "373066001", "SNOMED Clinical Terms", "373066001"),

  N261665006("261665006", "261665006", "SNOMED Clinical Terms", "261665006"),

  N385432009("385432009", "385432009", "SNOMED Clinical Terms", "385432009"),

  N373067005("373067005", "373067005", "SNOMED Clinical Terms", "373067005");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  WurdeDieAktivitatDurchgefuhrtDefiningcode(
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
