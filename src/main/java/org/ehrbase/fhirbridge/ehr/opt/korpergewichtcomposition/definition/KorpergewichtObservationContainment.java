package org.ehrbase.fhirbridge.ehr.opt.korpergewichtcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class KorpergewichtObservationContainment extends Containment {
  public SelectAqlField<KorpergewichtObservation> KORPERGEWICHT_OBSERVATION =
      new AqlFieldImp<KorpergewichtObservation>(
          KorpergewichtObservation.class,
          "",
          "KorpergewichtObservation",
          KorpergewichtObservation.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          KorpergewichtObservation.class,
          "/protocol[at0015]/items[at0027]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          KorpergewichtObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KorpergewichtObservation.class,
          "/data[at0002]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<Cluster> GERAT =
      new AqlFieldImp<Cluster>(
          KorpergewichtObservation.class,
          "/protocol[at0015]/items[at0020]",
          "gerat",
          Cluster.class,
          this);

  public SelectAqlField<Double> GEWICHT_MAGNITUDE =
      new AqlFieldImp<Double>(
          KorpergewichtObservation.class,
          "/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|magnitude",
          "gewichtMagnitude",
          Double.class,
          this);

  public SelectAqlField<String> GEWICHT_UNITS =
      new AqlFieldImp<String>(
          KorpergewichtObservation.class,
          "/data[at0002]/events[at0003]/data[at0001]/items[at0004]/value|units",
          "gewichtUnits",
          String.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          KorpergewichtObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KorpergewichtObservation.class,
          "/data[at0002]/events[at0003]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  private KorpergewichtObservationContainment() {
    super("openEHR-EHR-OBSERVATION.body_weight.v2");
  }

  public static KorpergewichtObservationContainment getInstance() {
    return new KorpergewichtObservationContainment();
  }
}
