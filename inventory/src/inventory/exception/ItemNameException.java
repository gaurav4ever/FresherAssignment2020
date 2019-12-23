package inventory.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemNameException extends Exception {
	final transient Logger logger = Logger.getLogger(ItemNameException.class.getName());
	public ItemNameException() {
		
	}
	public ItemNameException(String msg) {
		logger.log(Level.INFO,msg);
	}
}
