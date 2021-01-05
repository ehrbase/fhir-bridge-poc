package org.ehrbase.fhirbridge.ehr.opt.beatmungswertecomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.quantity.DvProportion;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class EingeatmeterSauerstoffClusterContainment extends Containment {
  public SelectAqlField<EingeatmeterSauerstoffCluster> EINGEATMETER_SAUERSTOFF_CLUSTER =
      new AqlFieldImp<EingeatmeterSauerstoffCluster>(
          EingeatmeterSauerstoffCluster.class,
          "",
          "EingeatmeterSauerstoffCluster",
          EingeatmeterSauerstoffCluster.class,
          this);

  public SelectAqlField<DvProportion> INSPIRATORISCHE_SAUERSTOFFFRAKTION =
      new AqlFieldImp<DvProportion>(
          EingeatmeterSauerstoffCluster.class,
          "/items[at0053]/value",
          "inspiratorischeSauerstofffraktion",
          DvProportion.class,
          this);

  public ListSelectAqlField<Cluster> DETAILS_ZUR_SAUERSTOFFZUFUHR =
      new ListAqlFieldImp<Cluster>(
          EingeatmeterSauerstoffCluster.class,
          "/items[at0058]",
          "detailsZurSauerstoffzufuhr",
          Cluster.class,
          this);

  private EingeatmeterSauerstoffClusterContainment() {
    super("openEHR-EHR-CLUSTER.inspired_oxygen.v1");
  }

  public static EingeatmeterSauerstoffClusterContainment getInstance() {
    return new EingeatmeterSauerstoffClusterContainment();
  }
}
