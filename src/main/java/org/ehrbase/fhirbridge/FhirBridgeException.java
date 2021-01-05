package org.ehrbase.fhirbridge;

public class FhirBridgeException extends RuntimeException {

  public FhirBridgeException(String message) {
    super(message);
  }

  public FhirBridgeException(String message, Throwable cause) {
    super(message, cause);
  }

  public FhirBridgeException(Throwable cause) {
    super(cause);
  }
}
