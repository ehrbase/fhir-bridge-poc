package org.ehrbase.fhirbridge.ehr.mapper;

import org.ehrbase.client.aql.record.Record;
import org.ehrbase.fhirbridge.camel.component.ehr.aql.RowMapper;
import org.ehrbase.fhirbridge.ehr.converter.DiagnoseCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.diagnosecomposition.DiagnoseComposition;
import org.hl7.fhir.r4.model.Condition;

public class DiagnoseRowMapper implements RowMapper<Condition> {

  private final DiagnoseCompositionConverter converter = new DiagnoseCompositionConverter();

  @Override
  public Condition mapRow(Record record, int rowNum) {
    DiagnoseComposition composition = (DiagnoseComposition) record.value(0);
    return converter.fromComposition(composition);
  }
}
