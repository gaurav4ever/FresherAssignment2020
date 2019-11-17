package com.assignment1;

public class InvalidTypeException extends Exception{
	public InvalidTypeException() {
		
	}
	public InvalidTypeException(String e) {
		System.out.println(e);
	}

}
