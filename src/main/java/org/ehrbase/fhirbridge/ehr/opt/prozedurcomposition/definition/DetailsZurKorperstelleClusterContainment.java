package org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class DetailsZurKorperstelleClusterContainment extends Containment {
  public SelectAqlField<DetailsZurKorperstelleCluster> DETAILS_ZUR_KORPERSTELLE_CLUSTER =
      new AqlFieldImp<DetailsZurKorperstelleCluster>(
          DetailsZurKorperstelleCluster.class,
          "",
          "DetailsZurKorperstelleCluster",
          DetailsZurKorperstelleCluster.class,
          this);

  public ListSelectAqlField<Cluster> ALTERNATIVE_STRUKTUR =
      new ListAqlFieldImp<Cluster>(
          DetailsZurKorperstelleCluster.class,
          "/items[at0053]",
          "alternativeStruktur",
          Cluster.class,
          this);

  public SelectAqlField<String> NAME_DER_KORPERSTELLE_VALUE =
      new AqlFieldImp<String>(
          DetailsZurKorperstelleCluster.class,
          "/items[at0001]/value|value",
          "nameDerKorperstelleValue",
          String.class,
          this);

  public ListSelectAqlField<Cluster> MULTIMEDIALE_DARSTELLUNG =
      new ListAqlFieldImp<Cluster>(
          DetailsZurKorperstelleCluster.class,
          "/items[at0054]",
          "multimedialeDarstellung",
          Cluster.class,
          this);

  public SelectAqlField<LateralitatDefiningcode> LATERALITAT_DEFININGCODE =
      new AqlFieldImp<LateralitatDefiningcode>(
          DetailsZurKorperstelleCluster.class,
          "/items[at0002]/value|defining_code",
          "lateralitatDefiningcode",
          LateralitatDefiningcode.class,
          this);

  private DetailsZurKorperstelleClusterContainment() {
    super("openEHR-EHR-CLUSTER.anatomical_location.v1");
  }

  public static DetailsZurKorperstelleClusterContainment getInstance() {
    return new DetailsZurKorperstelleClusterContainment();
  }
}
