package org.ehrbase.fhirbridge.ehr.opt.klinischefrailtyskalacomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.quantity.DvOrdinal;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;

public class KlinischeFrailtySkalaCfsObservationContainment extends Containment {
  public SelectAqlField<KlinischeFrailtySkalaCfsObservation>
      KLINISCHE_FRAILTY_SKALA_CFS_OBSERVATION =
          new AqlFieldImp<KlinischeFrailtySkalaCfsObservation>(
              KlinischeFrailtySkalaCfsObservation.class,
              "",
              "KlinischeFrailtySkalaCfsObservation",
              KlinischeFrailtySkalaCfsObservation.class,
              this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KlinischeFrailtySkalaCfsObservation.class,
          "/data[at0001]/events[at0002]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<DvOrdinal> BEURTEILUNG =
      new AqlFieldImp<DvOrdinal>(
          KlinischeFrailtySkalaCfsObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value",
          "beurteilung",
          DvOrdinal.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNGEN =
      new ListAqlFieldImp<Cluster>(
          KlinischeFrailtySkalaCfsObservation.class,
          "/protocol[at0014]/items[at0015]",
          "erweiterungen",
          Cluster.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          KlinischeFrailtySkalaCfsObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          KlinischeFrailtySkalaCfsObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          KlinischeFrailtySkalaCfsObservation.class, "/language", "language", Language.class, this);

  private KlinischeFrailtySkalaCfsObservationContainment() {
    super("openEHR-EHR-OBSERVATION.clinical_frailty_scale.v1");
  }

  public static KlinischeFrailtySkalaCfsObservationContainment getInstance() {
    return new KlinischeFrailtySkalaCfsObservationContainment();
  }
}
