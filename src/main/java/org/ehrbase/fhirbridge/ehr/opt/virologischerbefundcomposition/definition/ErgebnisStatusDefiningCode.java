package org.ehrbase.fhirbridge.ehr.opt.virologischerbefundcomposition.definition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum ErgebnisStatusDefiningCode implements EnumValueSet {
  ENDBEFUND("Endbefund", "Das Analyseergebnis ist vollständig und durch eine autorisierte Person verifiziert.", "local", "at0018"),

  ERFASST("Erfasst", "Der Test ist im Laborinformationssystem erfasst, aber noch kein Ergebnis verfügbar.", "local", "at0015"),

  ENDBEFUND_ERGAENZT("Endbefund, ergänzt", "Nach Abschluss wurde der Bericht durch das Hinzufügen neuer Inhalte abgeändert. Die vorhandene Inhalte sind unverändert. Dies ist eine Unterkategorie von \"Endbefund, geändert\".", "local", "at0021"),

  ENDBEFUND_KORRIGIERT("Endbefund, korrigiert", "Das Ergebnis wurde nach dem endgültigen Ergebnis korrigiert und vom zuständigen Laborwissenschaftler vervollständigt und verifiziert. Dies ist eine Unterkategorie von \"Endbefund, geändert\".", "local", "at0019"),

  ENDBEFUND_GEAENDERT("Endbefund, geändert", "Das Ergebnis wurde nach dem endgültigen Ergebnis geändert und vom zuständigen Laborwissenschaftler vervollständigt und verifiziert. Die Ergebnisdaten wurden geändert.", "local", "at0020"),

  STORNIERT("Storniert", "Das Testergebnis ist nicht verfügbar, weil der Test nicht (vollständig) durchgeführt oder abgebrochen wurde.", "local", "at0023"),

  UNVOLLSTAENDIG("Unvollständig", "Das Testresultat ist ein Anfangs- oder Interimswert, vorläufig oder nicht verifiziert/validiert.", "local", "at0016"),

  VORLAEUFIG("Vorläufig", "Erste, verifizierte Resultate sind vorhanden, der Test ist aber noch nicht abgeschlossen (Sub-Kategorie von 'Unvollständig').", "local", "at0017"),

  ENDBEFUND_WIDERRUFEN("Endbefund, widerrufen", "Das Testergebnis wurde nach Endbefundung zurückgezogen.", "local", "at0022");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  ErgebnisStatusDefiningCode(String value, String description, String terminologyId, String code) {
    this.value = value;
    this.description = description;
    this.terminologyId = terminologyId;
    this.code = code;
  }

  public String getValue() {
     return this.value ;
  }

  public String getDescription() {
     return this.description ;
  }

  public String getTerminologyId() {
     return this.terminologyId ;
  }

  public String getCode() {
     return this.code ;
  }
}
