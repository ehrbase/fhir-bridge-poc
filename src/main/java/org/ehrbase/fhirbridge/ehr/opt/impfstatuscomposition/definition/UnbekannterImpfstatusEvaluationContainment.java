package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class UnbekannterImpfstatusEvaluationContainment extends Containment {
  public SelectAqlField<UnbekannterImpfstatusEvaluation> UNBEKANNTER_IMPFSTATUS_EVALUATION = new AqlFieldImp<UnbekannterImpfstatusEvaluation>(UnbekannterImpfstatusEvaluation.class, "", "UnbekannterImpfstatusEvaluation", UnbekannterImpfstatusEvaluation.class, this);

  public SelectAqlField<AussageUeberAbwesenheitDefiningCode> AUSSAGE_UEBER_ABWESENHEIT_DEFINING_CODE = new AqlFieldImp<AussageUeberAbwesenheitDefiningCode>(UnbekannterImpfstatusEvaluation.class, "/data[at0001]/items[at0002]/value|defining_code", "aussageUeberAbwesenheitDefiningCode", AussageUeberAbwesenheitDefiningCode.class, this);

  public SelectAqlField<NullFlavour> AUSSAGE_UEBER_ABWESENHEIT_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(UnbekannterImpfstatusEvaluation.class, "/data[at0001]/items[at0002]/null_flavour|defining_code", "aussageUeberAbwesenheitNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(UnbekannterImpfstatusEvaluation.class, "/protocol[at0003]/items[at0006]", "erweiterung", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(UnbekannterImpfstatusEvaluation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(UnbekannterImpfstatusEvaluation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(UnbekannterImpfstatusEvaluation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private UnbekannterImpfstatusEvaluationContainment() {
    super("openEHR-EHR-EVALUATION.absence.v2");
  }

  public static UnbekannterImpfstatusEvaluationContainment getInstance() {
    return new UnbekannterImpfstatusEvaluationContainment();
  }
}
