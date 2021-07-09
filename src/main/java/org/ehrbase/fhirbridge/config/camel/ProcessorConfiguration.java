package org.ehrbase.fhirbridge.config.camel;

import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import org.ehrbase.fhirbridge.camel.processor.FindPatientOpenehrProcessor;
import org.ehrbase.fhirbridge.camel.processor.FindResourceProcessor;
import org.ehrbase.fhirbridge.camel.processor.ProvideResourcePersistenceProcessor;
import org.ehrbase.fhirbridge.core.repository.ResourceMapRepository;
import org.hl7.fhir.r4.model.AuditEvent;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.Consent;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Encounter;
import org.hl7.fhir.r4.model.Immunization;
import org.hl7.fhir.r4.model.MedicationStatement;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProcessorConfiguration {

    private final ResourceMapRepository resourceMapRepository;

    public ProcessorConfiguration(ResourceMapRepository resourceMapRepository) {
        this.resourceMapRepository = resourceMapRepository;
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Condition> provideConditionPersistenceProcessor(IFhirResourceDao<Condition> conditionDao) {
        return new ProvideResourcePersistenceProcessor<>(conditionDao, Condition.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Consent> provideConsentPersistenceProcessor(IFhirResourceDao<Consent> consentDao) {
        return new ProvideResourcePersistenceProcessor<>(consentDao, Consent.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<DiagnosticReport> provideDiagnosticReportPersistenceProcessor(IFhirResourceDao<DiagnosticReport> diagnosticReportDao) {
        return new ProvideResourcePersistenceProcessor<>(diagnosticReportDao, DiagnosticReport.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Encounter> provideEncounterPersistenceProcessor(IFhirResourceDao<Encounter> encounterDao) {
        return new ProvideResourcePersistenceProcessor<>(encounterDao, Encounter.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Immunization> provideImmunizationPersistenceProcessor(IFhirResourceDao<Immunization> immunizationDao) {
        return new ProvideResourcePersistenceProcessor<>(immunizationDao, Immunization.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Observation> provideObservationPersistenceProcessor(IFhirResourceDao<Observation> observationDao) {
        return new ProvideResourcePersistenceProcessor<>(observationDao, Observation.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<MedicationStatement> provideMedicationStatementPersistenceProcessor(IFhirResourceDao<MedicationStatement> medicationStatementDao) {
        return new ProvideResourcePersistenceProcessor<>(medicationStatementDao, MedicationStatement.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Patient> providePatientPersistenceProcessor(IFhirResourceDao<Patient> patientDao) {
        return new ProvideResourcePersistenceProcessor<>(patientDao, Patient.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<Procedure> provideProcedurePersistenceProcessor(IFhirResourceDao<Procedure> procedureDao) {
        return new ProvideResourcePersistenceProcessor<>(procedureDao, Procedure.class, resourceMapRepository);
    }

    @Bean
    public ProvideResourcePersistenceProcessor<QuestionnaireResponse> provideQuestionnaireResponsePersistenceProcessor(IFhirResourceDao<QuestionnaireResponse> questionnaireResponseDao) {
        return new ProvideResourcePersistenceProcessor<>(questionnaireResponseDao, QuestionnaireResponse.class, resourceMapRepository);
    }

    @Bean
    public FindResourceProcessor<AuditEvent> findAuditEventProcessor(IFhirResourceDao<AuditEvent> auditEventDao) {
        return new FindResourceProcessor<>(auditEventDao);
    }

    @Bean
    public FindResourceProcessor<Condition> findConditionProcessor(IFhirResourceDao<Condition> conditionDao) {
        return new FindResourceProcessor<>(conditionDao);
    }

    @Bean
    public FindResourceProcessor<Consent> findConsentProcessor(IFhirResourceDao<Consent> consentDao) {
        return new FindResourceProcessor<>(consentDao);
    }

    @Bean
    public FindResourceProcessor<DiagnosticReport> findDiagnosticReportProcessor(IFhirResourceDao<DiagnosticReport> diagnosticReportDao) {
        return new FindResourceProcessor<>(diagnosticReportDao);
    }

    /*
    @Bean
    public FindResourceProcessorOpenehr<DiagnosticReport> findDiagnosticReportProcessorOpenehr(IFhirResourceDao<DiagnosticReport> diagnosticReportDao) {
        return new FindResourceProcessor<>(diagnosticReportDao);
    }
    */

    @Bean
    public FindResourceProcessor<Encounter> findEncounterProcessor(IFhirResourceDao<Encounter> encounterDao) {
        return new FindResourceProcessor<>(encounterDao);
    }

    @Bean
    public FindResourceProcessor<Immunization> findImmunizationProcessor(IFhirResourceDao<Immunization> immunizationDao) {
        return new FindResourceProcessor<>(immunizationDao);
    }

    @Bean
    public FindResourceProcessor<Observation> findObservationProcessor(IFhirResourceDao<Observation> observationDao) {
        return new FindResourceProcessor<>(observationDao);
    }

    @Bean
    public FindResourceProcessor<MedicationStatement> findMedicationStatementProcessor(IFhirResourceDao<MedicationStatement> medicationStatementDao) {
        return new FindResourceProcessor<>(medicationStatementDao);
    }

    @Bean
    public FindResourceProcessor<Patient> findPatientProcessor(IFhirResourceDao<Patient> patientDao) {
        return new FindResourceProcessor<>(patientDao);
    }

    // TEST
    @Bean
    public FindPatientOpenehrProcessor findPatientOpenehrProcessor(IFhirResourceDao<Patient> patientDao) {
        return new FindPatientOpenehrProcessor();
    }

    @Bean
    public FindResourceProcessor<Procedure> findProcedureProcessor(IFhirResourceDao<Procedure> procedureDao) {
        return new FindResourceProcessor<>(procedureDao);
    }

    @Bean
    public FindResourceProcessor<QuestionnaireResponse> findQuestionnaireResponseProcessor(IFhirResourceDao<QuestionnaireResponse> questionnaireResponseDao) {
        return new FindResourceProcessor<>(questionnaireResponseDao);
    }
}
