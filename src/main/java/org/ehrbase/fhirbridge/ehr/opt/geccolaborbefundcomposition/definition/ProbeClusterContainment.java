package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvIdentifier;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class ProbeClusterContainment extends Containment {
  public SelectAqlField<ProbeCluster> PROBE_CLUSTER =
      new AqlFieldImp<ProbeCluster>(
          ProbeCluster.class, "", "ProbeCluster", ProbeCluster.class, this);

  public ListSelectAqlField<Cluster> ANGABEN_ZUM_PROBENNEHMER =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0071]", "angabenZumProbennehmer", Cluster.class, this);

  public ListSelectAqlField<Cluster> ANGABEN_ZUM_TRANSPORT =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0093]", "angabenZumTransport", Cluster.class, this);

  public SelectAqlField<DvIdentifier> EXTERNER_IDENTIFIKATOR =
      new AqlFieldImp<DvIdentifier>(
          ProbeCluster.class,
          "/items[at0088]/value",
          "externerIdentifikator",
          DvIdentifier.class,
          this);

  public SelectAqlField<String> PROBENENTNAHMESTELLE_VALUE =
      new AqlFieldImp<String>(
          ProbeCluster.class,
          "/items[at0087]/value|value",
          "probenentnahmestelleValue",
          String.class,
          this);

  public ListSelectAqlField<Cluster> ZUSATZLICHE_ANGABEN_ZUR_PROBENNAHME =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class,
          "/items[at0083]",
          "zusatzlicheAngabenZurProbennahme",
          Cluster.class,
          this);

  public SelectAqlField<String> PROBENENTNAHMEMETHODE_VALUE =
      new AqlFieldImp<String>(
          ProbeCluster.class,
          "/items[at0007]/value|value",
          "probenentnahmemethodeValue",
          String.class,
          this);

  public ListSelectAqlField<Cluster> BEHALTER_DETAILS =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0085]", "behalterDetails", Cluster.class, this);

  public ListSelectAqlField<Cluster> DIGITALE_DARSTELLUNG =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0096]", "digitaleDarstellung", Cluster.class, this);

  public SelectAqlField<TemporalAccessor> ZEITPUNKT_DES_PROBENEINGANGS_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          ProbeCluster.class,
          "/items[at0034]/value|value",
          "zeitpunktDesProbeneingangsValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<ProbeEignungZumTestenChoice> EIGNUNG_ZUM_TESTEN =
      new AqlFieldImp<ProbeEignungZumTestenChoice>(
          ProbeCluster.class,
          "/items[at0041]/value",
          "eignungZumTesten",
          ProbeEignungZumTestenChoice.class,
          this);

  public SelectAqlField<String> KOMMENTAR_VALUE =
      new AqlFieldImp<String>(
          ProbeCluster.class, "/items[at0045]/value|value", "kommentarValue", String.class, this);

  public SelectAqlField<ProbenartDefiningcode> PROBENART_DEFININGCODE =
      new AqlFieldImp<ProbenartDefiningcode>(
          ProbeCluster.class,
          "/items[at0029]/value|defining_code",
          "probenartDefiningcode",
          ProbenartDefiningcode.class,
          this);

  public SelectAqlField<DvIdentifier> LABORPROBENIDENTIFIKATOR =
      new AqlFieldImp<DvIdentifier>(
          ProbeCluster.class,
          "/items[at0001]/value",
          "laborprobenidentifikator",
          DvIdentifier.class,
          this);

  public ListSelectAqlField<Cluster> ANATOMISCHE_PROBENENTNAHMESTELLE =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class,
          "/items[at0013]",
          "anatomischeProbenentnahmestelle",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> ANGABEN_ZUR_VERARBEITUNG =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0068]", "angabenZurVerarbeitung", Cluster.class, this);

  public SelectAqlField<String> PROBENENTNAHMESTELLE_VALUE_NAME =
      new AqlFieldImp<String>(
          ProbeCluster.class,
          "/items[at0087]/name|value",
          "probenentnahmestelleValueName",
          String.class,
          this);

  public ListSelectAqlField<ProbeIdentifikatorDerUbergeordnetenProbeElement>
      IDENTIFIKATOR_DER_UBERGEORDNETEN_PROBE =
          new ListAqlFieldImp<ProbeIdentifikatorDerUbergeordnetenProbeElement>(
              ProbeCluster.class,
              "/items[at0003]",
              "identifikatorDerUbergeordnetenProbe",
              ProbeIdentifikatorDerUbergeordnetenProbeElement.class,
              this);

  public SelectAqlField<DvIdentifier> IDENTIFIKATOR_DES_PROBENNEHMERS =
      new AqlFieldImp<DvIdentifier>(
          ProbeCluster.class,
          "/items[at0070]/value",
          "identifikatorDesProbennehmers",
          DvIdentifier.class,
          this);

  public ListSelectAqlField<Cluster> PHYSISCHE_EIGENSCHAFTEN =
      new ListAqlFieldImp<Cluster>(
          ProbeCluster.class, "/items[at0027]", "physischeEigenschaften", Cluster.class, this);

  public ListSelectAqlField<ProbeProbenentahmebedingungElement> PROBENENTAHMEBEDINGUNG =
      new ListAqlFieldImp<ProbeProbenentahmebedingungElement>(
          ProbeCluster.class,
          "/items[at0008]",
          "probenentahmebedingung",
          ProbeProbenentahmebedingungElement.class,
          this);

  public SelectAqlField<ProbeZeitpunktDerProbenentnahmeChoice> ZEITPUNKT_DER_PROBENENTNAHME =
      new AqlFieldImp<ProbeZeitpunktDerProbenentnahmeChoice>(
          ProbeCluster.class,
          "/items[at0015]/value",
          "zeitpunktDerProbenentnahme",
          ProbeZeitpunktDerProbenentnahmeChoice.class,
          this);

  private ProbeClusterContainment() {
    super("openEHR-EHR-CLUSTER.specimen.v1");
  }

  public static ProbeClusterContainment getInstance() {
    return new ProbeClusterContainment();
  }
}
