package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import java.lang.String;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.support.identification.TerminologyId;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum NameDerKoerperstelleDefiningCode implements EnumValueSet {

    STRUCTURE_OF_POSTERIOR_NASOPHARYNX_BODY_STRUCTURE("Structure of posterior nasopharynx (body structure)", "", "SNOMED CT", "367592002"),

    STRUCTURE_OF_POSTERIOR_WALL_OF_OROPHARYNX_BODY_STRUCTURE("Structure of posterior wall of oropharynx (body_structure)", "", "SNOMED CT", "12999009"),

    STRUCTURE_OF_INTERNAL_PART_OF_MOUTH("Structure of internal part of mouth (body structure)", "", "SNOMED CT", "700016008"),

    TRACHEAL_STRUCTURE_BODY_STRUCTURE("Tracheal structure (body structure)", "", "SNOMED CT", "44567001"),

    LOWER_RESPIRATORY_TRACT_STRUCTURE_BODY_STRUCTURE("Lower respiratory tract structure (body structure)", "", "SNOMED CT", "82094008"),

    TRACHEOBRONCHIAL_STRUCTURE_BODY_STRUCTURE("Tracheobronchial structure (body structure)", "", "SNOMED CT", "91724006"),

    BRONCHIAL_STRUCTURE_BODY_STRUCTURE("Bronchial structure (body structure)", "", "SNOMED CT", "955009"),

    PULMONARY_ALVEOLAR_STRUCTURE_BODY_STRUCTURE("Pulmonary alveolar structure (body structure)", "", "SNOMED CT", "113253006");

    private String value;

    private String description;

    private String terminologyId;

    private String code;

    NameDerKoerperstelleDefiningCode(String value, String description, String terminologyId, String code) {
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


    public DvCodedText toDvCodedText(){
        DvCodedText dvCodedText = new DvCodedText();
        CodePhrase codePhrase = new CodePhrase();
        codePhrase.setCodeString(code);
        codePhrase.setTerminologyId(new TerminologyId(terminologyId));
        dvCodedText.setDefiningCode(codePhrase);
        dvCodedText.setValue(value);
        return dvCodedText;
    }


 }
