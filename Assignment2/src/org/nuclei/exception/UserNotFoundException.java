package org.nuclei.exception;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        System.out.println(("User not found"));
    }

    public UserNotFoundException(String msg) {

    }
}
