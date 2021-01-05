package org.ehrbase.fhirbridge.ehr.opt.herzfrequenzcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class HerzfrequenzObservationContainment extends Containment {
  public SelectAqlField<HerzfrequenzObservation> HERZFREQUENZ_OBSERVATION =
      new AqlFieldImp<HerzfrequenzObservation>(
          HerzfrequenzObservation.class,
          "",
          "HerzfrequenzObservation",
          HerzfrequenzObservation.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          HerzfrequenzObservation.class,
          "/protocol[at0010]/items[at1056]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          HerzfrequenzObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<Cluster> GERAT =
      new AqlFieldImp<Cluster>(
          HerzfrequenzObservation.class,
          "/protocol[at0010]/items[at1013]",
          "gerat",
          Cluster.class,
          this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          HerzfrequenzObservation.class,
          "/data[at0002]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public ListSelectAqlField<Cluster> ANSTRENGUNG =
      new ListAqlFieldImp<Cluster>(
          HerzfrequenzObservation.class,
          "/data[at0002]/events[at0003]/state[at0012]/items[at1017]",
          "anstrengung",
          Cluster.class,
          this);

  public SelectAqlField<Double> FREQUENZ_MAGNITUDE =
      new AqlFieldImp<Double>(
          HerzfrequenzObservation.class,
          "/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|magnitude",
          "frequenzMagnitude",
          Double.class,
          this);

  public SelectAqlField<String> FREQUENZ_UNITS =
      new AqlFieldImp<String>(
          HerzfrequenzObservation.class,
          "/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|units",
          "frequenzUnits",
          String.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          HerzfrequenzObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          HerzfrequenzObservation.class,
          "/data[at0002]/events[at0003]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  private HerzfrequenzObservationContainment() {
    super("openEHR-EHR-OBSERVATION.pulse.v2");
  }

  public static HerzfrequenzObservationContainment getInstance() {
    return new HerzfrequenzObservationContainment();
  }
}
