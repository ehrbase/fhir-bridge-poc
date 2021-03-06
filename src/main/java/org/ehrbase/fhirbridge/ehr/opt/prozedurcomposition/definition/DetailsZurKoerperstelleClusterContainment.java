package org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class DetailsZurKoerperstelleClusterContainment extends Containment {
  public SelectAqlField<DetailsZurKoerperstelleCluster> DETAILS_ZUR_KOERPERSTELLE_CLUSTER = new AqlFieldImp<DetailsZurKoerperstelleCluster>(DetailsZurKoerperstelleCluster.class, "", "DetailsZurKoerperstelleCluster", DetailsZurKoerperstelleCluster.class, this);

  public SelectAqlField<String> NAME_DER_KOERPERSTELLE_VALUE = new AqlFieldImp<String>(DetailsZurKoerperstelleCluster.class, "/items[at0001]/value|value", "nameDerKoerperstelleValue", String.class, this);

  public SelectAqlField<NullFlavour> NAME_DER_KOERPERSTELLE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(DetailsZurKoerperstelleCluster.class, "/items[at0001]/null_flavour|defining_code", "nameDerKoerperstelleNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<LateralitaetDefiningCode> LATERALITAET_DEFINING_CODE = new AqlFieldImp<LateralitaetDefiningCode>(DetailsZurKoerperstelleCluster.class, "/items[at0002]/value|defining_code", "lateralitaetDefiningCode", LateralitaetDefiningCode.class, this);

  public SelectAqlField<NullFlavour> LATERALITAET_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(DetailsZurKoerperstelleCluster.class, "/items[at0002]/null_flavour|defining_code", "lateralitaetNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> ALTERNATIVE_STRUKTUR = new ListAqlFieldImp<Cluster>(DetailsZurKoerperstelleCluster.class, "/items[at0053]", "alternativeStruktur", Cluster.class, this);

  public ListSelectAqlField<Cluster> MULTIMEDIALE_DARSTELLUNG = new ListAqlFieldImp<Cluster>(DetailsZurKoerperstelleCluster.class, "/items[at0054]", "multimedialeDarstellung", Cluster.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(DetailsZurKoerperstelleCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private DetailsZurKoerperstelleClusterContainment() {
    super("openEHR-EHR-CLUSTER.anatomical_location.v1");
  }

  public static DetailsZurKoerperstelleClusterContainment getInstance() {
    return new DetailsZurKoerperstelleClusterContainment();
  }
}
