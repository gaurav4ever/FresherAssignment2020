package org.nuclei.exception;

public class InvalidItemException extends Exception {
    public InvalidItemException(String msg){
        System.out.println(msg);
    }
}
