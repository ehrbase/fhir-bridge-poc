package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class VerabreichteDosenClusterContainment extends Containment {
  public SelectAqlField<VerabreichteDosenCluster> VERABREICHTE_DOSEN_CLUSTER = new AqlFieldImp<VerabreichteDosenCluster>(VerabreichteDosenCluster.class, "", "VerabreichteDosenCluster", VerabreichteDosenCluster.class, this);

  public SelectAqlField<Long> DOSIERUNGSREIHENFOLGE_MAGNITUDE = new AqlFieldImp<Long>(VerabreichteDosenCluster.class, "/items[at0164]/value|magnitude", "dosierungsreihenfolgeMagnitude", Long.class, this);

  public SelectAqlField<NullFlavour> DOSIERUNGSREIHENFOLGE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(VerabreichteDosenCluster.class, "/items[at0164]/null_flavour|defining_code", "dosierungsreihenfolgeNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<Double> DOSISMENGE_MAGNITUDE = new AqlFieldImp<Double>(VerabreichteDosenCluster.class, "/items[at0144]/value|magnitude", "dosismengeMagnitude", Double.class, this);

  public SelectAqlField<String> DOSISMENGE_UNITS = new AqlFieldImp<String>(VerabreichteDosenCluster.class, "/items[at0144]/value|units", "dosismengeUnits", String.class, this);

  public SelectAqlField<NullFlavour> DOSISMENGE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(VerabreichteDosenCluster.class, "/items[at0144]/null_flavour|defining_code", "dosismengeNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> TAEGLICHE_VERABREICHUNGSZEITEN = new ListAqlFieldImp<Cluster>(VerabreichteDosenCluster.class, "/items[at0037]", "taeglicheVerabreichungszeiten", Cluster.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(VerabreichteDosenCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private VerabreichteDosenClusterContainment() {
    super("openEHR-EHR-CLUSTER.dosage.v1");
  }

  public static VerabreichteDosenClusterContainment getInstance() {
    return new VerabreichteDosenClusterContainment();
  }
}
