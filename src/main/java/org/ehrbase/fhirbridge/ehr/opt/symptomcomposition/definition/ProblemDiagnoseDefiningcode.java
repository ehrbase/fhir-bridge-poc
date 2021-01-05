package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ProblemDiagnoseDefiningcode implements EnumValueSet {
  N49727002("49727002", "49727002", "SNOMED Clinical Terms", "49727002"),

  N44169009("44169009", "44169009", "SNOMED Clinical Terms", "44169009"),

  N56018004("56018004", "56018004", "SNOMED Clinical Terms", "56018004"),

  N271807003("271807003", "271807003", "SNOMED Clinical Terms", "271807003"),

  N103001002("103001002", "103001002", "SNOMED Clinical Terms", "103001002"),

  N162397003("162397003", "162397003", "SNOMED Clinical Terms", "162397003"),

  N386661006("386661006", "386661006", "SNOMED Clinical Terms", "386661006"),

  N29857009("29857009", "29857009", "SNOMED Clinical Terms", "29857009"),

  N9826008("9826008", "9826008", "SNOMED Clinical Terms", "9826008"),

  N28743005("28743005", "28743005", "SNOMED Clinical Terms", "28743005"),

  N267036007("267036007", "267036007", "SNOMED Clinical Terms", "267036007"),

  N66857006("66857006", "66857006", "SNOMED Clinical Terms", "66857006"),

  N13791008("13791008", "13791008", "SNOMED Clinical Terms", "13791008"),

  N62315008("62315008", "62315008", "SNOMED Clinical Terms", "62315008"),

  N3006004("3006004", "3006004", "SNOMED Clinical Terms", "3006004"),

  N84387000("84387000", "84387000", "SNOMED Clinical Terms", "84387000"),

  N11833005("11833005", "11833005", "SNOMED Clinical Terms", "11833005"),

  N43724002("43724002", "43724002", "SNOMED Clinical Terms", "43724002"),

  N25064002("25064002", "25064002", "SNOMED Clinical Terms", "25064002"),

  N68962001("68962001", "68962001", "SNOMED Clinical Terms", "68962001"),

  N79890006("79890006", "79890006", "SNOMED Clinical Terms", "79890006"),

  N84229001("84229001", "84229001", "SNOMED Clinical Terms", "84229001"),

  N46742003("46742003", "46742003", "SNOMED Clinical Terms", "46742003"),

  N422400008("422400008", "422400008", "SNOMED Clinical Terms", "422400008"),

  N64531003("64531003", "64531003", "SNOMED Clinical Terms", "64531003"),

  N30746006("30746006", "30746006", "SNOMED Clinical Terms", "30746006"),

  N248567008("248567008", "248567008", "SNOMED Clinical Terms", "248567008"),

  N21522001("21522001", "21522001", "SNOMED Clinical Terms", "21522001"),

  N367391008("367391008", "367391008", "SNOMED Clinical Terms", "367391008"),

  N40917007("40917007", "40917007", "SNOMED Clinical Terms", "40917007"),

  N131148009("131148009", "131148009", "SNOMED Clinical Terms", "131148009"),

  N22253000("22253000", "22253000", "SNOMED Clinical Terms", "22253000"),

  N282145008("282145008", "282145008", "SNOMED Clinical Terms", "282145008"),

  N36955009("36955009", "36955009", "SNOMED Clinical Terms", "36955009"),

  N422587007("422587007", "422587007", "SNOMED Clinical Terms", "422587007"),

  N426000000("426000000", "426000000", "SNOMED Clinical Terms", "426000000"),

  N38880002("38880002", "38880002", "SNOMED Clinical Terms", "38880002"),

  N91175000("91175000", "91175000", "SNOMED Clinical Terms", "91175000"),

  N57676002("57676002", "57676002", "SNOMED Clinical Terms", "57676002"),

  N68235000("68235000", "68235000", "SNOMED Clinical Terms", "68235000");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ProblemDiagnoseDefiningcode(String value, String description, String terminologyId, String code) {
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
