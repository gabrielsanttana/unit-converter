package exceptions;

/**
 * An exception class for conversion type errors
 */
public class ConversionErrorException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ConversionErrorException(String message) {
    super(message);
  }
}
