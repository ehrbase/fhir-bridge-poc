package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.Language;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;
import org.ehrbase.client.classgenerator.shareddefinition.Transition;

public class ImpfungActionContainment extends Containment {
  public SelectAqlField<ImpfungAction> IMPFUNG_ACTION = new AqlFieldImp<ImpfungAction>(ImpfungAction.class, "", "ImpfungAction", ImpfungAction.class, this);

  public SelectAqlField<ImpfstoffDefiningCode> IMPFSTOFF_DEFINING_CODE = new AqlFieldImp<ImpfstoffDefiningCode>(ImpfungAction.class, "/description[at0017]/items[at0020]/value|defining_code", "impfstoffDefiningCode", ImpfstoffDefiningCode.class, this);

  public SelectAqlField<NullFlavour> IMPFSTOFF_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ImpfungAction.class, "/description[at0017]/items[at0020]/null_flavour|defining_code", "impfstoffNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<Cluster> ARZNEIMITTELDETAILS = new AqlFieldImp<Cluster>(ImpfungAction.class, "/description[at0017]/items[at0104]", "arzneimitteldetails", Cluster.class, this);

  public SelectAqlField<VerabreichteDosenCluster> VERABREICHTE_DOSEN = new AqlFieldImp<VerabreichteDosenCluster>(ImpfungAction.class, "/description[at0017]/items[openEHR-EHR-CLUSTER.dosage.v1]", "verabreichteDosen", VerabreichteDosenCluster.class, this);

  public ListSelectAqlField<ImpfungImpfungGegenElement> IMPFUNG_GEGEN = new ListAqlFieldImp<ImpfungImpfungGegenElement>(ImpfungAction.class, "/description[at0017]/items[at0021]", "impfungGegen", ImpfungImpfungGegenElement.class, this);

  public ListSelectAqlField<Cluster> ZUSAETZLICHE_DETAILS = new ListAqlFieldImp<Cluster>(ImpfungAction.class, "/description[at0017]/items[at0053]", "zusaetzlicheDetails", Cluster.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(ImpfungAction.class, "/protocol[at0030]/items[at0085]", "erweiterung", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(ImpfungAction.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(ImpfungAction.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(ImpfungAction.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE = new AqlFieldImp<TemporalAccessor>(ImpfungAction.class, "/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<CareflowStepDefiningCode> CAREFLOW_STEP_DEFINING_CODE = new AqlFieldImp<CareflowStepDefiningCode>(ImpfungAction.class, "/ism_transition/careflow_step|defining_code", "careflowStepDefiningCode", CareflowStepDefiningCode.class, this);

  public SelectAqlField<CurrentStateDefiningCode> CURRENT_STATE_DEFINING_CODE = new AqlFieldImp<CurrentStateDefiningCode>(ImpfungAction.class, "/ism_transition/current_state|defining_code", "currentStateDefiningCode", CurrentStateDefiningCode.class, this);

  public SelectAqlField<Transition> TRANSITION_DEFINING_CODE = new AqlFieldImp<Transition>(ImpfungAction.class, "/ism_transition/transition|defining_code", "transitionDefiningCode", Transition.class, this);

  private ImpfungActionContainment() {
    super("openEHR-EHR-ACTION.medication.v1");
  }

  public static ImpfungActionContainment getInstance() {
    return new ImpfungActionContainment();
  }
}
