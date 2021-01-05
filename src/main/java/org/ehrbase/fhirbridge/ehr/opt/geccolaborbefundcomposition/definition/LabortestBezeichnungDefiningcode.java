package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum LabortestBezeichnungDefiningcode implements EnumValueSet {
  COAGULATION_STUDIES_SET("Coagulation studies (set)", null, "LOINC", "18720-3"),

  SEROLOGY_AND_BLOOD_BANK_STUDIES_SET(
      "Serology and blood bank studies (set)", null, "LOINC", "56874-1"),

  MICROBIOLOGY_STUDIES_SET("Microbiology studies (set)", null, "LOINC", "18725-2"),

  CHEMISTRY_STUDIES_SET("Chemistry studies (set)", null, "LOINC", "18719-5"),

  BLOOD_GAS_STUDIES_SET("Blood gas studies (set)", null, "LOINC", "18767-4"),

  CARDIAC_BIOMARKERS_SET("Cardiac biomarkers (set)", null, "LOINC", "56846-9"),

  LABORATORY_STUDIES_SET("Laboratory studies (set)", null, "LOINC", "26436-6"),

  HEMATOLOGY_STUDIES_SET("Hematology studies (set)", null, "LOINC", "18723-7"),

  URINALYSIS_STUDIES_SET("Urinalysis studies (set)", null, "LOINC", "18729-4"),

  CALCULATED_AND_DERIVED_VALUES_SET(
      "Calculated and derived values (set)", null, "LOINC", "56847-7"),

  TOXICOLOGY_STUDIES_SET("Toxicology studies (set)", null, "LOINC", "18728-6");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  LabortestBezeichnungDefiningcode(
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
