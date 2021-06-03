package org.ehrbase.fhirbridge.ehr.converter.specific.virologischerbefund;

import com.nedap.archie.rm.datatypes.CodePhrase;
import com.nedap.archie.rm.datavalues.DvCodedText;
import com.nedap.archie.rm.support.identification.TerminologyId;
import org.ehrbase.client.classgenerator.EnumValueSet;
import java.lang.String;


public enum VirusnachweistestDefiningCode implements EnumValueSet {

    SARS_COV2_COVID19_RNA_PRESENCE_IN_RESPIRATORY_SPECIMEN_BY_NAA_WITH_PROBE_DETECTION("SARS-CoV-2 (COVID-19) RNA [Presence] in Respiratory specimen by NAA with probe detection", "", "LOINC", "94500-6"),

    SARS_COV2_AG("SARS-CoV-2 Ag", "", "LOINC", "94558-4"),

    SARS_COV2_COVID19_RNA_CYCLE_THRESHOLD_IN_RESPIRATORY_SPECIMEN_BY_NAA_WITH_PROBE_DETECTION("SARS-CoV-2 (COVID-19) RNA [Cycle Threshold #] in Respiratory specimen by NAA with probe detection", "", "LOINC", "94745-7");

    private String value;

    private String description;

    private String terminologyId;

    private String code;

    VirusnachweistestDefiningCode(String value, String description, String terminologyId, String code) {
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
