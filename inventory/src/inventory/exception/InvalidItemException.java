package inventory.exception;

public class InvalidItemException extends Exception {
	public InvalidItemException() {
		
	}
	public InvalidItemException(String message) {
		System.out.println(message);
	}
}
