package org.ehrbase.fhirbridge.ehr.opt.atemfrequenzcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class AtemfrequenzObservationContainment extends Containment {
  public SelectAqlField<AtemfrequenzObservation> ATEMFREQUENZ_OBSERVATION =
      new AqlFieldImp<AtemfrequenzObservation>(
          AtemfrequenzObservation.class,
          "",
          "AtemfrequenzObservation",
          AtemfrequenzObservation.class,
          this);

  public SelectAqlField<Double> MESSWERT_MAGNITUDE =
      new AqlFieldImp<Double>(
          AtemfrequenzObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|magnitude",
          "messwertMagnitude",
          Double.class,
          this);

  public SelectAqlField<String> MESSWERT_UNITS =
      new AqlFieldImp<String>(
          AtemfrequenzObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value|units",
          "messwertUnits",
          String.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          AtemfrequenzObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          AtemfrequenzObservation.class,
          "/data[at0001]/events[at0002]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<Cluster> ANWENDUNG =
      new AqlFieldImp<Cluster>(
          AtemfrequenzObservation.class,
          "/data[at0001]/events[at0002]/state[at0022]/items[at0037]",
          "anwendung",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          AtemfrequenzObservation.class,
          "/protocol[at0057]/items[at0058]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          AtemfrequenzObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          AtemfrequenzObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<Cluster> INSPIRIERTER_SAUERSTOFF =
      new AqlFieldImp<Cluster>(
          AtemfrequenzObservation.class,
          "/data[at0001]/events[at0002]/state[at0022]/items[at0055]",
          "inspirierterSauerstoff",
          Cluster.class,
          this);

  private AtemfrequenzObservationContainment() {
    super("openEHR-EHR-OBSERVATION.respiration.v2");
  }

  public static AtemfrequenzObservationContainment getInstance() {
    return new AtemfrequenzObservationContainment();
  }
}
