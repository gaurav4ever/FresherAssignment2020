package org.nuclei.exception;

public class CyclicGraphException extends Exception {

    public CyclicGraphException() {
    }

    public CyclicGraphException(String message) {
        super(message);
    }
}
