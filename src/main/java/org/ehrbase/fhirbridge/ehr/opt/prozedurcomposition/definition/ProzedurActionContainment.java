package org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.fhirbridge.ehr.opt.shareddefinition.TransitionDefiningcode;

public class ProzedurActionContainment extends Containment {
  public SelectAqlField<ProzedurAction> PROZEDUR_ACTION =
      new AqlFieldImp<ProzedurAction>(
          ProzedurAction.class, "", "ProzedurAction", ProzedurAction.class, this);

  public SelectAqlField<TemporalAccessor> TIME_VALUE =
      new AqlFieldImp<TemporalAccessor>(
          ProzedurAction.class, "/time|value", "timeValue", TemporalAccessor.class, this);

  public SelectAqlField<String> FREITEXTBESCHREIBUNG_VALUE =
      new AqlFieldImp<String>(
          ProzedurAction.class,
          "/description[at0001]/items[at0049]/value|value",
          "freitextbeschreibungValue",
          String.class,
          this);

  public ListSelectAqlField<ProzedurDurchfuhrungsabsichtElement> DURCHFUHRUNGSABSICHT =
      new ListAqlFieldImp<ProzedurDurchfuhrungsabsichtElement>(
          ProzedurAction.class,
          "/description[at0001]/items[at0014]",
          "durchfuhrungsabsicht",
          ProzedurDurchfuhrungsabsichtElement.class,
          this);

  public ListSelectAqlField<Cluster> EMPFANGER =
      new ListAqlFieldImp<Cluster>(
          ProzedurAction.class,
          "/protocol[at0053]/items[at0057]",
          "empfanger",
          Cluster.class,
          this);

  public SelectAqlField<String> NAME_DER_PROZEDUR_VALUE =
      new AqlFieldImp<String>(
          ProzedurAction.class,
          "/description[at0001]/items[at0002]/value|value",
          "nameDerProzedurValue",
          String.class,
          this);

  public ListSelectAqlField<Cluster> MULTIMEDIA =
      new ListAqlFieldImp<Cluster>(
          ProzedurAction.class,
          "/description[at0001]/items[at0062]",
          "multimedia",
          Cluster.class,
          this);

  public SelectAqlField<TransitionDefiningcode> TRANSITION_DEFININGCODE =
      new AqlFieldImp<TransitionDefiningcode>(
          ProzedurAction.class,
          "/ism_transition[at0043]/transition|defining_code",
          "transitionDefiningcode",
          TransitionDefiningcode.class,
          this);

  public ListSelectAqlField<Cluster> ERWEITERUNG =
      new ListAqlFieldImp<Cluster>(
          ProzedurAction.class,
          "/protocol[at0053]/items[at0064]",
          "erweiterung",
          Cluster.class,
          this);

  public ListSelectAqlField<DetailsZurKorperstelleCluster> DETAILS_ZUR_KORPERSTELLE =
      new ListAqlFieldImp<DetailsZurKorperstelleCluster>(
          ProzedurAction.class,
          "/description[at0001]/items[openEHR-EHR-CLUSTER.anatomical_location.v1 and name/value='Details zur Körperstelle']",
          "detailsZurKorperstelle",
          DetailsZurKorperstelleCluster.class,
          this);

  public SelectAqlField<org.ehrbase.fhirbridge.ehr.opt.shareddefinition.ProzedurBeendetDefiningcode>
      PROZEDUR_BEENDET_DEFININGCODE =
          new AqlFieldImp<
              org.ehrbase.fhirbridge.ehr.opt.shareddefinition.ProzedurBeendetDefiningcode>(
              ProzedurAction.class,
              "/ism_transition[at0043]/current_state|defining_code",
              "prozedurBeendetDefiningcode",
              org.ehrbase.fhirbridge.ehr.opt.shareddefinition.ProzedurBeendetDefiningcode.class,
              this);

  public SelectAqlField<ProzedurBeendetDefiningcode> PROZEDUR_BEENDET_DEFININGCODE_CAREFLOW_STEP =
      new AqlFieldImp<ProzedurBeendetDefiningcode>(
          ProzedurAction.class,
          "/ism_transition[at0043]/careflow_step|defining_code",
          "prozedurBeendetDefiningcodeCareflowStep",
          ProzedurBeendetDefiningcode.class,
          this);

  public SelectAqlField<Cluster> ANTRAGSTELLER =
      new AqlFieldImp<Cluster>(
          ProzedurAction.class,
          "/protocol[at0053]/items[at0055]",
          "antragsteller",
          Cluster.class,
          this);

  private ProzedurActionContainment() {
    super("openEHR-EHR-ACTION.procedure.v1");
  }

  public static ProzedurActionContainment getInstance() {
    return new ProzedurActionContainment();
  }
}
