package assignment3.Exceptions;

public class NodeAlreadyExistsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NodeAlreadyExistsException(int id) {
		super("Node with id: " + id + "Already exists!");
	}
}
