package org.ehrbase.fhirbridge.ehr.opt.shareddefinition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum MathFunctionDefiningcode implements EnumValueSet {
  ACTUAL("actual", "actual", "openehr", "640"),

  INCREASE("increase", "increase", "openehr", "522"),

  MEDIAN("median", "median", "openehr", "268"),

  DECREASE("decrease", "decrease", "openehr", "521"),

  MAXIMUM("maximum", "maximum", "openehr", "144"),

  MINIMUM("minimum", "minimum", "openehr", "145"),

  MODE("mode", "mode", "openehr", "267"),

  TOTAL("total", "total", "openehr", "148"),

  VARIATION("variation", "variation", "openehr", "149"),

  MEAN("mean", "mean", "openehr", "146"),

  CHANGE("change", "change", "openehr", "147");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  MathFunctionDefiningcode(String value, String description, String terminologyId, String code) {
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
