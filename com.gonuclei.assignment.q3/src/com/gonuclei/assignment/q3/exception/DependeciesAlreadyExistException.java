package com.gonuclei.assignment.q3.exception;


public class DependeciesAlreadyExistException extends Exception {
	public DependeciesAlreadyExistException(){
		
	}
	
	public DependeciesAlreadyExistException(String msg){
		System.out.println("Dependency already Exist");
	}
}
