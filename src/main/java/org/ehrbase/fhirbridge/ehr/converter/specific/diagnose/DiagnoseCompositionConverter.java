package org.ehrbase.fhirbridge.ehr.converter.specific.diagnose;

import org.ehrbase.fhirbridge.ehr.converter.generic.ConditionToCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.diagnosecomposition.DiagnoseComposition;
import org.hl7.fhir.r4.model.Condition;
import org.springframework.lang.NonNull;

public class DiagnoseCompositionConverter extends ConditionToCompositionConverter<DiagnoseComposition> {

    @Override
    public DiagnoseComposition convertInternal(@NonNull Condition resource) {
        DiagnoseComposition composition = new DiagnoseComposition();
        composition.setProblemDiagnose(new ProblemDiagnoseEvaluationConverter().convert(resource));
        return composition;
    }
}
