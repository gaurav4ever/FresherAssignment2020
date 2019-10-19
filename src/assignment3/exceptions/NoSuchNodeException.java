package assignment3.exceptions;

public class NoSuchNodeException extends Exception {
    public NoSuchNodeException() {
    }

    public NoSuchNodeException(String message) {
        super(message);
    }
}
