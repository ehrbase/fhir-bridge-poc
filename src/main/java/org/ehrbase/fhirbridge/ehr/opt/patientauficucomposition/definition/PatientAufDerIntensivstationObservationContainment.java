package org.ehrbase.fhirbridge.ehr.opt.patientauficucomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.Language;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.WurdeDieAktivitatDurchgefuhrtDefiningcode;

public class PatientAufDerIntensivstationObservationContainment extends Containment {
  public SelectAqlField<PatientAufDerIntensivstationObservation>
      PATIENT_AUF_DER_INTENSIVSTATION_OBSERVATION =
          new AqlFieldImp<PatientAufDerIntensivstationObservation>(
              PatientAufDerIntensivstationObservation.class,
              "",
              "PatientAufDerIntensivstationObservation",
              PatientAufDerIntensivstationObservation.class,
              this);

  public SelectAqlField<Language> LANGUAGE =
      new AqlFieldImp<Language>(
          PatientAufDerIntensivstationObservation.class,
          "/language",
          "language",
          Language.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          PatientAufDerIntensivstationObservation.class,
          "/protocol[at0007]/items[at0021]",
          "erweiterung",
          Cluster.class,
          this);

  public SelectAqlField<String> NAME_DER_AKTIVITAT_VALUE =
      new AqlFieldImp<String>(
          PatientAufDerIntensivstationObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0004]/value|value",
          "nameDerAktivitatValue",
          String.class,
          this);

  public SelectAqlField<WurdeDieAktivitatDurchgefuhrtDefiningcode>
      WURDE_DIE_AKTIVITAT_DURCHGEFUHRT_DEFININGCODE =
          new AqlFieldImp<WurdeDieAktivitatDurchgefuhrtDefiningcode>(
              PatientAufDerIntensivstationObservation.class,
              "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/value|defining_code",
              "wurdeDieAktivitatDurchgefuhrtDefiningcode",
              WurdeDieAktivitatDurchgefuhrtDefiningcode.class,
              this);

  public ListSelectAqlField<Cluster> DETAILLIERTE_ANGABEN_ZUR_AKTIVITAT =
      new ListAqlFieldImp<Cluster>(
          PatientAufDerIntensivstationObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0036]",
          "detaillierteAngabenZurAktivitat",
          Cluster.class,
          this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          PatientAufDerIntensivstationObservation.class,
          "/data[at0001]/events[at0002]/time|value",
          "timeValue",
          TemporalAccessor.class,
          this);

  public SelectAqlField<String> WURDE_DIE_AKTIVITAT_DURCHGEFUHRT_VALUE =
      new AqlFieldImp<String>(
          PatientAufDerIntensivstationObservation.class,
          "/data[at0001]/events[at0002]/data[at0003]/items[at0022]/items[at0005]/name|value",
          "wurdeDieAktivitatDurchgefuhrtValue",
          String.class,
          this);

  public SelectAqlField<PartyProxy> SUBJECT =
      new AqlFieldImp<PartyProxy>(
          PatientAufDerIntensivstationObservation.class,
          "/subject",
          "subject",
          PartyProxy.class,
          this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          PatientAufDerIntensivstationObservation.class,
          "/data[at0001]/origin|value",
          "originValue",
          TemporalAccessor.class,
          this);

  private PatientAufDerIntensivstationObservationContainment() {
    super("openEHR-EHR-OBSERVATION.management_screening.v0");
  }

  public static PatientAufDerIntensivstationObservationContainment getInstance() {
    return new PatientAufDerIntensivstationObservationContainment();
  }
}
