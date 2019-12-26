package com.nuclei.exception;


public class NodeNotFoundException extends Exception{
    public NodeNotFoundException(){

    }
    public NodeNotFoundException(String msg){
        System.out.println(msg);
    }
}
