package org.nuclei.exception;

public class InvalidItemException extends Exception {
    public InvalidItemException(String msg){
        System.err.println(msg);
    }
}
