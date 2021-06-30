package org.ehrbase.fhirbridge.ehr.opt.impfstatuscomposition.definition;

import java.lang.String;
import org.ehrbase.client.classgenerator.EnumValueSet;

public enum CareflowStepDefiningCode implements EnumValueSet {
  VERABREICHUNG_EINER_DOSIS_WURDE_AUSGELASSEN("Verabreichung einer Dosis wurde ausgelassen", "Eine Gabe des Arzneimittels wurde zurückgehalten und nicht gegeben. Es besteht keine Erwartung, dass sie später verabreicht wird, obwohl die nächste Dosis (falls es eine gibt) gemäß der ursprünglichen Verordnung verabreicht werden sollte.", "openehr", "at0018"),

  REZEPT_WURDE_AUSGEFUEHRT("Rezept wurde ausgeführt", "Das Rezept wurde erfolgreich ausgeführt/eingehalten.", "openehr", "at0152"),

  REZEPT_IST_UNGUELTIG_ODER_ABGELAUFEN("Rezept ist ungültig oder abgelaufen", "Das Rezept ist ungültig geworden oder ist abgelaufen, ohne das es eingelöst wurde.", "openehr", "at0151"),

  ARZNEIMITTELBEHANDLUNG_GESTOPPT("Arzneimittelbehandlung gestoppt", "Die Verabreichung des Arzneimittels wurde während der Dauer der geplanten Behandlung eingestellt.", "openehr", "at0015");

  private String value;

  private String description;

  private String terminologyId;

  private String code;

  CareflowStepDefiningCode(String value, String description, String terminologyId, String code) {
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
