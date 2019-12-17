package com.nuclei.exception;

public class CyclicGraphException extends Exception {
  public CyclicGraphException(){

  }
  public CyclicGraphException(String msg){
    System.out.println(msg);
  }
}
