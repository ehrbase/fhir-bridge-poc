package org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition;

import com.nedap.archie.rm.datastructures.Cluster;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-CLUSTER.laboratory_test_analyte.v1")
public class ProLaboranalytCluster {
  @Path("/items[at0005]/value")
  @Choice
  private ProLaboranalytErgebnisStatusChoice ergebnisStatus;

  @Path("/items[at0006]/value|value")
  private TemporalAccessor zeitpunktErgebnisStatusValue;

  @Path("/items[at0024]/value|defining_code")
  private UntersuchterAnalytDefiningcode untersuchterAnalytDefiningcode;

  @Path("/items[at0004]/value|defining_code")
  private ReferenzbereichsHinweiseDefiningcode referenzbereichsHinweiseDefiningcode;

  @Path("/items[at0001]/value")
  @Choice
  private ProLaboranalytAnalytResultatChoice analytResultat;

  @Path("/items[at0026]/value")
  @Choice
  private ProLaboranalytProbeChoice probe;

  @Path("/items[at0026]/name|value")
  private String probeValue;

  @Path("/items[at0004]/name|value")
  private String referenzbereichsHinweiseValue;

  @Path("/items[at0025]/value|value")
  private TemporalAccessor zeitpunktValidationValue;

  @Path("/items[at0014]")
  private List<Cluster> analyseergebnisDetails;

  @Path("/items[at0003]")
  private List<ProLaboranalytKommentarElement> kommentar;

  @Path("/items[at0001]/name|value")
  private String analytResultatValue;

  public void setErgebnisStatus(ProLaboranalytErgebnisStatusChoice ergebnisStatus) {
    this.ergebnisStatus = ergebnisStatus;
  }

  public ProLaboranalytErgebnisStatusChoice getErgebnisStatus() {
    return this.ergebnisStatus;
  }

  public void setZeitpunktErgebnisStatusValue(TemporalAccessor zeitpunktErgebnisStatusValue) {
    this.zeitpunktErgebnisStatusValue = zeitpunktErgebnisStatusValue;
  }

  public TemporalAccessor getZeitpunktErgebnisStatusValue() {
    return this.zeitpunktErgebnisStatusValue;
  }

  public void setUntersuchterAnalytDefiningcode(
      UntersuchterAnalytDefiningcode untersuchterAnalytDefiningcode) {
    this.untersuchterAnalytDefiningcode = untersuchterAnalytDefiningcode;
  }

  public UntersuchterAnalytDefiningcode getUntersuchterAnalytDefiningcode() {
    return this.untersuchterAnalytDefiningcode;
  }

  public void setReferenzbereichsHinweiseDefiningcode(
      ReferenzbereichsHinweiseDefiningcode referenzbereichsHinweiseDefiningcode) {
    this.referenzbereichsHinweiseDefiningcode = referenzbereichsHinweiseDefiningcode;
  }

  public ReferenzbereichsHinweiseDefiningcode getReferenzbereichsHinweiseDefiningcode() {
    return this.referenzbereichsHinweiseDefiningcode;
  }

  public void setAnalytResultat(ProLaboranalytAnalytResultatChoice analytResultat) {
    this.analytResultat = analytResultat;
  }

  public ProLaboranalytAnalytResultatChoice getAnalytResultat() {
    return this.analytResultat;
  }

  public void setProbe(ProLaboranalytProbeChoice probe) {
    this.probe = probe;
  }

  public ProLaboranalytProbeChoice getProbe() {
    return this.probe;
  }

  public void setProbeValue(String probeValue) {
    this.probeValue = probeValue;
  }

  public String getProbeValue() {
    return this.probeValue;
  }

  public void setReferenzbereichsHinweiseValue(String referenzbereichsHinweiseValue) {
    this.referenzbereichsHinweiseValue = referenzbereichsHinweiseValue;
  }

  public String getReferenzbereichsHinweiseValue() {
    return this.referenzbereichsHinweiseValue;
  }

  public void setZeitpunktValidationValue(TemporalAccessor zeitpunktValidationValue) {
    this.zeitpunktValidationValue = zeitpunktValidationValue;
  }

  public TemporalAccessor getZeitpunktValidationValue() {
    return this.zeitpunktValidationValue;
  }

  public void setAnalyseergebnisDetails(List<Cluster> analyseergebnisDetails) {
    this.analyseergebnisDetails = analyseergebnisDetails;
  }

  public List<Cluster> getAnalyseergebnisDetails() {
    return this.analyseergebnisDetails;
  }

  public void setKommentar(List<ProLaboranalytKommentarElement> kommentar) {
    this.kommentar = kommentar;
  }

  public List<ProLaboranalytKommentarElement> getKommentar() {
    return this.kommentar;
  }

  public void setAnalytResultatValue(String analytResultatValue) {
    this.analytResultatValue = analytResultatValue;
  }

  public String getAnalytResultatValue() {
    return this.analytResultatValue;
  }
}
