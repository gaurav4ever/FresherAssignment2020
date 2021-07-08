package assignment3.exceptions;

public class CyclicDependencyException extends Exception {
    public CyclicDependencyException() {
    }

    public CyclicDependencyException(String message) {
        super(message);
    }
}
