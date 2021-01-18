package org.nuclei.exception;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException() {
        System.out.println(("User already exists with given Roll number"));
    }

    public UserAlreadyExistsException(String msg) {

    }
}
