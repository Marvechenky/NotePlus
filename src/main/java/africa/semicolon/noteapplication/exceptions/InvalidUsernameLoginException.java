package africa.semicolon.noteapplication.exceptions;

public class InvalidUsernameLoginException extends RuntimeException{
    public InvalidUsernameLoginException(String message) {
        super(message);
    }
}
