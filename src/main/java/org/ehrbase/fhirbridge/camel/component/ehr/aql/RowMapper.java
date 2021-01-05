package org.ehrbase.fhirbridge.camel.component.ehr.aql;

import org.ehrbase.client.aql.record.Record;

public interface RowMapper<T> {

  <R extends Record> T mapRow(R record, int rowNum);
}
