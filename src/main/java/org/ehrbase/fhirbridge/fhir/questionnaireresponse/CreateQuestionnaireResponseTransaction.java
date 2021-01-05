package org.ehrbase.fhirbridge.fhir.questionnaireresponse;

import ca.uhn.fhir.context.FhirVersionEnum;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionConfiguration;
import org.openehealth.ipf.commons.ihe.fhir.FhirTransactionValidator;
import org.openehealth.ipf.commons.ihe.fhir.audit.GenericFhirAuditDataset;

public class CreateQuestionnaireResponseTransaction
    extends FhirTransactionConfiguration<GenericFhirAuditDataset> {

  public CreateQuestionnaireResponseTransaction() {
    super(
        "fhir-create-questionnaire-response",
        "Create QuestionnaireResponse",
        false,
        new CreateQuestionnaireResponseAuditStrategy(false),
        new CreateQuestionnaireResponseAuditStrategy(true),
        FhirVersionEnum.R4,
        new CreateQuestionnaireResponseProvider(),
        null,
        FhirTransactionValidator.NO_VALIDATION);
  }
}
