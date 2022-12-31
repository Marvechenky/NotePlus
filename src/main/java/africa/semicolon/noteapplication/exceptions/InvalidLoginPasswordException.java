package africa.semicolon.noteapplication.exceptions;

public class InvalidLoginPasswordException extends RuntimeException {
    public InvalidLoginPasswordException(String message) {
        super(message);
    }
}
