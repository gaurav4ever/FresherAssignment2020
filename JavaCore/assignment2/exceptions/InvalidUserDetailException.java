package assignment2.exceptions;

public class InvalidUserDetailException extends RuntimeException {
    public InvalidUserDetailException(String message) {
        super(message);
    }
}
