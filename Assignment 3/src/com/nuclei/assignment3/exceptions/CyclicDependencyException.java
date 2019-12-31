package com.nuclei.assignment3.exceptions;

public class CyclicDependencyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CyclicDependencyException() {
		System.out.println("Cannot insert, cyclic dependency!");
	}
}
