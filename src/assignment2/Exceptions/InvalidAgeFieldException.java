package assignment2.Exceptions;

public class InvalidAgeFieldException extends Exception {
	public InvalidAgeFieldException() {
		super("Age cannot be -ve or zero");
	}
}
