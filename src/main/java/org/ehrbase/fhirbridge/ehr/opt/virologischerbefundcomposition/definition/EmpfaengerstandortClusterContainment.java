package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Boolean;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class EmpfaengerstandortClusterContainment extends Containment {
  public SelectAqlField<EmpfaengerstandortCluster> EMPFAENGERSTANDORT_CLUSTER = new AqlFieldImp<EmpfaengerstandortCluster>(EmpfaengerstandortCluster.class, "", "EmpfaengerstandortCluster", EmpfaengerstandortCluster.class, this);

  public SelectAqlField<String> TYP_VALUE = new AqlFieldImp<String>(EmpfaengerstandortCluster.class, "/items[at0051]/value|value", "typValue", String.class, this);

  public SelectAqlField<NullFlavour> TYP_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(EmpfaengerstandortCluster.class, "/items[at0051]/null_flavour|defining_code", "typNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<String> ORGANISATIONSSCHLUESSEL_VALUE = new AqlFieldImp<String>(EmpfaengerstandortCluster.class, "/items[at0024]/value|value", "organisationsschluesselValue", String.class, this);

  public SelectAqlField<NullFlavour> ORGANISATIONSSCHLUESSEL_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(EmpfaengerstandortCluster.class, "/items[at0024]/null_flavour|defining_code", "organisationsschluesselNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<String> NAME_VALUE = new AqlFieldImp<String>(EmpfaengerstandortCluster.class, "/items[at0052]/value|value", "nameValue", String.class, this);

  public SelectAqlField<NullFlavour> NAME_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(EmpfaengerstandortCluster.class, "/items[at0052]/null_flavour|defining_code", "nameNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<Boolean> AKTIV_INAKTIV_VALUE = new AqlFieldImp<Boolean>(EmpfaengerstandortCluster.class, "/items[at0050]/value|value", "aktivInaktivValue", Boolean.class, this);

  public SelectAqlField<NullFlavour> AKTIV_INAKTIV_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(EmpfaengerstandortCluster.class, "/items[at0050]/null_flavour|defining_code", "aktivInaktivNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<String> ZUSAETZLICHE_BESCHREIBUNG_VALUE = new AqlFieldImp<String>(EmpfaengerstandortCluster.class, "/items[at0046]/value|value", "zusaetzlicheBeschreibungValue", String.class, this);

  public SelectAqlField<NullFlavour> ZUSAETZLICHE_BESCHREIBUNG_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(EmpfaengerstandortCluster.class, "/items[at0046]/null_flavour|defining_code", "zusaetzlicheBeschreibungNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> DETAILS = new ListAqlFieldImp<Cluster>(EmpfaengerstandortCluster.class, "/items[at0047]", "details", Cluster.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(EmpfaengerstandortCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private EmpfaengerstandortClusterContainment() {
    super("openEHR-EHR-CLUSTER.organization.v0");
  }

  public static EmpfaengerstandortClusterContainment getInstance() {
    return new EmpfaengerstandortClusterContainment();
  }
}
