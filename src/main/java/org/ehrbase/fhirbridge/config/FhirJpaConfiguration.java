package org.ehrbase.fhirbridge.config;

import ca.uhn.fhir.jpa.api.config.DaoConfig;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDao;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDaoCodeSystem;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDaoConceptMap;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDaoSearchParameter;
import ca.uhn.fhir.jpa.api.dao.IFhirResourceDaoValueSet;
import ca.uhn.fhir.jpa.config.r4.BaseR4Config;
import ca.uhn.fhir.jpa.dao.JpaResourceDao;
import ca.uhn.fhir.jpa.dao.r4.FhirResourceDaoCodeSystemR4;
import ca.uhn.fhir.jpa.dao.r4.FhirResourceDaoConceptMapR4;
import ca.uhn.fhir.jpa.dao.r4.FhirResourceDaoSearchParameterR4;
import ca.uhn.fhir.jpa.dao.r4.FhirResourceDaoValueSetR4;
import ca.uhn.fhir.jpa.model.config.PartitionSettings;
import ca.uhn.fhir.jpa.model.entity.ModelConfig;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hl7.fhir.r4.model.AuditEvent;
import org.hl7.fhir.r4.model.CodeSystem;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.Coding;
import org.hl7.fhir.r4.model.ConceptMap;
import org.hl7.fhir.r4.model.Condition;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Procedure;
import org.hl7.fhir.r4.model.QuestionnaireResponse;
import org.hl7.fhir.r4.model.SearchParameter;
import org.hl7.fhir.r4.model.ValueSet;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

/** {@link Configuration Configuration} for HAPI FHIR JPA server. */
@Configuration
@EnableConfigurationProperties(FhirJpaProperties.class)
public class FhirJpaConfiguration extends BaseR4Config {

  private final FhirJpaProperties fhirJpaProperties;

  private final JpaProperties jpaProperties;

  private final DataSource dataSource;

  public FhirJpaConfiguration(
      FhirJpaProperties fhirJpaProperties, JpaProperties jpaProperties, DataSource dataSource) {
    this.fhirJpaProperties = fhirJpaProperties;
    this.jpaProperties = jpaProperties;
    this.dataSource = dataSource;
  }

  @Bean
  public DaoConfig daoConfig() {
    return new DaoConfig();
  }

  @Bean
  public ModelConfig modelConfig() {
    ModelConfig config = new ModelConfig();
    config.setAllowExternalReferences(fhirJpaProperties.isAllowExternalReferences());
    return config;
  }

  @Bean
  public PartitionSettings partitionSettings() {
    return new PartitionSettings();
  }

  @Bean
  @Override
  protected LocalContainerEntityManagerFactoryBean entityManagerFactory() {
    LocalContainerEntityManagerFactoryBean entityManagerFactory = super.entityManagerFactory();
    entityManagerFactory.setPersistenceUnitName("HAPI_PU");
    entityManagerFactory.setDataSource(dataSource);
    entityManagerFactory.setJpaPropertyMap(jpaProperties.getProperties());
    return entityManagerFactory;
  }

  @Primary
  @Bean
  public PlatformTransactionManager hapiTransactionManager(
      EntityManagerFactory entityManagerFactory) {
    JpaTransactionManager transactionManager = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(entityManagerFactory);
    return transactionManager;
  }

  @Bean(name = "myConditionDaoR4")
  public IFhirResourceDao<Condition> conditionReportDao() {
    JpaResourceDao<Condition> conditionReportDao = new JpaResourceDao<>();
    conditionReportDao.setResourceType(Condition.class);
    conditionReportDao.setContext(fhirContext());
    return conditionReportDao;
  }

  @Bean(name = "myDiagnosticReportDaoR4")
  public IFhirResourceDao<DiagnosticReport> diagnosticReportDao() {
    JpaResourceDao<DiagnosticReport> diagnosticReportDao = new JpaResourceDao<>();
    diagnosticReportDao.setResourceType(DiagnosticReport.class);
    diagnosticReportDao.setContext(fhirContext());
    return diagnosticReportDao;
  }

  @Bean(name = "myObservationDaoR4")
  public IFhirResourceDao<Observation> observationDao() {
    JpaResourceDao<Observation> observationDao = new JpaResourceDao<>();
    observationDao.setResourceType(Observation.class);
    observationDao.setContext(fhirContext());
    return observationDao;
  }

  @Bean(name = "myProcedureDaoR4")
  public IFhirResourceDao<Procedure> procedureDao() {
    JpaResourceDao<Procedure> procedureDao = new JpaResourceDao<>();
    procedureDao.setResourceType(Procedure.class);
    procedureDao.setContext(fhirContext());
    return procedureDao;
  }

  @Bean(name = "myAuditEventDaoR4")
  public IFhirResourceDao<AuditEvent> auditEventDao() {
    JpaResourceDao<AuditEvent> auditEventDao = new JpaResourceDao<>();
    auditEventDao.setResourceType(AuditEvent.class);
    auditEventDao.setContext(fhirContext());
    return auditEventDao;
  }

  @Bean(name = "myPatientDaoR4")
  public IFhirResourceDao<Patient> patientDao() {
    JpaResourceDao<Patient> patientDao = new JpaResourceDao<>();
    patientDao.setResourceType(Patient.class);
    patientDao.setContext(fhirContext());
    return patientDao;
  }

  @Bean(name = "myQuestionnaireResponseDaoR4")
  public IFhirResourceDao<QuestionnaireResponse> questionnaireResponseDao() {
    JpaResourceDao<QuestionnaireResponse> questionnaireResponseDao = new JpaResourceDao<>();
    questionnaireResponseDao.setResourceType(QuestionnaireResponse.class);
    questionnaireResponseDao.setContext(fhirContext());
    return questionnaireResponseDao;
  }

  @Bean(name = "myCodeSystemDaoR4")
  public IFhirResourceDaoCodeSystem<CodeSystem, Coding, CodeableConcept> codeSystemDao() {
    FhirResourceDaoCodeSystemR4 codeSystemDao = new FhirResourceDaoCodeSystemR4();
    codeSystemDao.setResourceType(CodeSystem.class);
    codeSystemDao.setContext(fhirContext());
    return codeSystemDao;
  }

  @Bean(name = "myValueSetDaoR4")
  public IFhirResourceDaoValueSet<ValueSet, Coding, CodeableConcept> valueSetDao() {
    FhirResourceDaoValueSetR4 valueSetDao = new FhirResourceDaoValueSetR4();
    valueSetDao.setResourceType(ValueSet.class);
    valueSetDao.setContext(fhirContext());
    return valueSetDao;
  }

  @Bean(name = "myConceptMapDaoR4")
  public IFhirResourceDaoConceptMap<ConceptMap> conceptMapDao() {
    FhirResourceDaoConceptMapR4 conceptMapDao = new FhirResourceDaoConceptMapR4();
    conceptMapDao.setResourceType(ConceptMap.class);
    conceptMapDao.setContext(fhirContext());
    return conceptMapDao;
  }

  @Bean(name = "mySearchParameterDaoR4")
  public IFhirResourceDaoSearchParameter<SearchParameter> searchParameterDao() {
    FhirResourceDaoSearchParameterR4 searchParameterDao = new FhirResourceDaoSearchParameterR4();
    searchParameterDao.setResourceType(SearchParameter.class);
    searchParameterDao.setContext(fhirContext());
    return searchParameterDao;
  }
}
