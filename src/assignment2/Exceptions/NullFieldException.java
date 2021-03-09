package assignment2.Exceptions;

public class NullFieldException extends Exception {
	public NullFieldException() {
		super("The field cannot be empty!");
	}
}
