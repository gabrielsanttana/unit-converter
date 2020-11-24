package exceptions;

public class ConversionErrorException extends RuntimeException {

  public ConversionErrorException() {}

  public ConversionErrorException(String message) {
    super(message);
  }
}
