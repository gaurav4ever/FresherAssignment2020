package assignment3.Exceptions;

public class CyclicDependencyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CyclicDependencyException() {
		super("Cyclic Dependency found! Cannot add dependency..");
	}
}
