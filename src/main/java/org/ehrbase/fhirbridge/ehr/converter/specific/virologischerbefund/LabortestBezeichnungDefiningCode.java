package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import java.lang.String;
import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.support.identification.TerminologyId;
import org.ehrbase.client.classgenerator.EnumValueSet;


public enum LabortestBezeichnungDefiningCode implements EnumValueSet {


    DETECTION_OF_VIRUS_PROCEDURE("Detection of virus (procedure)", "", "SNOMED CT", "122442008");

    private String value;

    private String description;

    private String terminologyId;

    private String code;

    LabortestBezeichnungDefiningCode(String value, String description, String terminologyId, String code) {
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
