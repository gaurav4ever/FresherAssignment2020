package com.nuclei.exception;

public class InvalidChoiceException extends  Exception{
    public InvalidChoiceException(){

    }

    public InvalidChoiceException(String message){
        super(message);
    }
}
