package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ProbenartDefiningcode implements EnumValueSet {
  BLEB("Bleb", null, "http", "BLEB"),

  CATHETER_TIP_ANGIO("Catheter Tip, Angio", null, "http", "ANGI"),

  CATHETER_INSERTION_SITE("Catheter Insertion Site", null, "http", "CSITE"),

  BLOOD_ARTERIAL("Blood arterial", null, "http", "BLDA"),

  BRUSHING("Brushing", null, "http", "BRUS"),

  CARBUNCLE("Carbuncle", null, "http", "CARBU"),

  CONJUNCTIVA("Conjunctiva", null, "http", "CNJT"),

  BREATH_USE_EXHLD("Breath (use EXHLD)", null, "http", "BRTH"),

  CATHETER("Catheter", null, "http", "CAT"),

  AMPUTATION("Amputation", null, "http", "AMP"),

  BITE("Bite", null, "http", "BITE"),

  BULLAE("Bulla/Bullae", null, "http", "BULLA"),

  WHOLE_BODY("Whole body", null, "http", "BDY"),

  ASPIRATE("Aspirate", null, "http", "ASP"),

  CERVICAL_MUCUS("Cervical Mucus", null, "http", "CVM"),

  BILE_FLUID("Bile Fluid", null, "http", "BIFL"),

  SPUTUM_DEEP_COUG("Sputum, Deep Coug", null, "http", "DCS"),

  NODULE_CYSTIC("Nodule, Cystic", null, "http", "CYN"),

  CALCULUS_STONE("Calculus (=Stone)", null, "http", "CALC"),

  ENVIRONMENT_ATTEST("Environment, Attest", null, "http", "ATTE"),

  ALLOGRAFT("Allograft", null, "http", "ALL"),

  TISSUE_ACNE("Tissue, Acne", null, "http", "ACNE"),

  BIOPSY("Biopsy", null, "http", "BX"),

  CYST("Cyst", null, "http", "CYST"),

  CATHETER_TIP_ARTERIAL("Catheter Tip, Arterial", null, "http", "ARTC"),

  AMNIOTIC_FLUID("Amniotic fluid", null, "http", "AMN"),

  CLIPPINGS("Clippings", null, "http", "CLIPP"),

  BIOSPY_CONE("Biospy, Cone", null, "http", "CONE"),

  SCRATCH_CAT("Scratch, Cat", null, "http", "CSCR"),

  FLUID_CYST("Fluid, Cyst", null, "http", "CST"),

  BOIL("Boil", null, "http", "BOIL"),

  FLUID_ACNE("Fluid, Acne", null, "http", "ACNFLD"),

  CATHETER_TIP_CVP("Catheter Tip, CVP", null, "http", "CVPT"),

  BOWEL_CONTENTS("Bowel contents", null, "http", "BOWL"),

  BASOPHILS("Basophils", null, "http", "BPH"),

  CATHETER_TIP("Catheter tip", null, "http", "CTP"),

  CURRETAGE("Curretage", null, "http", "CUR"),

  CYST_BAKER_S("Cyst, Baker's", null, "http", "BCYST"),

  BUBO("Bubo", null, "http", "BUB"),

  FLUID_CYSTOSTOMY_TUBE("Fluid, Cystostomy Tube", null, "http", "CSMY"),

  ABSCESS("Abscess", null, "http", "ABS"),

  AUTOPSY("Autopsy", null, "http", "AUTP"),

  BLOOD_PRODUCT_UNIT("Blood product unit", null, "http", "BPU"),

  CEREBRAL_SPINAL_FLUID("Cerebral spinal fluid", null, "http", "CSF"),

  SITE_CVP("Site, CVP", null, "http", "CVPS"),

  SERUM_ACUTE("Serum, Acute", null, "http", "ASERU"),

  BITE_DOG("Bite, Dog", null, "http", "DBITE"),

  BONE("Bone", null, "http", "BONE"),

  BLOOD_BAG("Blood bag", null, "http", "BBL"),

  COLOSTRUM("Colostrum", null, "http", "COL"),

  ENVIRONMENTAL_AUTOCLAVE_AMPULE("Environmental, Autoclave Ampule", null, "http", "AUTOA"),

  CORD_BLOOD("Cord blood", null, "http", "BLDCO"),

  SERUM_CONVALESCENT("Serum, Convalescent", null, "http", "CSERU"),

  CANNULA("Cannula", null, "http", "CNL"),

  BLOOD_CELL_SAVER("Blood, Cell Saver", null, "http", "CSVR"),

  BITE_CAT("Bite, Cat", null, "http", "CBITE"),

  CARDIAC_MUSCLE("Cardiac muscle", null, "http", "CDM"),

  BURN("Burn", null, "http", "BRN"),

  ENVIRONMENTAL_AUTOCLAVE_CAPSULE("Environmental, Autoclave Capsule", null, "http", "AUTOC"),

  BRUSH("Brush", null, "http", "BRSH"),

  WHOLE_BLOOD("Whole blood", null, "http", "BLD"),

  BLISTER("Blister", null, "http", "BLIST"),

  BLOOD_VENOUS("Blood venous", null, "http", "BLDV"),

  AIR_SAMPLE("Air Sample", null, "http", "AIRS");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ProbenartDefiningcode(String value, String description, String terminologyId, String code) {
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
