package com.nuclei.exception;

public class NodeAlreadyExistException extends Exception{
  public NodeAlreadyExistException(){

  }
  public NodeAlreadyExistException(String msg){
    System.out.println(msg);
  }
}
