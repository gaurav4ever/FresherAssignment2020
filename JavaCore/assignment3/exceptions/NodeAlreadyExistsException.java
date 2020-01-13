package assignment3.exceptions;

public class NodeAlreadyExistsException extends Exception {
    public NodeAlreadyExistsException() {
    }

    public NodeAlreadyExistsException(String message) {
        super(message);
    }
}
