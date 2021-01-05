package org.ehrbase.fhirbridge.camel.component.ehr.aql;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.ehrbase.client.aql.parameter.ParameterValue;
import org.ehrbase.client.aql.query.Query;
import org.ehrbase.client.aql.record.Record;

public class AqlProducer extends DefaultProducer {

  private final AqlEndpoint endpoint;

  public AqlProducer(AqlEndpoint endpoint) {
    super(endpoint);
    this.endpoint = endpoint;
  }

  @Override
  public void process(Exchange exchange) {
    Query<?> query = exchange.getIn().getHeader(AqlConstants.AQL_QUERY, Query.class);
    if (query == null) {
      throw new IllegalArgumentException(); // TODO: Exception
    }

    ParameterValue<?>[] parameters = exchange.getIn().getBody(ParameterValue[].class);

    List<? extends Record> records =
        endpoint.getOpenEhrClient().aqlEndpoint().execute(query, parameters);

    RowMapper<?> rowMapper = determineRowMapper(exchange);

    AqlOutputType outputType = endpoint.getOutputType();
    if (outputType == AqlOutputType.SelectOne) {
      if (records.isEmpty()) {
        exchange.getMessage().setBody(null);
      } else if (records.size() == 1) {
        if (rowMapper != null) {
          exchange.getMessage().setBody(rowMapper.mapRow(records.get(0), 0));
        } else {
          exchange.getMessage().setBody(records.get(0));
        }
      } else {
        throw new IllegalArgumentException(); // TODO: Exception
      }
    } else {
      if (rowMapper != null) {
        List<?> result =
            IntStream.range(0, records.size())
                .mapToObj(i -> rowMapper.mapRow(records.get(i), i))
                .collect(Collectors.toList());
        exchange.getMessage().setBody(result);
      } else {
        exchange.getMessage().setBody(records);
      }
    }
  }

  private RowMapper<?> determineRowMapper(Exchange exchange) {
    RowMapper<?> rowMapper = exchange.getIn().getHeader(AqlConstants.ROW_MAPPER, RowMapper.class);
    if (rowMapper == null) {
      rowMapper = endpoint.getRowMapper();
    }
    return rowMapper;
  }
}
