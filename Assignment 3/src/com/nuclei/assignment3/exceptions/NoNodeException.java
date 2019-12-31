package com.nuclei.assignment3.exceptions;

public class NoNodeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoNodeException() {
		System.out.println("No such node exists");
	}
}
