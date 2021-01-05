package org.ehrbase.fhirbridge.camel.processor;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import java.util.List;
import java.util.UUID;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.client.aql.record.Record1;
import org.ehrbase.client.openehrclient.OpenEhrClient;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConstants;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.hl7.fhir.r4.model.OperationOutcome.IssueSeverity;
import org.hl7.fhir.r4.model.OperationOutcome.IssueType;
import org.hl7.fhir.r4.model.OperationOutcome.OperationOutcomeIssueComponent;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.lang.NonNull;

public class PatientIdProcessor implements Processor, MessageSourceAware {

  private final FhirContext fhirContext;

  private final OpenEhrClient openEhrClient;

  private MessageSourceAccessor messages;

  public PatientIdProcessor(FhirContext fhirContext, OpenEhrClient openEhrClient) {
    this.fhirContext = fhirContext;
    this.openEhrClient = openEhrClient;
  }

  @Override
  public void process(Exchange exchange) {
    Resource resource = exchange.getIn().getBody(Resource.class);
    String patientId = extractPatientId(resource);

    Query<Record1<UUID>> query =
        Query.buildNativeQuery(
            "select e/ehr_id/value from ehr e where e/ehr_status/subject/external_ref/id/value = $patientId",
            UUID.class);
    List<Record1<UUID>> result =
        openEhrClient.aqlEndpoint().execute(query, new ParameterValue<>("patientId", patientId));
    if (result.isEmpty()) {
      throw new UnprocessableEntityException(
          fhirContext,
          new OperationOutcome()
              .addIssue(
                  new OperationOutcomeIssueComponent()
                      .setSeverity(IssueSeverity.ERROR)
                      .setCode(IssueType.VALUE)
                      .setDiagnostics(
                          messages.getMessage(
                              "validation.subject.ehrIdNotFound", new Object[] {patientId}))
                      .addExpression(resource.getResourceType() + ".subject.identifier")));
    }

    exchange.getIn().setHeader(CompositionConstants.EHR_ID, result.get(0).value1());
  }

  private String extractPatientId(Resource resource) {
    String patientId = null;

    ResourceType resourceType = resource.getResourceType();
    switch (resourceType) {
      case Condition:
        patientId = ((Condition) resource).getSubject().getIdentifier().getValue();
        break;
      case DiagnosticReport:
        patientId = ((DiagnosticReport) resource).getSubject().getIdentifier().getValue();
        break;
      case Observation:
        patientId = ((Observation) resource).getSubject().getIdentifier().getValue();
        break;
      case Patient:
        Patient patient = (Patient) resource;
        if (patient.hasIdentifier()) {
          patientId = ((Patient) resource).getIdentifier().get(0).getValue();
        }
        break;
      case Procedure:
        patientId = ((Procedure) resource).getSubject().getIdentifier().getValue();
        break;
      case QuestionnaireResponse:
        patientId = ((QuestionnaireResponse) resource).getSubject().getIdentifier().getValue();
        break;
      default:
        throw new IllegalArgumentException("Unsupported resource [" + resourceType + "]");
    }

    if (patientId == null) {
      throw new UnprocessableEntityException(
          fhirContext,
          new OperationOutcome()
              .addIssue(
                  new OperationOutcomeIssueComponent()
                      .setSeverity(IssueSeverity.ERROR)
                      .setCode(IssueType.VALUE)
                      .setDiagnostics(messages.getMessage("validation.subject.identifierRequired"))
                      .addExpression(resourceType + ".subject.identifier")));
    }
    return patientId;
  }

  @Override
  public void setMessageSource(@NonNull MessageSource messageSource) {
    this.messages = new MessageSourceAccessor(messageSource);
  }
}
