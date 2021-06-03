package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class AnatomischeLokalisationClusterContainment extends Containment {
  public SelectAqlField<AnatomischeLokalisationCluster> ANATOMISCHE_LOKALISATION_CLUSTER = new AqlFieldImp<AnatomischeLokalisationCluster>(AnatomischeLokalisationCluster.class, "", "AnatomischeLokalisationCluster", AnatomischeLokalisationCluster.class, this);

  public SelectAqlField<DvCodedText> NAME_DER_KOERPERSTELLE = new AqlFieldImp<DvCodedText>(AnatomischeLokalisationCluster.class, "/items[at0001]/value", "nameDerKoerperstelle", DvCodedText.class, this);

  public SelectAqlField<NullFlavour> NAME_DER_KOERPERSTELLE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(AnatomischeLokalisationCluster.class, "/items[at0001]/null_flavour|defining_code", "nameDerKoerperstelleNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<Cluster> ALTERNATIVE_STRUKTUR = new ListAqlFieldImp<Cluster>(AnatomischeLokalisationCluster.class, "/items[at0053]", "alternativeStruktur", Cluster.class, this);

  public ListSelectAqlField<Cluster> MULTIMEDIALE_DARSTELLUNG = new ListAqlFieldImp<Cluster>(AnatomischeLokalisationCluster.class, "/items[at0054]", "multimedialeDarstellung", Cluster.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(AnatomischeLokalisationCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  private AnatomischeLokalisationClusterContainment() {
    super("openEHR-EHR-CLUSTER.anatomical_location.v1");
  }

  public static AnatomischeLokalisationClusterContainment getInstance() {
    return new AnatomischeLokalisationClusterContainment();
  }
}
