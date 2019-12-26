package inventory.exception;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InvalidInputType extends Exception{
	/*
	final variables are directly serialized by their values, so there is no use/impact of declaring final variable as transient. There is no compile-time error though.
	 */
	final transient Logger logger = Logger.getLogger(InvalidInputType.class.getName());
	public InvalidInputType() {
		
	}
	public InvalidInputType(String msg) {
		logger.log(Level.INFO,msg);
	}
}
