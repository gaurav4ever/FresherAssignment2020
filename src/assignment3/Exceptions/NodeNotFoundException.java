package assignment3.Exceptions;

public class NodeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NodeNotFoundException() {
		super("The Node does not exist!");
	}
}
