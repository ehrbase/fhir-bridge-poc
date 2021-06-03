package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

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

public class BefundObservationContainment extends Containment {
  public SelectAqlField<BefundObservation> BEFUND_OBSERVATION = new AqlFieldImp<BefundObservation>(BefundObservation.class, "", "BefundObservation", BefundObservation.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(BefundObservation.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public SelectAqlField<EmpfaengerstandortCluster> EMPFAENGERSTANDORT = new AqlFieldImp<EmpfaengerstandortCluster>(BefundObservation.class, "/protocol[at0004]/items[openEHR-EHR-CLUSTER.organization.v0]", "empfaengerstandort", EmpfaengerstandortCluster.class, this);

  public ListSelectAqlField<BefundDetailsDerTestanforderungCluster> DETAILS_DER_TESTANFORDERUNG = new ListAqlFieldImp<BefundDetailsDerTestanforderungCluster>(BefundObservation.class, "/protocol[at0004]/items[at0094]", "detailsDerTestanforderung", BefundDetailsDerTestanforderungCluster.class, this);

  public ListSelectAqlField<Cluster> TEST_DETAILS = new ListAqlFieldImp<Cluster>(BefundObservation.class, "/protocol[at0004]/items[at0110]", "testDetails", Cluster.class, this);

  public ListSelectAqlField<Cluster> ERWEITERUNG = new ListAqlFieldImp<Cluster>(BefundObservation.class, "/protocol[at0004]/items[at0117]", "erweiterung", Cluster.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(BefundObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(BefundObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(BefundObservation.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public ListSelectAqlField<BefundJedesEreignisChoice> JEDES_EREIGNIS = new ListAqlFieldImp<BefundJedesEreignisChoice>(BefundObservation.class, "/data[at0001]/events[at0002]", "jedesEreignis", BefundJedesEreignisChoice.class, this);

  private BefundObservationContainment() {
    super("openEHR-EHR-OBSERVATION.laboratory_test_result.v1");
  }

  public static BefundObservationContainment getInstance() {
    return new BefundObservationContainment();
  }
}
