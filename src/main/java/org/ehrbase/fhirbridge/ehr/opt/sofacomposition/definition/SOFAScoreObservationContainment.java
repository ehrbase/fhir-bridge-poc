package org.ehrbase.fhirbridge.ehr.opt.sofacomposition.definition;

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

public class SOFAScoreObservationContainment extends Containment {
  public SelectAqlField<SOFAScoreObservation> S_O_F_A_SCORE_OBSERVATION =
      new AqlFieldImp<SOFAScoreObservation>(
          SOFAScoreObservation.class, "", "SOFAScoreObservation", SOFAScoreObservation.class, this);

  public SelectAqlField<DvOrdinal> ATEMTATIGKEIT =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0004]/value",
          "atemtatigkeit",
          DvOrdinal.class,
          this);

  public SelectAqlField<DvOrdinal> ZENTRALES_NERVENSYSTEM =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0005]/value",
          "zentralesNervensystem",
          DvOrdinal.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          SOFAScoreObservation.class,
          "/protocol[at0014]/items[at0015]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          SOFAScoreObservation.class, "/language", "language", Language.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<DvOrdinal> HERZ_KREISLAUF_SYSTEM =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0006]/value",
          "herzKreislaufSystem",
          DvOrdinal.class,
          this);

  public SelectAqlField<DvOrdinal> LEBERFUNKTION =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0007]/value",
          "leberfunktion",
          DvOrdinal.class,
          this);

  public SelectAqlField<DvOrdinal> BLUTGERINNUNG =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0008]/value",
          "blutgerinnung",
          DvOrdinal.class,
          this);

  public SelectAqlField<DvOrdinal> NIERENFUNKTION =
      new AqlFieldImp<DvOrdinal>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0009]/value",
          "nierenfunktion",
          DvOrdinal.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          SOFAScoreObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          SOFAScoreObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<Long> SOFA_SCORE_MAGNITUDE =
      new AqlFieldImp<Long>(
          SOFAScoreObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0010]/value|magnitude",
          "sofaScoreMagnitude",
          Long.class,
          this);

  private SOFAScoreObservationContainment() {
    super("openEHR-EHR-OBSERVATION.sofa_score.v0");
  }

  public static SOFAScoreObservationContainment getInstance() {
    return new SOFAScoreObservationContainment();
  }
}
