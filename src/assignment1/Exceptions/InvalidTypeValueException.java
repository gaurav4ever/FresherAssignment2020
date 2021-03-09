package assignment1.Exceptions;

public class InvalidTypeValueException extends Exception {

	public InvalidTypeValueException() {
		super("Invalid value for type provided! Permitted values: raw, imported and manufactured.");
	}

}
