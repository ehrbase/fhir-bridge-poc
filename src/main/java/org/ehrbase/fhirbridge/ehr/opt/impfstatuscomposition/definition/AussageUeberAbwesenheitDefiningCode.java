package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum AussageUeberAbwesenheitDefiningCode implements EnumValueSet {
  NO_KNOWN_IMMUNIZATIONS("No known immunizations", "", "HL7 NoImmunizationInfoUvIps", "no-known-immunizations"),

  NO_INFORMATION_ABOUT_IMMUNIZATIONS("No information about immunizations", "", "HL7 NoImmunizationInfoUvIps", "no-immunization-info");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  AussageUeberAbwesenheitDefiningCode(String value, String description, String terminologyId,
      String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
     return this.value ;
  }

  public String getDescription() {
     return this.description ;
  }

  public String getTerminologyId() {
     return this.terminologyId ;
  }

  public String getCode() {
     return this.code ;
  }
}
