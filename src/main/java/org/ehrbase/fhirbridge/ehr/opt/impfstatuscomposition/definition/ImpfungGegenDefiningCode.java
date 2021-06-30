package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ImpfungGegenDefiningCode implements EnumValueSet {
  DISEASE_CAUSED_BY_SEVERE_ACUTE_RESPIRATORY_SYNDROME_CORONAVIRUS2_DISORDER("Disease caused by Severe acute respiratory syndrome coronavirus 2 (disorder)", "", "SNOMED Clinical Terms", "840539006"),

  YELLOW_FEVER("Yellow fever", "", "SNOMED Clinical Terms", "16541001"),

  JAPANESE_ENCEPHALITIS_VIRUS_DISEASE("Japanese encephalitis virus disease", "", "SNOMED Clinical Terms", "52947006"),

  CLOSTRIDIOIDES_DIFFICILE_INFECTION_DISORDER("Clostridioides difficile infection (disorder)", "", "SNOMED Clinical Terms", "186431008"),

  VIRAL_HEPATITIS_TYPE_B("Viral hepatitis, type B", "", "SNOMED Clinical Terms", "66071002"),

  CENTRAL_EUROPEAN_ENCEPHALITIS_DISORDER("Central European encephalitis (disorder)", "", "SNOMED Clinical Terms", "16901001"),

  BRUCELLOSIS("Brucellosis", "", "SNOMED Clinical Terms", "75702008"),

  ACUTE_POLIOMYELITIS("Acute Poliomyelitis", "", "SNOMED Clinical Terms", "398102009"),

  MUMPS("Mumps", "", "SNOMED Clinical Terms", "36989005"),

  TETANUS("Tetanus", "", "SNOMED Clinical Terms", "76902006"),

  CYTOMEGALOVIRUS_INFECTION_DISORDER("Cytomegalovirus infection (disorder)", "", "SNOMED Clinical Terms", "28944009"),

  DISEASE_DISORDER("Disease (disorder)", "", "SNOMED Clinical Terms", "64572001"),

  MENINGOCOCCAL_INFECTIOUS_DISEASE("Meningococcal infectious disease", "", "SNOMED Clinical Terms", "23511006"),

  RUBELLA("Rubella", "", "SNOMED Clinical Terms", "36653000"),

  PERTUSSIS("Pertussis", "", "SNOMED Clinical Terms", "27836007"),

  HAEMOPHILUS_INFLUENZAE_TYPE_B_INFECTION("Haemophilus influenzae type b infection", "", "SNOMED Clinical Terms", "709410003"),

  INFLUENZA("Influenza", "", "SNOMED Clinical Terms", "6142004"),

  PNEUMOCOCCAL_INFECTIOUS_DISEASE("Pneumococcal infectious disease", "", "SNOMED Clinical Terms", "16814004"),

  DISEASE_CAUSED_BY_ROTAVIRUS("Disease caused by Rotavirus", "", "SNOMED Clinical Terms", "18624000"),

  THYPHOID_FEVER("Thyphoid fever", "", "SNOMED Clinical Terms", "4834000"),

  CHOLERA("Cholera", "", "SNOMED Clinical Terms", "63650001"),

  LOUSE_BORNE_TYPHUS_DISORDER("Louse-borne typhus (disorder)", "", "SNOMED Clinical Terms", "39111003"),

  MEASLES("Measles", "", "SNOMED Clinical Terms", "14189004"),

  HUMAN_PAPILOMAVIRUS_INFECTION("human papilomavirus infection", "", "SNOMED Clinical Terms", "240532009"),

  VARICELLA("Varicella", "", "SNOMED Clinical Terms", "38907003"),

  DIPHTHERIA_CAUSED_BY_CORYNEBACTERIUM_DIPHTHERIAE("Diphtheria caused by Corynebacterium diphtheriae", "", "SNOMED Clinical Terms", "397430003"),

  RHESUS_ISOIMMUNIZATION_DUE_TO_ANTI_D_DISORDER("Rhesus isoimmunization due to anti-D (disorder)", "", "SNOMED Clinical Terms", "307333004"),

  SMALLPOX("Smallpox", "", "SNOMED Clinical Terms", "67924001"),

  RABIES("Rabies", "", "SNOMED Clinical Terms", "14168008"),

  ANTHRAX("Anthrax", "", "SNOMED Clinical Terms", "409498004"),

  RESPIRATORY_SYNCYTIAL_VIRUS_INFECTION_DISORDER("Respiratory syncytial virus infection (disorder)", "", "SNOMED Clinical Terms", "55735004"),

  PLAGUE("Plague", "", "SNOMED Clinical Terms", "58750007"),

  INFECTIOUS_DISEASE_DISORDER("Infectious disease (disorder)", "", "SNOMED Clinical Terms", "40733004"),

  HERPES_ZOSTER("Herpes Zoster", "", "SNOMED Clinical Terms", "4740000"),

  VIRAL_HEPATITIS_TYPE_A("Viral hepatitis, type A", "", "SNOMED Clinical Terms", "40468003"),

  TUBERCULOSIS("Tuberculosis", "", "SNOMED Clinical Terms", "56717001");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ImpfungGegenDefiningCode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public static Map<String, ImpfungGegenDefiningCode> getCodesAsMap(){
    Map<String, ImpfungGegenDefiningCode> impfungGegenDefiningCodeHashMap = new HashMap<>();
    for (ImpfungGegenDefiningCode impfungGegenDefiningCode : ImpfungGegenDefiningCode.values()) {
      impfungGegenDefiningCodeHashMap.put(impfungGegenDefiningCode.getCode(), impfungGegenDefiningCode);
    }
    return impfungGegenDefiningCodeHashMap;
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
