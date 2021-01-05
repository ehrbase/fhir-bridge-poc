package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DataValue;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class LaborergebnisObservationContainment extends Containment {
  public SelectAqlField<LaborergebnisObservation> LABORERGEBNIS_OBSERVATION =
      new AqlFieldImp<LaborergebnisObservation>(
          LaborergebnisObservation.class,
          "",
          "LaborergebnisObservation",
          LaborergebnisObservation.class,
          this);

  public ListSelectAqlField<Cluster> TEST_DETAILS =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0110]",
          "testDetails",
          Cluster.class,
          this);

  public ListSelectAqlField<ProbeCluster> PROBE =
      new ListAqlFieldImp<ProbeCluster>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.specimen.v1]",
          "probe",
          ProbeCluster.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          LaborergebnisObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<String> LABORTEST_BEZEICHNUNG_VALUE =
      new AqlFieldImp<String>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0005]/name|value",
          "labortestBezeichnungValue",
          String.class,
          this);

  public SelectAqlField<DataValue> VALUE =
      new AqlFieldImp<DataValue>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0121]/value",
          "value",
          DataValue.class,
          this);

  public SelectAqlField<String> SCHLUSSFOLGERUNG_VALUE =
      new AqlFieldImp<String>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0057]/value|value",
          "schlussfolgerungValue",
          String.class,
          this);

  public SelectAqlField<String> EINSENDENDEN_SYSTEMS_VALUE =
      new AqlFieldImp<String>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0094]/items[at0062]/name|value",
          "einsendendenSystemsValue",
          String.class,
          this);

  public SelectAqlField<Cluster> EINSENDER =
      new AqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0094]/items[at0090]",
          "einsender",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> MULTIMEDIA_DARSTELLUNG =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0118]",
          "multimediaDarstellung",
          Cluster.class,
          this);

  public SelectAqlField<ProbeEinsendendenSystemsChoice> EINSENDENDEN_SYSTEMS =
      new AqlFieldImp<ProbeEinsendendenSystemsChoice>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0094]/items[at0062]/value",
          "einsendendenSystems",
          ProbeEinsendendenSystemsChoice.class,
          this);

  public SelectAqlField<LabortestBezeichnungDefiningcode> LABORTEST_BEZEICHNUNG_DEFININGCODE =
      new AqlFieldImp<LabortestBezeichnungDefiningcode>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0005]/value|defining_code",
          "labortestBezeichnungDefiningcode",
          LabortestBezeichnungDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> STRUKTURIERTE_ERFASSUNG_DER_STORFAKTOREN =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/state[at0112]/items[at0114]",
          "strukturierteErfassungDerStorfaktoren",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> STRUKTURIERTE_TESTDIAGNOSTIK =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0122]",
          "strukturierteTestdiagnostik",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0117]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<ProLaboranalytCluster> PRO_LABORANALYT =
      new AqlFieldImp<ProLaboranalytCluster>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[openEHR-EHR-CLUSTER.laboratory_test_analyte.v1 and name/value='Pro Laboranalyt']",
          "proLaboranalyt",
          ProLaboranalytCluster.class,
          this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          LaborergebnisObservation.class,
          "/data[at0001]/events[at0002]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          LaborergebnisObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          LaborergebnisObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Cluster> VERTEILERLISTE =
      new ListAqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0094]/items[at0035]",
          "verteilerliste",
          Cluster.class,
          this);

  public SelectAqlField<Cluster> LABOR_WELCHES_DEN_UNTERSUCHUNGSAUFTRAG_ANNIMMT =
      new AqlFieldImp<Cluster>(
          LaborergebnisObservation.class,
          "/protocol[at0004]/items[at0017]",
          "laborWelchesDenUntersuchungsauftragAnnimmt",
          Cluster.class,
          this);

  private LaborergebnisObservationContainment() {
    super("openEHR-EHR-OBSERVATION.laboratory_test_result.v1");
  }

  public static LaborergebnisObservationContainment getInstance() {
    return new LaborergebnisObservationContainment();
  }
}
