package org.ehrbase.fhirbridge.camel.component.ehr.composition;

public class CompositionConversionException extends RuntimeException {

  public CompositionConversionException(String message) {
    super(message);
  }

  public CompositionConversionException(String message, Throwable cause) {
    super(message, cause);
  }
}
