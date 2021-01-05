package org.ehrbase.fhirbridge.ehr.mapper;

import org.ehrbase.client.aql.record.Record;
import org.ehrbase.fhirbridge.camel.component.ehr.aql.RowMapper;
import org.ehrbase.fhirbridge.ehr.converter.ProcedureCompositionConverter;
import org.ehrbase.fhirbridge.ehr.opt.prozedurcomposition.ProzedurComposition;
import org.hl7.fhir.r4.model.Procedure;

public class ProcedureRowMapper implements RowMapper<Procedure> {

  private final ProcedureCompositionConverter converter = new ProcedureCompositionConverter();

  @Override
  public Procedure mapRow(Record record, int rowNum) {
    ProzedurComposition composition = (ProzedurComposition) record.value(0);
    return converter.fromComposition(composition);
  }
}
