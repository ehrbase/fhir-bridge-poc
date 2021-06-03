package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-CLUSTER.organization.v0")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.605245900+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class EinsenderstandortCluster implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Typ
   * Description: Art der Organisationseinheit.
   * Comment: Zum Beispiel: Fachabteilung im Krankenhaus, Versicherungsunternehmen, Sponsor
   */
  @Path("/items[at0051]/value|value")
  private String typValue;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Einsenderstandort/Typ/null_flavour
   */
  @Path("/items[at0051]/null_flavour|defining_code")
  private NullFlavour typNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Organisationsschlüssel
   * Description: Eindeutiger Identifikator der Organisationseinheit.
   */
  @Path("/items[at0024]/value|value")
  private String organisationsschluesselValue;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Einsenderstandort/Organisationsschlüssel/null_flavour
   */
  @Path("/items[at0024]/null_flavour|defining_code")
  private NullFlavour organisationsschluesselNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Name
   * Description: Bezeichnung für die Organisationseinheit
   */
  @Path("/items[at0052]/value|value")
  private String nameValue;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Einsenderstandort/Name/null_flavour
   */
  @Path("/items[at0052]/null_flavour|defining_code")
  private NullFlavour nameNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Aktiv/Inaktiv
   * Description: Gibt an, ob die Organisationseinheit noch aktiv ist.
   */
  @Path("/items[at0050]/value|value")
  private Boolean aktivInaktivValue;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Einsenderstandort/Aktiv/Inaktiv/null_flavour
   */
  @Path("/items[at0050]/null_flavour|defining_code")
  private NullFlavour aktivInaktivNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Zusätzliche Beschreibung
   * Description: Zusätzliche Informationen
   */
  @Path("/items[at0046]/value|value")
  private String zusaetzlicheBeschreibungValue;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Einsenderstandort/Zusätzliche Beschreibung/null_flavour
   */
  @Path("/items[at0046]/null_flavour|defining_code")
  private NullFlavour zusaetzlicheBeschreibungNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/Details
   * Description: Für die Erfassung weiterer Angaben über die Organisationseinheit, zum Beispiel Adresse oder Telekommunikationsdetails.
   */
  @Path("/items[at0047]")
  private List<Cluster> details;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setTypValue(String typValue) {
     this.typValue = typValue;
  }

  public String getTypValue() {
     return this.typValue ;
  }

  public void setTypNullFlavourDefiningCode(NullFlavour typNullFlavourDefiningCode) {
     this.typNullFlavourDefiningCode = typNullFlavourDefiningCode;
  }

  public NullFlavour getTypNullFlavourDefiningCode() {
     return this.typNullFlavourDefiningCode ;
  }

  public void setOrganisationsschluesselValue(String organisationsschluesselValue) {
     this.organisationsschluesselValue = organisationsschluesselValue;
  }

  public String getOrganisationsschluesselValue() {
     return this.organisationsschluesselValue ;
  }

  public void setOrganisationsschluesselNullFlavourDefiningCode(
      NullFlavour organisationsschluesselNullFlavourDefiningCode) {
     this.organisationsschluesselNullFlavourDefiningCode = organisationsschluesselNullFlavourDefiningCode;
  }

  public NullFlavour getOrganisationsschluesselNullFlavourDefiningCode() {
     return this.organisationsschluesselNullFlavourDefiningCode ;
  }

  public void setNameValue(String nameValue) {
     this.nameValue = nameValue;
  }

  public String getNameValue() {
     return this.nameValue ;
  }

  public void setNameNullFlavourDefiningCode(NullFlavour nameNullFlavourDefiningCode) {
     this.nameNullFlavourDefiningCode = nameNullFlavourDefiningCode;
  }

  public NullFlavour getNameNullFlavourDefiningCode() {
     return this.nameNullFlavourDefiningCode ;
  }

  public void setAktivInaktivValue(Boolean aktivInaktivValue) {
     this.aktivInaktivValue = aktivInaktivValue;
  }

  public Boolean isAktivInaktivValue() {
     return this.aktivInaktivValue ;
  }

  public void setAktivInaktivNullFlavourDefiningCode(
      NullFlavour aktivInaktivNullFlavourDefiningCode) {
     this.aktivInaktivNullFlavourDefiningCode = aktivInaktivNullFlavourDefiningCode;
  }

  public NullFlavour getAktivInaktivNullFlavourDefiningCode() {
     return this.aktivInaktivNullFlavourDefiningCode ;
  }

  public void setZusaetzlicheBeschreibungValue(String zusaetzlicheBeschreibungValue) {
     this.zusaetzlicheBeschreibungValue = zusaetzlicheBeschreibungValue;
  }

  public String getZusaetzlicheBeschreibungValue() {
     return this.zusaetzlicheBeschreibungValue ;
  }

  public void setZusaetzlicheBeschreibungNullFlavourDefiningCode(
      NullFlavour zusaetzlicheBeschreibungNullFlavourDefiningCode) {
     this.zusaetzlicheBeschreibungNullFlavourDefiningCode = zusaetzlicheBeschreibungNullFlavourDefiningCode;
  }

  public NullFlavour getZusaetzlicheBeschreibungNullFlavourDefiningCode() {
     return this.zusaetzlicheBeschreibungNullFlavourDefiningCode ;
  }

  public void setDetails(List<Cluster> details) {
     this.details = details;
  }

  public List<Cluster> getDetails() {
     return this.details ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
