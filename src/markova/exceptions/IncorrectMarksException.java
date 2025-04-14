package markova.exceptions;

public class IncorrectMarksException extends RuntimeException {
    public IncorrectMarksException() {
    super();
  }
    public IncorrectMarksException(String message) {
        super(message);
    }
}
