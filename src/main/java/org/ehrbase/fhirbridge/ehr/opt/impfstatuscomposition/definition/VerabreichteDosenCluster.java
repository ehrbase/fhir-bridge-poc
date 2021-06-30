package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.datastructures.Cluster;
import java.lang.Double;
import java.lang.Long;
import java.lang.String;
import java.util.List;
import javax.annotation.processing.Generated;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.classgenerator.interfaces.LocatableEntity;
import org.ehrbase.client.classgenerator.shareddefinition.NullFlavour;

@Entity
@Archetype("openEHR-EHR-CLUSTER.dosage.v1")
@Generated(
    value = "org.ehrbase.client.classgenerator.ClassGenerator",
    date = "2021-06-30T11:44:02.790384+02:00",
    comments = "https://github.com/ehrbase/openEHR_SDK Version: 1.4.0"
)
public class VerabreichteDosenCluster implements LocatableEntity {
  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen/Dosierungsreihenfolge
   * Description: Beabsichtigte Reihenfolge dieser Dosierung in der Gesamtdosierungsfolge.
   * Comment: Zum Beispiel: '1', '2', '3'.
   * Wenn mehrere Dosierungen angegeben werden, gibt die 'Dosierungsreihenfolge' die Reihenfolge an, in der sie ausgeführt werden soll. Zum Beispiel: (1) 1 Tablette am Morgen, (2) 2 Tabletten um 14 Uhr, (3) 1 Tablette am Abend.
   */
  @Path("/items[at0164]/value|magnitude")
  private Long dosierungsreihenfolgeMagnitude;

  /**
   * Path: Impfstatus/Impfung/Tree/Verabreichte Dosen/Dosierungsreihenfolge/null_flavour
   */
  @Path("/items[at0164]/null_flavour|defining_code")
  private NullFlavour dosierungsreihenfolgeNullFlavourDefiningCode;

  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen/Dosismenge
   * Description: Der Wert der Arzneimittelmenge, die an einem Zeitpunkt verabreicht wird, als reelle Zahl oder als Bereich von reellen Zahlen. Dem Wert ist die Dosiseinheit zugeordnet.
   * Comment: Zum Beispiel: 1; 1,5; 0,125 oder 1-2; 12,5 - 20,5
   */
  @Path("/items[at0144]/value|magnitude")
  private Double dosismengeMagnitude;

  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen/Dosismenge
   * Description: Der Wert der Arzneimittelmenge, die an einem Zeitpunkt verabreicht wird, als reelle Zahl oder als Bereich von reellen Zahlen. Dem Wert ist die Dosiseinheit zugeordnet.
   * Comment: Zum Beispiel: 1; 1,5; 0,125 oder 1-2; 12,5 - 20,5
   */
  @Path("/items[at0144]/value|units")
  private String dosismengeUnits;

  /**
   * Path: Impfstatus/Impfung/Tree/Verabreichte Dosen/Dosismenge/null_flavour
   */
  @Path("/items[at0144]/null_flavour|defining_code")
  private NullFlavour dosismengeNullFlavourDefiningCode;

  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen/Tägliche Verabreichungszeiten
   * Description: Strukturierte Details des Musters für Verabreichungszeiten innerhalb eines Tages.
   * Comment: Zum Beispiel: "Morgens", "Um 06:00, 14:00, 21:00"'.
   */
  @Path("/items[at0037]")
  private List<Cluster> taeglicheVerabreichungszeiten;

  /**
   * Path: Impfstatus/Impfung/Verabreichte Dosen/feeder_audit
   */
  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  public void setDosierungsreihenfolgeMagnitude(Long dosierungsreihenfolgeMagnitude) {
     this.dosierungsreihenfolgeMagnitude = dosierungsreihenfolgeMagnitude;
  }

  public Long getDosierungsreihenfolgeMagnitude() {
     return this.dosierungsreihenfolgeMagnitude ;
  }

  public void setDosierungsreihenfolgeNullFlavourDefiningCode(
      NullFlavour dosierungsreihenfolgeNullFlavourDefiningCode) {
     this.dosierungsreihenfolgeNullFlavourDefiningCode = dosierungsreihenfolgeNullFlavourDefiningCode;
  }

  public NullFlavour getDosierungsreihenfolgeNullFlavourDefiningCode() {
     return this.dosierungsreihenfolgeNullFlavourDefiningCode ;
  }

  public void setDosismengeMagnitude(Double dosismengeMagnitude) {
     this.dosismengeMagnitude = dosismengeMagnitude;
  }

  public Double getDosismengeMagnitude() {
     return this.dosismengeMagnitude ;
  }

  public void setDosismengeUnits(String dosismengeUnits) {
     this.dosismengeUnits = dosismengeUnits;
  }

  public String getDosismengeUnits() {
     return this.dosismengeUnits ;
  }

  public void setDosismengeNullFlavourDefiningCode(NullFlavour dosismengeNullFlavourDefiningCode) {
     this.dosismengeNullFlavourDefiningCode = dosismengeNullFlavourDefiningCode;
  }

  public NullFlavour getDosismengeNullFlavourDefiningCode() {
     return this.dosismengeNullFlavourDefiningCode ;
  }

  public void setTaeglicheVerabreichungszeiten(List<Cluster> taeglicheVerabreichungszeiten) {
     this.taeglicheVerabreichungszeiten = taeglicheVerabreichungszeiten;
  }

  public List<Cluster> getTaeglicheVerabreichungszeiten() {
     return this.taeglicheVerabreichungszeiten ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }
}
