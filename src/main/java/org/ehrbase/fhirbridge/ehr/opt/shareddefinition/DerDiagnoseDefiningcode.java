package org.ehrbase.fhirbridge.ehr.opt.shareddefinition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum DerDiagnoseDefiningcode implements EnumValueSet {
  B972(
      "Koronaviren als Ursache von Krankheiten, die in anderen Kapiteln klassifiziert sind",
      "B97.2",
      "ICD-10-GM-2020",
      "B97.2"),

  U071("COVID-19, Virus nachgewiesen", "U07.1", "ICD-10-GM-2020", "U07.1"),

  U072("COVID-19, Virus nicht nachgewiesen", "U07.2", "ICD-10-GM-2020", "U07.2"),

  B342(
      "Infektion durch Koronaviren nicht näher bezeichneter Lokalisation",
      "B34.2",
      "ICD-10-GM-2020",
      "B34.2");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  DerDiagnoseDefiningcode(String value, String description, String terminologyId, String code) {
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
