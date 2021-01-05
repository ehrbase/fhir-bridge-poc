package org.ehrbase.fhirbridge.ehr.opt.symptomcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class UnbekanntesSymptomEvaluationContainment extends Containment {
  public SelectAqlField<UnbekanntesSymptomEvaluation> UNBEKANNTES_SYMPTOM_EVALUATION =
      new AqlFieldImp<UnbekanntesSymptomEvaluation>(
          UnbekanntesSymptomEvaluation.class,
          "",
          "UnbekanntesSymptomEvaluation",
          UnbekanntesSymptomEvaluation.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          UnbekanntesSymptomEvaluation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<ProblemDiagnoseDefiningcode> UNBEKANNTES_SYMPTOM_DEFININGCODE =
      new AqlFieldImp<ProblemDiagnoseDefiningcode>(
          UnbekanntesSymptomEvaluation.class,
          "/data[at0001]/items[at0002]/value|defining_code",
          "unbekanntesSymptomDefiningcode",
          ProblemDiagnoseDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          UnbekanntesSymptomEvaluation.class,
          "/protocol[at0003]/items[at0006]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          UnbekanntesSymptomEvaluation.class, "/language", "language", Language.class, this);

  public ListSelectAqlField<UnbekanntesSymptomAussageUberDieFehlendeInformationElement>
      AUSSAGE_UBER_DIE_FEHLENDE_INFORMATION =
          new ListAqlFieldImp<UnbekanntesSymptomAussageUberDieFehlendeInformationElement>(
              UnbekanntesSymptomEvaluation.class,
              "/data[at0001]/items[at0005]",
              "aussageUberDieFehlendeInformation",
              UnbekanntesSymptomAussageUberDieFehlendeInformationElement.class,
              this);

  private UnbekanntesSymptomEvaluationContainment() {
    super("openEHR-EHR-EVALUATION.absence.v2");
  }

  public static UnbekanntesSymptomEvaluationContainment getInstance() {
    return new UnbekanntesSymptomEvaluationContainment();
  }
}
