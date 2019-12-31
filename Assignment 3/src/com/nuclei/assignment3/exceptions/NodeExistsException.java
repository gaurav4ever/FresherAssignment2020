package com.nuclei.assignment3.exceptions;

public class NodeExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NodeExistsException() {
		System.out.println("Node already exists!");
	}
}
