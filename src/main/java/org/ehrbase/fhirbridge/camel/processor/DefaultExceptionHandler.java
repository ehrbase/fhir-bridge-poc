package org.ehrbase.fhirbridge.camel.processor;

import ca.uhn.fhir.rest.server.exceptions.UnprocessableEntityException;
import org.apache.camel.Exchange;
import org.apache.camel.processor.ErrorHandler;
import org.ehrbase.client.exception.WrongStatusCodeException;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class DefaultExceptionHandler implements ErrorHandler, MessageSourceAware {

  private MessageSourceAccessor messages;

  @Override
  public void process(Exchange exchange) {
    Exception ex = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, Exception.class);

    if (ex instanceof WrongStatusCodeException) {
      handleWrongStatusCode((WrongStatusCodeException) ex);
    }
  }

  private void handleWrongStatusCode(WrongStatusCodeException ex) {
    HttpStatus status = HttpStatus.valueOf(ex.getActualStatusCode());
    throw new UnprocessableEntityException(
        messages.getMessage(
            "ehrbase.wrongStatusCode",
            new Object[] {status.value(), status.getReasonPhrase(), ex.getMessage()}),
        ex);
  }

  @Override
  public void setMessageSource(@NonNull MessageSource messageSource) {
    messages = new MessageSourceAccessor(messageSource);
  }
}
