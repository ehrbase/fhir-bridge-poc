package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ImpfstoffDefiningCode implements EnumValueSet {
  TYPHUS_VACCINE_PRODUCT("Typhus vaccine (product)", "", "SNOMED Clinical Terms", "37146000"),

  VACCINE_PRODUCT_CONTAINING_ONLY_HAEMOPHILUS_INFLUENZAE_TYPE_B_AND_NEISSERIA_MENINGITIDIS_SEROGROUP_C_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing only Haemophilus influenzae type B and Neisseria meningitidis serogroup C antigens (medicinal product)", "", "SNOMED Clinical Terms", "836500008"),

  HEPATITIS_A_VIRUS_VACCINE("Hepatitis A virus vaccine", "", "SNOMED Clinical Terms", "14745005"),

  POLIOMYELITIS_ORAL_TRIVALENT_LEBEND_ABGESCHWAECHT("Poliomyelitis, oral, trivalent, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BF02"),

  HAEMOPHILUS_INFLUENZAE_TYPE_B_RECOMBINANT_HEPATITIS_B_VIRUS_VACCINE_PRODUCT("Haemophilus influenzae Type b + recombinant hepatitis B virus vaccine (product)", "", "SNOMED Clinical Terms", "426971004"),

  VACCINE_PRODUCT_CONTAINING_SALMONELLA_ENTERICA_SUBSPECIES_ENTERICA_SEROVAR_TYPHI_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Salmonella enterica subspecies enterica serovar Typhi antigen (medicinal product)", "", "SNOMED Clinical Terms", "836390004"),

  DIPHTHERIA_TETANUS_PERTUSSIS_POLIOMYELITIS_RECOMBINANT_HEPATITIS_B_VIRUS_VACCINE_PRODUCT("Diphtheria + tetanus + pertussis + poliomyelitis + recombinant hepatitis B virus vaccine (product)", "", "SNOMED Clinical Terms", "427542001"),

  VACCINE_PRODUCT_CONTAINING_HEPATITIS_B_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Hepatitis B virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836374004"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_CHOLERA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TYPHOID_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Cholera vaccine (substance) } { Has active ingredient (attribute) = Typhoid vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=396422009}{127489000=396441007}"),

  TOLLWUT_IMPFSTOFFE("Tollwut-Impfstoffe", "", "SNOMED Clinical Terms", "J07BG"),

  HEPATITIS_A_B_VACCINE_PRODUCT("Hepatitis A+B vaccine (product)", "", "SNOMED Clinical Terms", "333702001"),

  PERTUSSIS_IMPFSTOFFE("Pertussis-Impfstoffe", "", "SNOMED Clinical Terms", "J07AJ"),

  VACCINE_PRODUCT_CONTAINING_VACCINIA_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Vaccinia virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836389008"),

  VACCINE_PRODUCT_CONTAINING_LIVE_ATTENUATED_MYCOBACTERIUM_BOVIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing live attenuated Mycobacterium bovis antigen (medicinal product)", "", "SNOMED Clinical Terms", "836402002"),

  PERTUSSIS_GEREINIGTES_ANTIGEN_KOMBINATIONEN_MIT_TOXOIDEN("Pertussis, gereinigtes Antigen, Kombinationen mit Toxoiden", "", "SNOMED Clinical Terms", "J07AJ52"),

  IMMUNGLOBULINE_NORMAL_HUMAN("Immunglobuline, normal human", "", "SNOMED Clinical Terms", "J06BA"),

  DIPHTHERIA_VACCINE("Diphtheria vaccine", "", "SNOMED Clinical Terms", "428214002"),

  BRUCELLA_ANTIGEN("Brucella-Antigen", "", "SNOMED Clinical Terms", "J07AD01"),

  MENINGOKOKKEN_TETRAVALENT_A_C_Y_W135_GEREINIGTES_POLYSACCHARID_ANTIGEN("Meningokokken tetravalent (A, C, Y, W-135), gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AH04"),

  VACCINE_PRODUCT_CONTAINING_ONLY_LIVE_ATTENUATED_HUMAN_ALPHAHERPESVIRUS3_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only live attenuated Human alphaherpesvirus 3 antigen (medicinal product)", "", "SNOMED Clinical Terms", "2221000221107"),

  VACCINE_PRODUCT_CONTAINING_YELLOW_FEVER_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Yellow fever virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836385002"),

  TUBERKULOSE_IMPFSTOFFE("Tuberkulose-Impfstoffe", "", "SNOMED Clinical Terms", "J07AN"),

  CYTOMEGALIEVIRUS_IMMUNGLOBULIN("Cytomegalievirus-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB09"),

  VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HUMAN_POLIOVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Haemophilus influenzae type B antigen (medicinal product) + Vaccine product containing Human poliovirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836380007+1031000221108"),

  DIPHTHERIE_POLIOMYELITIS_TETANUS("Diphtherie-Poliomyelitis-Tetanus", "", "SNOMED Clinical Terms", "J07CA01"),

  ZOSTER_VIRUS_LEBEND_ABGESCHWAECHT("Zoster Virus, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BK02"),

  POCKEN_IMPFSTOFF_LEBEND_MODIFIZIERT("Pocken-Impfstoff, lebend, modifiziert", "", "SNOMED Clinical Terms", "J07BX01"),

  MEASLES_MUMPS_RUBELLA_VARICELLA_VACCINE_PRODUCT("Measles + mumps + rubella + varicella vaccine (product)", "", "SNOMED Clinical Terms", "419550004"),

  PRODUCT_CONTAINING_VARICELLA_ZOSTER_VIRUS_ANTIBODY_MEDICINAL_PRODUCT("Product containing Varicella-zoster virus antibody (medicinal product)", "", "SNOMED Clinical Terms", "62294009"),

  ANTI_D_RH_IMMUNGLOBULIN("Anti-D(rh)-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB01"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HAEMOPHILUS_INFLUENZAE_TYPE_B_AND_HUMAN_POLIOVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae and Haemophilus influenzae type B and Human poliovirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "838279002"),

  PRODUCT_CONTAINING_HEPATITIS_B_SURFACE_ANTIGEN_IMMUNOGLOBULIN_MEDICINAL_PRODUCT("Product containing Hepatitis B surface antigen immunoglobulin (medicinal product)", "", "SNOMED Clinical Terms", "9542007"),

  INFLUENZA_VIRUS_VACCINE("Influenza virus vaccine", "", "SNOMED Clinical Terms", "46233009"),

  MEASLES_AND_MUMPS_VACCINE_PRODUCT("Measles and mumps vaccine (product)", "", "SNOMED Clinical Terms", "785865001"),

  VARICELLA_ZOSTER_VACCINE("Varicella-zoster vaccine", "", "SNOMED Clinical Terms", "407737004"),

  DIPHTHERIE_HEPATITIS_B_PERTUSSIS_TETANUS("Diphtherie-Hepatitis B-Pertussis-Tetanus", "", "SNOMED Clinical Terms", "J07CA05"),

  VACCINE_PRODUCT_CONTAINING_HUMAN_ALPHAHERPESVIRUS3_AND_MEASLES_MORBILLIVIRUS_AND_MUMPS_ORTHORUBULAVIRUS_AND_RUBELLA_VIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Human alphaherpesvirus 3 and Measles morbillivirus and Mumps orthorubulavirus and Rubella virus antigens (medicinal product)", "", "SNOMED Clinical Terms", "838280004"),

  HAEMOPHILUS_INFLUENZAE_B_UND_HEPATITIS_B("Haemophilus influenzae B und Hepatitis B", "", "SNOMED Clinical Terms", "J07CA08"),

  MASERN_KOMBINATIONEN_MIT_ROETELN_LEBEND_ABGESCHWAECHT("Masern, Kombinationen mit Röteln, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BD53"),

  TETANUS_TOXOID_KOMBINATIONEN_MIT_DIPHTHERIE_TOXOID("Tetanus-Toxoid, Kombinationen mit Diphtherie-Toxoid", "", "SNOMED Clinical Terms", "J07AM51"),

  PAPILLOMVIRUS_IMPFSTOFFE("Papillomvirus-Impfstoffe", "", "SNOMED Clinical Terms", "J07BM"),

  VACCINE_PRODUCT_CONTAINING_INFLUENZA_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Influenza virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836377006"),

  GELBFIEBER_IMPFSTOFFE("Gelbfieber-Impfstoffe", "", "SNOMED Clinical Terms", "J07BL"),

  MENINGOKOKKEN_C_GEREINIGTES_POLYSACCHARID_ANTIGEN_KONJUGIERT("Meningokokken C, gereinigtes Polysaccharid-Antigen, konjugiert", "", "SNOMED Clinical Terms", "J07AH07"),

  BRUCELLOSE_IMPFSTOFFE("Brucellose-Impfstoffe", "", "SNOMED Clinical Terms", "J07AD"),

  MEASLES_VACCINE("Measles vaccine", "", "SNOMED Clinical Terms", "386012008"),

  MASERN_LEBEND_ABGESCHWAECHT("Masern, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BD01"),

  DIPHTHERIE_IMPFSTOFFE("Diphtherie-Impfstoffe", "", "SNOMED Clinical Terms", "J07AF"),

  PRODUCT_CONTAINING_HUMAN_ANTI_D_IMMUNOGLOBULIN_MEDICINAL_PRODUCT("Product containing human anti-D immunoglobulin (medicinal product)|", "", "SNOMED Clinical Terms", "786224004"),

  PRODUCT_CONTAINING_PALIVIZUMAB_MEDICINAL_PRODUCT("Product containing palivizumab (medicinal product)", "", "SNOMED Clinical Terms", "108725001"),

  IMMUNGLOBULINE_NORMAL_HUMAN_ZUR_INTRAVASALEN_ANWENDUNG("Immunglobuline, normal human, zur intravasalen Anwendung", "", "SNOMED Clinical Terms", "J06BA02"),

  PALIVIZUMAB("Palivizumab", "", "SNOMED Clinical Terms", "J06BB16"),

  POLIOMYELITIS_IMPFSTOFFE("Poliomyelitis-Impfstoffe", "", "SNOMED Clinical Terms", "J07BF"),

  CHOLERA_VACCINE("Cholera vaccine", "", "SNOMED Clinical Terms", "35736007"),

  PRODUCT_CONTAINING_NORMAL_IMMUNOGLOBULIN_HUMAN_MEDICINAL_PRODUCT("Product containing normal immunoglobulin human (medicinal product)", "", "SNOMED Clinical Terms", "714569001"),

  DIPHTHERIA_PERTUSSIS_TETANUS_VACCINE_PRODUCT("Diphtheria + pertussis + tetanus vaccine (product)", "", "SNOMED Clinical Terms", "421245007"),

  VACCINE_PRODUCT_CONTAINING_ROTAVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Rotavirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836387005"),

  VARICELLA_ZOSTER_IMMUNGLOBULIN("Varicella/Zoster-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB03"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_LIVE_POLIOVIRUS_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Haemophilus influenzae type b vaccine (substance) } { Has active ingredient (attribute) = Live Poliovirus vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=412374001}{127489000=396436004}"),

  RUBELLA_VACCINE("Rubella vaccine", "", "SNOMED Clinical Terms", "386013003"),

  CHOLERA_IMPFSTOFFE("Cholera-Impfstoffe", "", "SNOMED Clinical Terms", "J07AE"),

  DIPHTHERIA_TETANUS_PERTUSSIS_POLIOMYELITIS_HAEMOPHILUS_INFLUENZAE_B_VACCINE_PRODUCT("Diphtheria + tetanus + pertussis + poliomyelitis + haemophilus influenzae b vaccine (product)", "", "SNOMED Clinical Terms", "414004005"),

  PRODUCT_CONTAINING_RABIES_HUMAN_IMMUNE_GLOBULIN_MEDICINAL_PRODUCT("Product containing rabies human immune globulin (medicinal product)", "", "SNOMED Clinical Terms", "80834004"),

  ENCEPHALITIS_JAPANISCHE_LEBEND_ABGESCHWAECHT("Encephalitis, japanische, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BA03"),

  MENINGOCOCCUS_VACCINE("Meningococcus vaccine", "", "SNOMED Clinical Terms", "423531006"),

  VACCINE_PRODUCT_CONTAINING_ONLY_SEVERE_ACUTE_RESPIRATORY_SYNDROME_CORONAVIRUS2_MESSENGER_RIBONUCLEIC_ACID_MEDICINAL_PRODUCT("Vaccine product containing only Severe acute respiratory syndrome coronavirus 2 messenger ribonucleic acid (medicinal product)", "", "SNOMED Clinical Terms", "1119349007"),

  VARICELLA_ZOSTER_IMPFSTOFFE("Varicella Zoster Impfstoffe", "", "SNOMED Clinical Terms", "J07BK"),

  VACCINE_PRODUCT_CONTAINING_HUMAN_POLIOVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Human poliovirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "1031000221108"),

  HUMANER_PAPILLOMVIRUS_IMPFSTOFF_TYPEN6111618("Humaner-Papillomvirus-Impfstoff (Typen 6,11,16,18)", "", "SNOMED Clinical Terms", "J07BM01"),

  INFLUENZA_LEBEND_ABGESCHWAECHT("Influenza, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BB03"),

  PERTUSSIS_INAKTIVIERT_GANZE_ZELLE_KOMBINATIONEN_MIT_TOXOIDEN("Pertussis, inaktiviert, ganze Zelle, Kombinationen mit Toxoiden", "", "SNOMED Clinical Terms", "J07AJ51"),

  DIPHTHERIE_PERTUSSIS_POLIOMYELITIS_TETANUS_HEPATITIS_B("Diphtherie-Pertussis-Poliomyelitis-Tetanus-Hepatitis B", "", "SNOMED Clinical Terms", "J07CA12"),

  PERTUSSIS_VACCINE("Pertussis vaccine", "", "SNOMED Clinical Terms", "61602008"),

  MENINGOKOKKEN_A_GEREINIGTES_POLYSACCHARID_ANTIGEN_KONJUGIERT("Meningokokken A, gereinigtes Polysaccharid-Antigen, konjugiert", "", "SNOMED Clinical Terms", "J07AH10"),

  VACCINE_PRODUCT_CONTAINING_RABIES_LYSSAVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Rabies lyssavirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836393002"),

  VACCINE_PRODUCT_CONTAINING_NEISSERIA_MENINGITIDIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Neisseria meningitidis antigen (medicinal product)", "", "SNOMED Clinical Terms", "836401009"),

  MENINGOKOKKEN_A_GEREINIGTES_POLYSACCHARID_ANTIGEN("Meningokokken A, gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AH01"),

  DIPHTHERIA_TETANUS_PERTUSSIS_RECOMBINANT_HEPATITIS_B_VIRUS_VACCINE_PRODUCT("Diphtheria + tetanus + pertussis + recombinant hepatitis B virus vaccine (product)", "", "SNOMED Clinical Terms", "426081003"),

  VACCINE_PRODUCT_CONTAINING_MEASLES_MORBILLIVIRUS_AND_MUMPS_ORTHORUBULAVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Measles morbillivirus and Mumps orthorubulavirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836499004"),

  VACCINE_PRODUCT_CONTAINING_ONLY_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HEPATITIS_B_VIRUS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_ONLY_NEISSERIA_MENINGITIDIS_SEROGROUP_A_AND_C_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing only Corynebacterium diphtheriae antigen (medicinal product) + Vaccine product containing Haemophilus influenzae type B antigen (medicinal product) + Vaccine product containing Bordetella pertussis antigen (medicinal product) + Vaccine product containing Clostridium tetani antigen (medicinal product) + Vaccine product containing Hepatitis B virus antigen (medicinal product) + Vaccine product containing only Neisseria meningitidis serogroup A and C antigens (medicinal product)", "", "SNOMED Clinical Terms", "871729003+836380007+601000221108+863911006+836374004+871871008"),

  MASERN_KOMBINATIONEN_MIT_MUMPS_UND_ROETELN_LEBEND_ABGESCHWAECHT("Masern, Kombinationen mit Mumps und Röteln, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BD52"),

  PNEUMOCOCCAL_VACCINE("Pneumococcal vaccine", "", "SNOMED Clinical Terms", "333598008"),

  HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE("Haemophilus influenzae Type b vaccine", "", "SNOMED Clinical Terms", "333680004"),

  PEST_INAKTIVIERT_GANZE_ZELLE("Pest, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AK01"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_DIPHTHERIA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_PERTUSSIS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TETANUS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HEPATITIS_B_VIRUS_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Diphtheria vaccine (substance) } { Has active ingredient (attribute) = Haemophilus influenzae type b vaccine (substance) } { Has active ingredient (attribute) = Pertussis vaccine (substance) } { Has active ingredient (attribute) = Tetanus vaccine (substance) } { Has active ingredient (attribute) = Hepatitis B virus vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=428126001}{127489000=412374001}{127489000=396433007}{127489000=412375000}{127489000=396424005}"),

  TYPHOID_VACCINE("Typhoid vaccine", "", "SNOMED Clinical Terms", "89428009"),

  MILZBRAND_IMPFSTOFFE("Milzbrand-Impfstoffe", "", "SNOMED Clinical Terms", "J07AC"),

  VACCINE_PRODUCT_CONTAINING_ONLY_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_RUBELLA_VIRUS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only Corynebacterium diphtheriae antigen (medicinal product) + Vaccine product containing Rubella virus antigen (medicinal product) + Vaccine product containing Clostridium tetani antigen (medicinal product)", "", "SNOMED Clinical Terms", "871729003+836388000+863911006"),

  MUMPS_LIVE_VIRUS_VACCINE("Mumps live virus vaccine", "", "SNOMED Clinical Terms", "90043005"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_RUBELLA_AND_MUMPS_VACCINE_SUBSTANCE("Vaccine product (product): Has active ingredient (attribute) = Rubella and mumps vaccine (substance)", "", "SNOMED Clinical Terms", "787859002:127489000=412300006"),

  HAEMOPHILUS_INFLUENZAE_B_KOMBINATIONEN_MIT_MENINGOKOKKEN_C_KONJUGIERT("Haemophilus influenzae B, Kombinationen mit Meningokokken C, konjugiert", "", "SNOMED Clinical Terms", "J07AG53"),

  VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Haemophilus influenzae type B antigen (medicinal product) + Vaccine product containing Bordetella pertussis antigen (medicinal product)", "", "SNOMED Clinical Terms", "836380007+601000221108"),

  VACCINE_PRODUCT_CONTAINING_MUMPS_ORTHORUBULAVIRUS_AND_RUBELLA_VIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Mumps orthorubulavirus and Rubella virus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836376002"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_MEASLES_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_RUBELLA_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Measles vaccine (substance) } { Has active ingredient (attribute) = Rubella vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=396427003}{127489000=396438003}"),

  HEPATITIS_A_TYPHOID_VACCINE_PRODUCT("Hepatitis A+typhoid vaccine (product)", "", "SNOMED Clinical Terms", "333707007"),

  HUMAN_PAPILLOMAVIRUS_VACCINE("Human papillomavirus vaccine", "", "SNOMED Clinical Terms", "424519000"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HAEMOPHILUS_INFLUENZAE_TYPE_B_AND_HEPATITIS_B_VIRUS_AND_HUMAN_POLIOVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae and Haemophilus influenzae type B and Hepatitis B virus and Human poliovirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "871896006"),

  KOMBINATIONEN("Kombinationen", "", "SNOMED Clinical Terms", "J07BC20"),

  BRUCELLA_VACCINE("Brucella vaccine", "", "SNOMED Clinical Terms", "7230005"),

  PRODUCT_CONTAINING_TETANUS_ANTITOXIN_MEDICINAL_PRODUCT("Product containing tetanus antitoxin (medicinal product)", "", "SNOMED Clinical Terms", "384706007"),

  VACCINE_PRODUCT_CONTAINING_STREPTOCOCCUS_PNEUMONIAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Streptococcus pneumoniae antigen (medicinal product) + Vaccine product containing Haemophilus influenzae type B antigen (medicinal product)", "", "SNOMED Clinical Terms", "836398006+836380007"),

  VACCINE_PRODUCT_CONTAINING_RUBELLA_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Rubella virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836388000"),

  PERTUSSIS_GEREINIGTES_ANTIGEN("Pertussis, gereinigtes Antigen", "", "SNOMED Clinical Terms", "J07AJ02"),

  DIPHTHERIE_PERTUSSIS_POLIOMYELITIS_TETANUS("Diphtherie-Pertussis-Poliomyelitis-Tetanus", "", "SNOMED Clinical Terms", "J07CA02"),

  VARICELLA_ZOSTER_LIVE_ATTENUATED_VACCINE_PRODUCT("Varicella-zoster live attenuated vaccine (product)", "", "SNOMED Clinical Terms", "407746005"),

  BEZLOTOXUMAB("Bezlotoxumab", "", "SNOMED Clinical Terms", "J06BB21"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HEPATITIS_B_VIRUS_AND_HUMAN_POLIOVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae and Hepatitis B virus and Human poliovirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "871892008"),

  PERTUSSIS_INAKTIVIERT_GANZE_ZELLE("Pertussis, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AJ01"),

  INFLUENZA_IMPFSTOFFE("Influenza-Impfstoffe", "", "SNOMED Clinical Terms", "J07BB"),

  TOLLWUT_INAKTIVIERT_GANZES_VIRUS("Tollwut, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BG01"),

  TYPHUS_GEREINIGTES_POLYSACCHARID_ANTIGEN("Typhus, gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AP03"),

  DIPHTHERIA_TETANUS_POLIOMYELITIS_VACCINE_PRODUCT("Diphtheria + tetanus + poliomyelitis vaccine (product)", "", "SNOMED Clinical Terms", "414006007"),

  MENINGOKOKKEN_IMPFSTOFFE("Meningokokken-Impfstoffe", "", "SNOMED Clinical Terms", "J07AH"),

  PRODUCT_CONTAINING_CYTOMEGALOVIRUS_ANTIBODY_MEDICINAL_PRODUCT("Product containing Cytomegalovirus antibody (medicinal product)", "", "SNOMED Clinical Terms", "9778000"),

  POLIOMYELITIS_TRIVALENT_INAKTIVIERT_GANZES_VIRUS("Poliomyelitis, trivalent, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BF03"),

  VACCINE_PRODUCT_CONTAINING_VIBRIO_CHOLERAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_SALMONELLA_ENTERICA_SUBSPECIES_ENTERICA_SEROVAR_TYPHI_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Vibrio cholerae antigen (medicinal product) + Vaccine product containing Salmonella enterica subspecies enterica serovar Typhi antigen (medicinal product)", "", "SNOMED Clinical Terms", "836383009+836390004"),

  TETANUS_TOXOID("Tetanus-Toxoid", "", "SNOMED Clinical Terms", "J07AM01"),

  VACCINE_PRODUCT_CONTAINING_MEASLES_MORBILLIVIRUS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_RUBELLA_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Measles morbillivirus antigen (medicinal product) + Vaccine product containing Rubella virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836382004+836388000"),

  DIPHTHERIE_TOXOID("Diphtherie-Toxoid", "", "SNOMED Clinical Terms", "J07AF01"),

  VACCINE_PRODUCT_CONTAINING_HEPATITIS_A_AND_HEPATITIS_B_VIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Hepatitis A and Hepatitis B virus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836493003"),

  ROETELN_KOMBINATIONEN_MIT_MUMPS_LEBEND_ABGESCHWAECHT("Röteln, Kombinationen mit Mumps, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BJ51"),

  YELLOW_FEVER_VACCINE("Yellow fever vaccine", "", "SNOMED Clinical Terms", "56844000"),

  VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HUMAN_POLIOVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Clostridium tetani and Corynebacterium diphtheriae and Human poliovirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836505003"),

  MUMPS_LEBEND_ABGESCHWAECHT("Mumps, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BE01"),

  VACCINE_PRODUCT_CONTAINING_STREPTOCOCCUS_PNEUMONIAE_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Streptococcus pneumoniae antigen (medicinal product)", "", "SNOMED Clinical Terms", "836398006"),

  MENINGOKOKKEN_B_AEUSSERE_VESIKELMEMBRAN_IMPFSTOFF("Meningokokken B, äußere Vesikelmembran-Impfstoff", "", "SNOMED Clinical Terms", "J07AH06"),

  ANTHRAX_VACCINE("Anthrax vaccine", "", "SNOMED Clinical Terms", "333521006"),

  HEPATITIS_A_INAKTIVIERT_GANZES_VIRUS("Hepatitis A, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BC02"),

  CHOLERA_LEBEND_ABGESCHWAECHT("Cholera, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07AE02"),

  TYPHUS_KOMBINATIONEN_MIT_PARATYPHUSTYPEN("Typhus, Kombinationen mit Paratyphustypen", "", "SNOMED Clinical Terms", "J07AP10"),

  TUBERCULOSOS_VACCINE("Tuberculosos vaccine", "", "SNOMED Clinical Terms", "420538001"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis antigen (medicinal product)", "", "SNOMED Clinical Terms", "601000221108"),

  VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Clostridium tetani and Corynebacterium diphtheriae antigens (medicinal product)", "", "SNOMED Clinical Terms", "836502000"),

  DIPHTHERIE_HEPATITIS_B_TETANUS("Diphtherie-Hepatitis B-Tetanus", "", "SNOMED Clinical Terms", "J07CA07"),

  CHOLERA_KOMBINATIONEN_MIT_TYPHUS_IMPFSTOFF_INAKTIVIERT_GANZE_ZELLE("Cholera, Kombinationen mit Typhus-Impfstoff, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AE51"),

  TYPHUS_EXANTHEMATICUS_IMPFSTOFF("Typhus (exanthematicus)-Impfstoff", "", "SNOMED Clinical Terms", "J07AR"),

  PNEUMOKOKKEN_GEREINIGTES_POLYSACCHARID_ANTIGEN_KONJUGIERT("Pneumokokken, gereinigtes Polysaccharid-Antigen, konjugiert", "", "SNOMED Clinical Terms", "J07AL02"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_PERTUSSIS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TOXOID_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Haemophilus influenzae type b vaccine (substance) } { Has active ingredient (attribute) = Pertussis vaccine (substance) } { Has active ingredient (attribute) = Toxoid (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=412374001}{127489000=396433007}{127489000=396411005}"),

  POLIOVIRUS_VACCINE("Poliovirus vaccine", "", "SNOMED Clinical Terms", "111164008"),

  HAEMOPHILUS_INFLUENZAE_B_GEREINIGTES_ANTIGEN_KONJUGIERT("Haemophilus influenzae B, gereinigtes Antigen konjugiert", "", "SNOMED Clinical Terms", "J07AG01"),

  TOLLWUT_IMMUNGLOBULIN("Tollwut-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB05"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_DIPHTHERIA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_PERTUSSIS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TETANUS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HEPATITIS_B_VIRUS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_MENINGOCOCCUS_GROUP_A_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_MENINGOCOCCUS_GROUP_C_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Diphtheria vaccine (substance) } { Has active ingredient (attribute) = Haemophilus influenzae type b vaccine (substance) } { Has active ingredient (attribute) = Pertussis vaccine (substance) } { Has active ingredient (attribute) = Tetanus vaccine (substance) } { Has active ingredient (attribute) = Hepatitis B virus vaccine (substance) } { Has active ingredient (attribute) = Meningococcus group A vaccine (substance) } { Has active ingredient (attribute) = Meningococcus group C vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=428126001}{127489000=412374001}{127489000=396433007}{127489000=412375000}{127489000=396424005}{127489000=768365004}{127489000=768366003}"),

  DIPHTHERIE_HAEMOPHILUS_INFLUENZAE_B_PERTUSSIS_TETANUS_HEPATITIS_B("Diphtherie-Haemophilus influenzae B-Pertussis-Tetanus-Hepatitis B", "", "SNOMED Clinical Terms", "J07CA11"),

  IMMUNGLOBULINE_NORMAL_HUMAN_ZUR_EXTRAVASALEN_ANWENDUNG("Immunglobuline, normal human, zur extravasalen Anwendung", "", "SNOMED Clinical Terms", "J06BA01"),

  VACCINE_PRODUCT_CONTAINING_ONLY_LIVE_ATTENUATED_MUMPS_ORTHORUBULAVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only live attenuated Mumps orthorubulavirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "871738001"),

  VARICELLA_LEBEND_ABGESCHWAECHT("Varicella, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BK01"),

  VACCINE_PRODUCT_CONTAINING_ONLY_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HEPATITIS_B_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only Corynebacterium diphtheriae antigen (medicinal product) + Vaccine product containing Haemophilus influenzae type B antigen (medicinal product) + Vaccine product containing Bordetella pertussis antigen (medicinal product) + Vaccine product containing Clostridium tetani antigen (medicinal product) + Vaccine product containing Hepatitis B virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "871729003+836380007+601000221108+863911006+836374004"),

  ANDERE_MENINGOKOKKEN_POLYVALENT_GEREINIGTES_POLYSACCHARID_ANTIGEN("Andere Meningokokken polyvalent, gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AH05"),

  HAEMOPHILUS_INFLUENZAE_TYPE_B_MENINGOCOCCAL_GROUP_C_VACCINE_PRODUCT("Haemophilus influenzae type b + Meningococcal group C vaccine (product)", "", "SNOMED Clinical Terms", "423912009"),

  FSME_INAKTIVIERT_GANZES_VIRUS("FSME, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BA01"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_PNEUMOCOCCAL_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Pneumococcal vaccine (substance) } { Has active ingredient (attribute) = Haemophilus influenzae type b vaccine (substance) }", "", "SNOMED Clinical Terms", "78785900:{127489000=398730001}{127489000=412374001}"),

  VACCINE_PRODUCT_CONTAINING_HEPATITIS_A_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Hepatitis A virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836375003"),

  PEST_IMPFSTOFFE("Pest-Impfstoffe", "", "SNOMED Clinical Terms", "J07AK"),

  DIPHTHERIA_TETANUS_PERTUSSIS_POLIOMYELITIS_RECOMBINANT_HEPATITIS_B_VIRUS_RECOMBINANT_HAEMOPHILUS_INFLUENZAE_TYPE_B_VACCINE_PRODUCT("Diphtheria + tetanus + pertussis + poliomyelitis + recombinant hepatitis B virus + recombinant haemophilus influenzae type B vaccine (product)", "", "SNOMED Clinical Terms", "426842004"),

  ANDERE_MENINGOKOKKEN_MONOVALENT_GEREINIGTES_POLYSACCHARID_ANTIGEN("Andere Meningokokken monovalent, gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AH02"),

  CHOLERA_INAKTIVIERT_GANZE_ZELLE("Cholera, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AE01"),

  VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Haemophilus influenzae type B antigen (medicinal product)", "", "SNOMED Clinical Terms", "836380007"),

  MUMPS_IMPFSTOFFE("Mumps-Impfstoffe", "", "SNOMED Clinical Terms", "J07BE"),

  TYPHUS_IMPFSTOFFE("Typhus-Impfstoffe", "", "SNOMED Clinical Terms", "J07AP"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HUMAN_POLIOVIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae and Human poliovirus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836508001"),

  ENCEPHALITIS_IMPFSTOFFE("Encephalitis-Impfstoffe", "", "SNOMED Clinical Terms", "J07BA"),

  MASERN_KOMBINATIONEN_MIT_MUMPS_ROETELN_UND_VARICELLA_LEBEND_ABGESCHWAECHT("Masern, Kombinationen mit Mumps, Röteln und Varicella, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BD54"),

  HEPATITIS_B_GEREINIGTES_ANTIGEN("Hepatitis B, gereinigtes Antigen", "", "SNOMED Clinical Terms", "J07BC01"),

  ROETELN_IMPFSTOFFE("Röteln-Impfstoffe", "", "SNOMED Clinical Terms", "J07BJ"),

  PRODUCT_CONTAINING_BEZLOTOXUMAB_MEDICINAL_PRODUCT("Product containing bezlotoxumab (medicinal product)", "", "SNOMED Clinical Terms", "763703008"),

  HUMANER_PAPILLOMVIRUS_IMPFSTOFF_TYPEN1618("Humaner-Papillomvirus-Impfstoff (Typen 16,18)", "", "SNOMED Clinical Terms", "J07BM02"),

  ENCEPHALITIS_JAPANISCHE_INAKTIVIERT_GANZES_VIRUS("Encephalitis, japanische, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BA02"),

  DIPHTHERIE_HAEMOPHILUS_INFLUENZAE_B_PERTUSSIS_POLIOMYELITIS_TETANUS("Diphtherie-Haemophilus influenzae B-Pertussis-Poliomyelitis-Tetanus", "", "SNOMED Clinical Terms", "J07CA06"),

  TYPHUS_HEPATITIS_A("Typhus-Hepatitis A", "", "SNOMED Clinical Terms", "J07CA10"),

  MENINGOKOKKEN_B_MULTIKOMPONENTEN_IMPFSTOFF("Meningokokken B, Multikomponenten-Impfstoff", "", "SNOMED Clinical Terms", "J07AH09"),

  POLIOMYELITIS_ORAL_MONOVALENT_LEBEND_ABGESCHWAECHT("Poliomyelitis, oral, monovalent, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BF01"),

  MEASLES_MUMPS_AND_RUBELLA_VACCINE_PRODUCT("Measles, mumps and rubella vaccine (product)", "", "SNOMED Clinical Terms", "61153008"),

  HEPATITIS_A_GEREINIGTES_ANTIGEN("Hepatitis A, gereinigtes Antigen", "", "SNOMED Clinical Terms", "J07BC03"),

  VACCINE_PRODUCT_CONTAINING_ONLY_SEVERE_ACUTE_RESPIRATORY_SYNDROME_CORONAVIRUS2_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only Severe acute respiratory syndrome coronavirus 2 antigen (medicinal product)", "", "SNOMED Clinical Terms", "1119305005"),

  VACCINE_PRODUCT_CONTAINING_HUMAN_ALPHAHERPESVIRUS3_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Human alphaherpesvirus 3 antigen (medicinal product)", "", "SNOMED Clinical Terms", "836495005"),

  ROTAVIRUS_PENTAVALENT_LEBEND_REASSORTANTEN("Rotavirus, pentavalent, lebend, Reassortanten", "", "SNOMED Clinical Terms", "J07BH02"),

  INFLUENZA_INAKTIVIERT_SPALTVIRUS_ODER_OBERFLAECHENANTIGEN("Influenza, inaktiviert, Spaltvirus oder Oberflächenantigen", "", "SNOMED Clinical Terms", "J07BB02"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae antigens (medicinal product)", "", "SNOMED Clinical Terms", "836503005"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_DIPHTHERIA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_HEPATITIS_B_VIRUS_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TETANUS_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Diphtheria vaccine (substance) } { Has active ingredient (attribute) = Hepatitis B virus vaccine (substance) } { Has active ingredient (attribute) = Tetanus vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=428126001}{127489000=396424005}{127489000=412375000}"),

  HAEMOPHILUS_INFLUENZAE_B_UND_POLIOMYELITIS("Haemophilus influenzae B und Poliomyelitis", "", "SNOMED Clinical Terms", "J07CA04"),

  ROTAVIRUS_LEBEND_ABGESCHWAECHT("Rotavirus, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BH01"),

  VACCINE_PRODUCT_CONTAINING_ONLY_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_HEPATITIS_B_VIRUS_ANTIGEN_MEDICINAL_PRODUCT_VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing only Corynebacterium diphtheriae antigen (medicinal product) + Vaccine product containing Hepatitis B virus antigen (medicinal product) + Vaccine product containing Clostridium tetani antigen (medicinal product)", "", "SNOMED Clinical Terms", "871729003+836374004+863911006"),

  VACCINE_PRODUCT_CONTAINING_HEPATITIS_A_VIRUS_AND_SALMONELLA_ENTERICA_SUBSPECIES_ENTERICA_SEROVAR_TYPHI_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Hepatitis A virus and Salmonella enterica subspecies enterica serovar Typhi antigens (medicinal product)", "", "SNOMED Clinical Terms", "836501007"),

  TYPHUS_INAKTIVIERT_GANZE_ZELLE("Typhus, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AP02"),

  TYPHUS_EXANTHEMATICUS_INAKTIVIERT_GANZE_ZELLE("Typhus exanthematicus, inaktiviert, ganze Zelle", "", "SNOMED Clinical Terms", "J07AR01"),

  VACCINE_PRODUCT_CONTAINING_BORDETELLA_PERTUSSIS_AND_CLOSTRIDIUM_TETANI_AND_CORYNEBACTERIUM_DIPHTHERIAE_AND_HEPATITIS_B_VIRUS_MEDICINAL_PRODUCT("Vaccine product containing Bordetella pertussis and Clostridium tetani and Corynebacterium diphtheriae and Hepatitis B virus (medicinal product)", "", "SNOMED Clinical Terms", "871917002"),

  SMALLPOX_VACCINE("Smallpox vaccine", "", "SNOMED Clinical Terms", "33234009"),

  VACCINE_PRODUCT_CONTAINING_JAPANESE_ENCEPHALITIS_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Japanese encephalitis virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836378001"),

  HAEMOPHILUS_INFLUENZAE_B_IMPFSTOFFE("Haemophilus influenzae B-Impfstoffe", "", "SNOMED Clinical Terms", "J07AG"),

  VACCINE_PRODUCT_PRODUCT("Vaccine product (product)", "", "SNOMED Clinical Terms", "787859002"),

  JAPANESE_B_ENCEPHALITIS_VACCINE("Japanese B encephalitis vaccine", "", "SNOMED Clinical Terms", "333697005"),

  HEPATITIS_B_IMMUNGLOBULIN("Hepatitis-B-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB04"),

  PNEUMOKOKKEN_GEREINIGTES_POLYSACCHARID_ANTIGEN("Pneumokokken, gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AL01"),

  PNEUMOKOKKEN_GEREINIGTES_POLYSACCHARID_ANTIGEN_UND_HAEMOPHILUS_INFLUENZAE_B_KONJUGIERT("Pneumokokken, gereinigtes Polysaccharid-Antigen und Haemophilus influenzae B, konjugiert", "", "SNOMED Clinical Terms", "J07AL52"),

  INFLUENZA_INAKTIVIERT_GANZES_VIRUS("Influenza, inaktiviert, ganzes Virus", "", "SNOMED Clinical Terms", "J07BB01"),

  VACCINE_PRODUCT_CONTAINING_YERSINIA_PESTIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Yersinia pestis antigen (medicinal product)", "", "SNOMED Clinical Terms", "840549009"),

  VACCINE_PRODUCT_PRODUCT_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_DIPHTHERIA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_RUBELLA_VACCINE_SUBSTANCE_HAS_ACTIVE_INGREDIENT_ATTRIBUTE_TETANUS_VACCINE_SUBSTANCE("Vaccine product (product): { Has active ingredient (attribute) = Diphtheria vaccine (substance) } { Has active ingredient (attribute) = Rubella vaccine (substance) } { Has active ingredient (attribute) = Tetanus vaccine (substance) }", "", "SNOMED Clinical Terms", "787859002:{127489000=428126001}{127489000=396438003}{127489000=412375000}"),

  TETANUS_IMPFSTOFFE("Tetanus-Impfstoffe", "", "SNOMED Clinical Terms", "J07AM"),

  MENINGOKOKKEN_BIVALENT_A_C_GEREINIGTES_POLYSACCHARID_ANTIGEN("Meningokokken bivalent (A, C), gereinigtes Polysaccharid-Antigen", "", "SNOMED Clinical Terms", "J07AH03"),

  MASERN_IMPFSTOFFE("Masern-Impfstoffe", "", "SNOMED Clinical Terms", "J07BD"),

  TICK_BORNE_ENCEPHALITIS_VACCINE("Tick-borne encephalitis vaccine", "", "SNOMED Clinical Terms", "333699008"),

  RABIES_VACCINE("Rabies vaccine", "", "SNOMED Clinical Terms", "333606008"),

  ROTAVIRUS_VACCINE("Rotavirus vaccine", "", "SNOMED Clinical Terms", "116077000"),

  POLIOMYELITIS_ORAL_BIVALENT_LEBEND_ABGESCHWAECHT("Poliomyelitis, oral, bivalent, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BF04"),

  DIPHTHERIE_HAEMOPHILUS_INFLUENZAE_B_PERTUSSIS_POLIOMYELITIS_TETANUS_HEPATITIS_B("Diphtherie-Haemophilus influenzae B-Pertussis-Poliomyelitis-Tetanus-Hepatitis B", "", "SNOMED Clinical Terms", "J07CA09"),

  DIPHTHERIA_TETANUS_PERTUSSIS_POLIOMYELITIS_VACCINE_PRODUCT("Diphtheria + tetanus + pertussis + poliomyelitis vaccine (product)", "", "SNOMED Clinical Terms", "414005006"),

  TUBERKULOSE_LEBEND_ABGESCHWAECHT("Tuberkulose, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07AN01"),

  TETANUS_IMMUNGLOBULIN("Tetanus-Immunglobulin", "", "SNOMED Clinical Terms", "J06BB02"),

  PLAGUE_VACCINE("Plague vaccine", "", "SNOMED Clinical Terms", "11866009"),

  ROTAVIRUS_DIARRHOE_IMPFSTOFFE("Rotavirus-Diarrhoe-Impfstoffe", "", "SNOMED Clinical Terms", "J07BH"),

  MASERN_KOMBINATIONEN_MIT_MUMPS_LEBEND_ABGESCHWAECHT("Masern, Kombinationen mit Mumps, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BD51"),

  VACCINE_PRODUCT_CONTAINING_CLOSTRIDIUM_TETANI_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Clostridium tetani antigen (medicinal product)", "", "SNOMED Clinical Terms", "863911006"),

  HAEMOPHILUS_INFLUENZAE_B_KOMBINATIONEN_MIT_PERTUSSIS_UND_TOXOIDEN("Haemophilus influenzae B, Kombinationen mit Pertussis und Toxoiden", "", "SNOMED Clinical Terms", "J07AG52"),

  HUMANER_PAPILLOMVIRUS_IMPFSTOFF_TYPEN61116183133455258("Humaner-Papillomvirus-Impfstoff (Typen 6,11,16,18,31,33,45,52,58)", "", "SNOMED Clinical Terms", "J07BM03"),

  ZOSTER_VIRUS_GEREINIGTES_ANTIGEN("Zoster Virus, gereinigtes Antigen", "", "SNOMED Clinical Terms", "J07BK03"),

  DIPHTHERIE_HAEMOPHILUS_INFLUENZAE_B_PERTUSSIS_TETANUS_HEPATITIS_B_MENINGOKOKKEN_A_C("Diphtherie-Haemophilus influenzae B-Pertussis-Tetanus-Hepatitis B-Meningokokken A + C", "", "SNOMED Clinical Terms", "J07CA13"),

  VACCINE_PRODUCT_CONTAINING_HUMAN_PAPILLOMAVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Human papillomavirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836379009"),

  MENINGOKOKKEN_TETRAVALENT_A_C_Y_W135_GEREINIGTES_POLYSACCHARID_ANTIGEN_KONJUGIERT("Meningokokken tetravalent (A, C, Y, W-135), gereinigtes Polysaccharid-Antigen, konjugiert", "", "SNOMED Clinical Terms", "J07AH08"),

  VACCINE_PRODUCT_CONTAINING_BACILLUS_ANTHRACIS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Bacillus anthracis antigen (medicinal product)", "", "SNOMED Clinical Terms", "836384003"),

  HEPATITIS_B_VIRUS_VACCINE("Hepatitis B virus vaccine", "", "SNOMED Clinical Terms", "34689006"),

  ANDERE_VIRALE_IMPFSTOFFE("Andere virale Impfstoffe", "", "SNOMED Clinical Terms", "J07BX"),

  VACCINE_PRODUCT_CONTAINING_VIBRIO_CHOLERAE_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Vibrio cholerae antigen (medicinal product)", "", "SNOMED Clinical Terms", "836383009"),

  DIPHTHERIA_TETANUS_VACCINE_PRODUCT("Diphtheria + tetanus vaccine (product)", "", "SNOMED Clinical Terms", "350327004"),

  ANTHRAX_ANTIGEN("Anthrax-Antigen", "", "SNOMED Clinical Terms", "J07AC01"),

  PNEUMOKOKKEN_IMPFSTOFFE("Pneumokokken-Impfstoffe", "", "SNOMED Clinical Terms", "J07AL"),

  VACCINE_PRODUCT_CONTAINING_MEASLES_MORBILLIVIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Measles morbillivirus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836382004"),

  VACCINE_PRODUCT_CONTAINING_HAEMOPHILUS_INFLUENZAE_TYPE_B_AND_HEPATITIS_B_VIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Haemophilus influenzae type B and Hepatitis B virus antigens (medicinal product)", "", "SNOMED Clinical Terms", "865946000"),

  BAKTERIELLE_UND_VIRALE_IMPFSTOFFE_KOMBINIERT("Bakterielle und virale Impfstoffe, kombiniert", "", "SNOMED Clinical Terms", "J07CA"),

  GELBFIEBER_LEBEND_ABGESCHWAECHT("Gelbfieber, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BL01"),

  VACCINE_PRODUCT_CONTAINING_CORYNEBACTERIUM_DIPHTHERIAE_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Corynebacterium diphtheriae antigen (medicinal product)", "", "SNOMED Clinical Terms", "836381006"),

  DIPHTHERIE_ROETELN_TETANUS("Diphtherie-Röteln-Tetanus", "", "SNOMED Clinical Terms", "J07CA03"),

  HEPATITIS_IMPFSTOFFE("Hepatitis-Impfstoffe", "", "SNOMED Clinical Terms", "J07BC"),

  HAEMOPHILUS_INFLUENZAE_B_KOMBINATIONEN_MIT_TOXOIDEN("Haemophilus influenzae B, Kombinationen mit Toxoiden", "", "SNOMED Clinical Terms", "J07AG51"),

  SPEZIFISCHE_IMMUNGLOBULINE("Spezifische Immunglobuline", "", "SNOMED Clinical Terms", "J06BB"),

  VACCINE_PRODUCT_CONTAINING_TICK_BORNE_ENCEPHALITIS_VIRUS_ANTIGEN_MEDICINAL_PRODUCT("Vaccine product containing Tick-borne encephalitis virus antigen (medicinal product)", "", "SNOMED Clinical Terms", "836403007"),

  VACCINE_PRODUCT_CONTAINING_MEASLES_MORBILLIVIRUS_AND_MUMPS_ORTHORUBULAVIRUS_AND_RUBELLA_VIRUS_ANTIGENS_MEDICINAL_PRODUCT("Vaccine product containing Measles morbillivirus and Mumps orthorubulavirus and Rubella virus antigens (medicinal product)", "", "SNOMED Clinical Terms", "836494009"),

  TYPHUS_ORAL_LEBEND_ABGESCHWAECHT("Typhus, oral, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07AP01"),

  ROETELN_LEBEND_ABGESCHWAECHT("Röteln, lebend abgeschwächt", "", "SNOMED Clinical Terms", "J07BJ01"),

  TETANUS_TOXOID_KOMBINATIONEN_MIT_TETANUS_IMMUNGLOBULIN("Tetanus-Toxoid, Kombinationen mit Tetanus-Immunglobulin", "", "SNOMED Clinical Terms", "J07AM52"),

  TETANUS_VACCINE("Tetanus vaccine", "", "SNOMED Clinical Terms", "333621002");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ImpfstoffDefiningCode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public static Map<String, ImpfstoffDefiningCode> getCodesAsMap(){
    Map<String, ImpfstoffDefiningCode> impfstoffDefiningCodeHashMap = new HashMap<>();
    for (ImpfstoffDefiningCode impfstoffDefiningCode : ImpfstoffDefiningCode.values()) {
      impfstoffDefiningCodeHashMap.put(impfstoffDefiningCode.getCode(), impfstoffDefiningCode);
    }
    return impfstoffDefiningCodeHashMap;
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
