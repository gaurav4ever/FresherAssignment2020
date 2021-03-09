package assignment2.Exceptions;

public class RollNumberAlreadyExistsException extends Exception {
	public RollNumberAlreadyExistsException() {
		super("The entered Roll Number Already exists!");
	}
}
