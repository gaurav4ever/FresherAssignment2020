package inventory.exception;

public class InvalidInputType extends Exception{
	public InvalidInputType() {
		
	}
	public InvalidInputType(String msg) {
		System.out.println(msg);
	}
}
