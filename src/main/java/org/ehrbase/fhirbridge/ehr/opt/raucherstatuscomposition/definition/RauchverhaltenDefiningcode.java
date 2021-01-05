package org.ehrbase.fhirbridge.ehr.opt.raucherstatuscomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum RauchverhaltenDefiningcode implements EnumValueSet {
  LA189763("LA18976-3", "LA18976-3", "LOINC", "LA18976-3"),

  LA189789("LA18978-9", "LA18978-9", "LOINC", "LA18978-9"),

  LA159204("LA15920-4", "LA15920-4", "LOINC", "LA15920-4"),

  LA189805("LA18980-5", "LA18980-5", "LOINC", "LA18980-5");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  RauchverhaltenDefiningcode(String value, String description, String terminologyId, String code) {
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
