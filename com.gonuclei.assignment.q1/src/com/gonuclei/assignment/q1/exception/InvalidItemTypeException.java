package com.gonuclei.assignment.q1.exception;

public class InvalidItemTypeException extends Exception {
	public InvalidItemTypeException(){
		
	}
	public InvalidItemTypeException(String msg){
		System.out.println(msg);
	}
}
