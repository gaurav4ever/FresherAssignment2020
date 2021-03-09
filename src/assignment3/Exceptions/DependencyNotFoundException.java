package assignment3.Exceptions;

public class DependencyNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public DependencyNotFoundException() {
		super("The dependency between the given nodes does not exsists!");
	}
}
