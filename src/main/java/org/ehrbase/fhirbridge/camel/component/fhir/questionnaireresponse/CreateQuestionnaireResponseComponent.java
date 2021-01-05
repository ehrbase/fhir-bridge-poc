package org.ehrbase.fhirbridge.camel.component.fhir.questionnaireresponse;

import org.ehrbase.fhirbridge.fhir.questionnaireresponse.CreateQuestionnaireResponseTransaction;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;
import org.openehealth.ipf.platform.camel.ihe.fhir.core.custom.CustomFhirComponent;

@SuppressWarnings({"java:S110"})
public class CreateQuestionnaireResponseComponent
    extends CustomFhirComponent<GenericFhirAuditDataset> {

  public CreateQuestionnaireResponseComponent() {
    super(new CreateQuestionnaireResponseTransaction());
  }
}
