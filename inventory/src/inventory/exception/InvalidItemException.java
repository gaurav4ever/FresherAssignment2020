package inventory.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidItemException extends Exception {
	final transient Logger logger = Logger.getLogger(InvalidItemException.class.getName());
	public InvalidItemException() {
		
	}
	public InvalidItemException(String message) {
		logger.log(Level.INFO,message);
	}
}
