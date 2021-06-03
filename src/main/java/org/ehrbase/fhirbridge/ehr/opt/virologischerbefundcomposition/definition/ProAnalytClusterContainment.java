package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import com.nedap.archie.rm.datavalues.DvCodedText;
import java.lang.Long;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

public class ProAnalytClusterContainment extends Containment {
  public SelectAqlField<ProAnalytCluster> PRO_ANALYT_CLUSTER = new AqlFieldImp<ProAnalytCluster>(ProAnalytCluster.class, "", "ProAnalytCluster", ProAnalytCluster.class, this);

  public SelectAqlField<Long> ANALYSEERGEBNIS_REIHENFOLGE_MAGNITUDE = new AqlFieldImp<Long>(ProAnalytCluster.class, "/items[at0027]/value|magnitude", "analyseergebnisReihenfolgeMagnitude", Long.class, this);

  public SelectAqlField<NullFlavour> ANALYSEERGEBNIS_REIHENFOLGE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0027]/null_flavour|defining_code", "analyseergebnisReihenfolgeNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<DvCodedText> VIRUSNACHWEISTEST = new AqlFieldImp<DvCodedText>(ProAnalytCluster.class, "/items[at0024]/value", "virusnachweistest", DvCodedText.class, this);

  public SelectAqlField<NullFlavour> VIRUSNACHWEISTEST_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0024]/null_flavour|defining_code", "virusnachweistestNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<DvCodedText> NACHWEIS = new AqlFieldImp<DvCodedText>(ProAnalytCluster.class, "/items[at0001]/value", "nachweis", DvCodedText.class, this);

  public SelectAqlField<NullFlavour> NACHWEIS_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0001]/null_flavour|defining_code", "nachweisNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<ProAnalytQuantitativesErgebnisElement> QUANTITATIVES_ERGEBNIS = new ListAqlFieldImp<ProAnalytQuantitativesErgebnisElement>(ProAnalytCluster.class, "/items[at0001]", "quantitativesErgebnis", ProAnalytQuantitativesErgebnisElement.class, this);

  public ListSelectAqlField<Cluster> ANALYSEERGEBNIS_DETAILS = new ListAqlFieldImp<Cluster>(ProAnalytCluster.class, "/items[at0014]", "analyseergebnisDetails", Cluster.class, this);

  public SelectAqlField<String> INTERPRETATION_VALUE = new AqlFieldImp<String>(ProAnalytCluster.class, "/items[at0004]/value|value", "interpretationValue", String.class, this);

  public SelectAqlField<NullFlavour> INTERPRETATION_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0004]/null_flavour|defining_code", "interpretationNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<NullFlavour> TESTMETHODE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0028]/null_flavour|defining_code", "testmethodeNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<TemporalAccessor> ZEITPUNKT_DER_VALIDIERUNG_VALUE = new AqlFieldImp<TemporalAccessor>(ProAnalytCluster.class, "/items[at0025]/value|value", "zeitpunktDerValidierungValue", TemporalAccessor.class, this);

  public SelectAqlField<NullFlavour> ZEITPUNKT_DER_VALIDIERUNG_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0025]/null_flavour|defining_code", "zeitpunktDerValidierungNullFlavourDefiningCode", NullFlavour.class, this);

  public ListSelectAqlField<ProAnalytErgebnisStatusElement> ERGEBNIS_STATUS = new ListAqlFieldImp<ProAnalytErgebnisStatusElement>(ProAnalytCluster.class, "/items[at0005]", "ergebnisStatus", ProAnalytErgebnisStatusElement.class, this);

  public SelectAqlField<TemporalAccessor> ZEITPUNKT_ERGEBNIS_STATUS_VALUE = new AqlFieldImp<TemporalAccessor>(ProAnalytCluster.class, "/items[at0006]/value|value", "zeitpunktErgebnisStatusValue", TemporalAccessor.class, this);

  public SelectAqlField<NullFlavour> ZEITPUNKT_ERGEBNIS_STATUS_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0006]/null_flavour|defining_code", "zeitpunktErgebnisStatusNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<NullFlavour> ZUGEHOERIGE_LABORPROBE_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0026]/null_flavour|defining_code", "zugehoerigeLaborprobeNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<String> KOMMENTAR_VALUE = new AqlFieldImp<String>(ProAnalytCluster.class, "/items[at0003]/value|value", "kommentarValue", String.class, this);

  public SelectAqlField<NullFlavour> KOMMENTAR_NULL_FLAVOUR_DEFINING_CODE = new AqlFieldImp<NullFlavour>(ProAnalytCluster.class, "/items[at0003]/null_flavour|defining_code", "kommentarNullFlavourDefiningCode", NullFlavour.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(ProAnalytCluster.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public SelectAqlField<ProAnalytZugehoerigeLaborprobeChoice> ZUGEHOERIGE_LABORPROBE = new AqlFieldImp<ProAnalytZugehoerigeLaborprobeChoice>(ProAnalytCluster.class, "/items[at0026]/value", "zugehoerigeLaborprobe", ProAnalytZugehoerigeLaborprobeChoice.class, this);

  private ProAnalytClusterContainment() {
    super("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1");
  }

  public static ProAnalytClusterContainment getInstance() {
    return new ProAnalytClusterContainment();
  }
}
