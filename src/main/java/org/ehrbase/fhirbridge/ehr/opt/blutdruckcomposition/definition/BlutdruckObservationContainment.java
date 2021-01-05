package org.ehrbase.fhirbridge.ehr.opt.blutdruckcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class BlutdruckObservationContainment extends Containment {
  public SelectAqlField<BlutdruckObservation> BLUTDRUCK_OBSERVATION =
      new AqlFieldImp<BlutdruckObservation>(
          BlutdruckObservation.class, "", "BlutdruckObservation", BlutdruckObservation.class, this);

  public SelectAqlField<Double> SYSTOLISCH_MAGNITUDE =
      new AqlFieldImp<Double>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value|magnitude",
          "systolischMagnitude",
          Double.class,
          this);

  public SelectAqlField<String> SYSTOLISCH_UNITS =
      new AqlFieldImp<String>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/data[at0003]/items[at0004]/value|units",
          "systolischUnits",
          String.class,
          this);

  public SelectAqlField<Cluster> ANSTRENGUNG =
      new AqlFieldImp<Cluster>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/state[at0007]/items[at1030]",
          "anstrengung",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> STRUKTURIERTE_STELLE_DER_MESSUNG =
      new ListAqlFieldImp<Cluster>(
          BlutdruckObservation.class,
          "/protocol[at0011]/items[at1057]",
          "strukturierteStelleDerMessung",
          Cluster.class,
          this);

  public SelectAqlField<Cluster> GERAT =
      new AqlFieldImp<Cluster>(
          BlutdruckObservation.class,
          "/protocol[at0011]/items[at1025]",
          "gerat",
          Cluster.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          BlutdruckObservation.class,
          "/protocol[at0011]/items[at1058]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<Double> DIASTOLISCH_MAGNITUDE =
      new AqlFieldImp<Double>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/data[at0003]/items[at0005]/value|magnitude",
          "diastolischMagnitude",
          Double.class,
          this);

  public SelectAqlField<String> DIASTOLISCH_UNITS =
      new AqlFieldImp<String>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/data[at0003]/items[at0005]/value|units",
          "diastolischUnits",
          String.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          BlutdruckObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          BlutdruckObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          BlutdruckObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          BlutdruckObservation.class,
          "/data[at0001]/events[at0006]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  private BlutdruckObservationContainment() {
    super("openEHR-EHR-OBSERVATION.blood_pressure.v2");
  }

  public static BlutdruckObservationContainment getInstance() {
    return new BlutdruckObservationContainment();
  }
}
