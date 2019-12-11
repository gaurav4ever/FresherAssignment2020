package exception;

public class InvalidItemTypeException extends Exception{
	public InvalidItemTypeException() {
		
	}
	public InvalidItemTypeException(String e) {
		System.out.println(e);
	}
}
