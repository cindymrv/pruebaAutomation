package exceptions;

public class PruebaError extends AssertionError {

  public PruebaError(String message) {
    super(message);
  }

  public PruebaError(String message, Throwable cause) {
    super(message, cause);
  }
}
