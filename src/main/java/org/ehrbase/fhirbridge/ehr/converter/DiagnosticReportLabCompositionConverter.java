package org.ehrbase.fhirbridge.ehr.converter;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.ehrbase.fhirbridge.camel.component.ehr.composition.CompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.GECCOLaborbefundComposition;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition.LaborergebnisObservation;
import org.ehrbase.fhirbridge.ehr.opt.geccolaborbefundcomposition.definition.ProLaboranalytCluster;
import org.hl7.fhir.r4.model.DiagnosticReport;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.ResourceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DiagnosticReportLabCompositionConverter
    implements CompositionConverter<GECCOLaborbefundComposition, DiagnosticReport> {

  private static final Logger LOG =
      LoggerFactory.getLogger(DiagnosticReportLabCompositionConverter.class);

  private final ObservationLabCompositionConverter observationConverter =
      new ObservationLabCompositionConverter();

  @Override
  public DiagnosticReport fromComposition(GECCOLaborbefundComposition composition) {
    if (composition == null) {
      return null;
    }
    return new DiagnosticReport();
  }

  @Override
  public GECCOLaborbefundComposition toComposition(DiagnosticReport diagnosticReport) {
    if (diagnosticReport == null) {
      return null;
    }

    LOG.debug("Contained size: {}", diagnosticReport.getContained().size());

    // one contained Observation is expected
    if (diagnosticReport.getContained().size() != 1) {
      throw new UnprocessableEntityException(
          "One contained Observation was expected "
              + diagnosticReport.getContained().size()
              + " were received in DiagnosticReport "
              + diagnosticReport.getId());
    }
    if (diagnosticReport.getContained().get(0).getResourceType() != ResourceType.Observation) {
      throw new UnprocessableEntityException(
          "One contained Observation was expected, contained is there but is not Observation, it is "
              + diagnosticReport.getContained().get(0).getResourceType().toString());
    }

    Observation observation = (Observation) diagnosticReport.getContained().get(0);

    GECCOLaborbefundComposition result = observationConverter.toComposition(observation);

    LaborergebnisObservation laborbefund = result.getLaborergebnis();

    ProLaboranalytCluster laboranalytCluster = laborbefund.getProLaboranalyt();

    laborbefund.setTimeValue(
        observation.getEffectiveDateTimeType().getValueAsCalendar().toZonedDateTime());
    laborbefund.setLabortestBezeichnungValue(diagnosticReport.getCode().getText());
    laborbefund.setSchlussfolgerungValue(diagnosticReport.getConclusion());

    laborbefund.setProLaboranalyt(laboranalytCluster);

    // DvIdentifier receiverOrderIdentifier = new DvIdentifier();
    // receiverOrderIdentifier.setId(fhirDiagnosticReport.getIdentifier().get(0).getValue());
    // receiverOrderIdentifier.setType(fhirDiagnosticReport.getIdentifier().get(0).getSystem());
    // laborbefund.setLaborWelchesDenUntersuchungsauftragAnnimmt(receiverOrderIdentifier);

    return result;
  }
}
