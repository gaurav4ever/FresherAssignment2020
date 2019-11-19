package assignment2.Exceptions;

public class InvalidNameFieldException extends Exception {
	public InvalidNameFieldException() {
		super("Invalid Name! Can only contain letters and whitespaces!");
	}
}
