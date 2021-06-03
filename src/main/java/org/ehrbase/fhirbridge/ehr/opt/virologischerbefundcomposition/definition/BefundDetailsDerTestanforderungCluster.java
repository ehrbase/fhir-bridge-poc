package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-05-18T14:46:29.605245900+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.3.0"
)
public class BefundDetailsDerTestanforderungCluster implements LocatableEntity {
  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Anforderung
   * Description: Name des ursprünglich angeforderten Tests.
   * Comment: Dieses Datenelement ist zu verwenden, wenn die angeforderte Testung von der tatsächlich vom Labor durchgeführten Testung abweicht.
   */
  @Path("/items[at0106 and name/value='Anforderung']")
  private List<BefundAnforderungElement> anforderung;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Auftrags-ID des anfordernden/einsendenden Systems/null_flavour
   */
  @Path("/items[at0062]/null_flavour|defining_code")
  private NullFlavour auftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Tree/Details der Testanforderung/Auftrags-ID (Empfänger)/null_flavour
   */
  @Path("/items[at0063]/null_flavour|defining_code")
  private NullFlavour auftragsIdEmpfaengerNullFlavourDefiningCode;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Einsenderstandort
   * Description: Eine fachliche Einheit, Organisation, Abteilung, Zusammenschluss, Gruppierung mit einem gemeinsamen Ziel.
   */
  @Path("/items[openEHR-EHR-CLUSTER.organization.v0 and name/value='Einsenderstandort']")
  private EinsenderstandortCluster einsenderstandort;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Verteilerliste
   * Description: Details über weitere Kliniker oder Organisationen, die eine Kopie der Analyseergebnisse benötigen.
   * Comment: Die "Verteilerliste" dient nur zu Informationszwecken. Der Hauptempfänger des Berichts ist die Person, die dazu bestimmt ist, auf die Information zu reagieren.
   */
  @Path("/items[at0035]")
  private List<Cluster> verteilerliste;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Auftrags-ID des anfordernden/einsendenden Systems
   * Description: Lokale Auftrags-ID des anfordernden/einsendenden Systems.
   */
  @Path("/items[at0062]/value")
  @Choice
  private BefundAuftragsIdDesAnforderndenEinsendendenSystemsChoice auftragsIdDesAnforderndenEinsendendenSystems;

  /**
   * Path: Virologischer Befund/Befund/Details der Testanforderung/Auftrags-ID (Empfänger)
   * Description: Lokale Auftrags-ID, die vom auftragsempfangendem System, gewöhnlich dem Laborinformationssystem (LIS) zugewiesen wird.
   */
  @Path("/items[at0063]/value")
  @Choice
  private BefundAuftragsIdEmpfaengerChoice auftragsIdEmpfaenger;

  public void setAnforderung(List<BefundAnforderungElement> anforderung) {
     this.anforderung = anforderung;
  }

  public List<BefundAnforderungElement> getAnforderung() {
     return this.anforderung ;
  }

  public void setAuftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode(
      NullFlavour auftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode) {
     this.auftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode = auftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode;
  }

  public NullFlavour getAuftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode() {
     return this.auftragsIdDesAnforderndenEinsendendenSystemsNullFlavourDefiningCode ;
  }

  public void setAuftragsIdEmpfaengerNullFlavourDefiningCode(
      NullFlavour auftragsIdEmpfaengerNullFlavourDefiningCode) {
     this.auftragsIdEmpfaengerNullFlavourDefiningCode = auftragsIdEmpfaengerNullFlavourDefiningCode;
  }

  public NullFlavour getAuftragsIdEmpfaengerNullFlavourDefiningCode() {
     return this.auftragsIdEmpfaengerNullFlavourDefiningCode ;
  }

  public void setEinsenderstandort(EinsenderstandortCluster einsenderstandort) {
     this.einsenderstandort = einsenderstandort;
  }

  public EinsenderstandortCluster getEinsenderstandort() {
     return this.einsenderstandort ;
  }

  public void setVerteilerliste(List<Cluster> verteilerliste) {
     this.verteilerliste = verteilerliste;
  }

  public List<Cluster> getVerteilerliste() {
     return this.verteilerliste ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setAuftragsIdDesAnforderndenEinsendendenSystems(
      BefundAuftragsIdDesAnforderndenEinsendendenSystemsChoice auftragsIdDesAnforderndenEinsendendenSystems) {
     this.auftragsIdDesAnforderndenEinsendendenSystems = auftragsIdDesAnforderndenEinsendendenSystems;
  }

  public BefundAuftragsIdDesAnforderndenEinsendendenSystemsChoice getAuftragsIdDesAnforderndenEinsendendenSystems(
      ) {
     return this.auftragsIdDesAnforderndenEinsendendenSystems ;
  }

  public void setAuftragsIdEmpfaenger(BefundAuftragsIdEmpfaengerChoice auftragsIdEmpfaenger) {
     this.auftragsIdEmpfaenger = auftragsIdEmpfaenger;
  }

  public BefundAuftragsIdEmpfaengerChoice getAuftragsIdEmpfaenger() {
     return this.auftragsIdEmpfaenger ;
  }
}
