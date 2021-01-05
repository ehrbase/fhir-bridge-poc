package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class ProLaboranalytClusterContainment extends Containment {
  public SelectAqlField<ProLaboranalytCluster> PRO_LABORANALYT_CLUSTER =
      new AqlFieldImp<ProLaboranalytCluster>(
          ProLaboranalytCluster.class,
          "",
          "ProLaboranalytCluster",
          ProLaboranalytCluster.class,
          this);

  public SelectAqlField<ProLaboranalytErgebnisStatusChoice> ERGEBNIS_STATUS =
      new AqlFieldImp<ProLaboranalytErgebnisStatusChoice>(
          ProLaboranalytCluster.class,
          "/items[at0005]/value",
          "ergebnisStatus",
          ProLaboranalytErgebnisStatusChoice.class,
          this);

  public SelectAqlField<TemporalAccessor> ZEITPUNKT_ERGEBNIS_STATUS_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          ProLaboranalytCluster.class,
          "/items[at0006]/value|value",
          "zeitpunktErgebnisStatusValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<UntersuchterAnalytDefiningcode> UNTERSUCHTER_ANALYT_DEFININGCODE =
      new AqlFieldImp<UntersuchterAnalytDefiningcode>(
          ProLaboranalytCluster.class,
          "/items[at0024]/value|defining_code",
          "untersuchterAnalytDefiningcode",
          UntersuchterAnalytDefiningcode.class,
          this);

  public SelectAqlField<ReferenzbereichsHinweiseDefiningcode>
      REFERENZBEREICHS_HINWEISE_DEFININGCODE =
          new AqlFieldImp<ReferenzbereichsHinweiseDefiningcode>(
              ProLaboranalytCluster.class,
              "/items[at0004]/value|defining_code",
              "referenzbereichsHinweiseDefiningcode",
              ReferenzbereichsHinweiseDefiningcode.class,
              this);

  public SelectAqlField<ProLaboranalytAnalytResultatChoice> ANALYT_RESULTAT =
      new AqlFieldImp<ProLaboranalytAnalytResultatChoice>(
          ProLaboranalytCluster.class,
          "/items[at0001]/value",
          "analytResultat",
          ProLaboranalytAnalytResultatChoice.class,
          this);

  public SelectAqlField<ProLaboranalytProbeChoice> PROBE =
      new AqlFieldImp<ProLaboranalytProbeChoice>(
          ProLaboranalytCluster.class,
          "/items[at0026]/value",
          "probe",
          ProLaboranalytProbeChoice.class,
          this);

  public SelectAqlField<String> PROBE_VALUE =
      new AqlFieldImp<String>(
          ProLaboranalytCluster.class,
          "/items[at0026]/name|value",
          "probeValue",
          String.class,
          this);

  public SelectAqlField<String> REFERENZBEREICHS_HINWEISE_VALUE =
      new AqlFieldImp<String>(
          ProLaboranalytCluster.class,
          "/items[at0004]/name|value",
          "referenzbereichsHinweiseValue",
          String.class,
          this);

  public SelectAqlField<TemporalAccessor> ZEITPUNKT_VALIDATION_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          ProLaboranalytCluster.class,
          "/items[at0025]/value|value",
          "zeitpunktValidationValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Cluster> ANALYSEERGEBNIS_DETAILS =
      new ListAqlFieldImp<Cluster>(
          ProLaboranalytCluster.class,
          "/items[at0014]",
          "analyseergebnisDetails",
          Cluster.class,
          this);

  public ListSelectAqlField<ProLaboranalytKommentarElement> KOMMENTAR =
      new ListAqlFieldImp<ProLaboranalytKommentarElement>(
          ProLaboranalytCluster.class,
          "/items[at0003]",
          "kommentar",
          ProLaboranalytKommentarElement.class,
          this);

  public SelectAqlField<String> ANALYT_RESULTAT_VALUE =
      new AqlFieldImp<String>(
          ProLaboranalytCluster.class,
          "/items[at0001]/name|value",
          "analytResultatValue",
          String.class,
          this);

  private ProLaboranalytClusterContainment() {
    super("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1");
  }

  public static ProLaboranalytClusterContainment getInstance() {
    return new ProLaboranalytClusterContainment();
  }
}
