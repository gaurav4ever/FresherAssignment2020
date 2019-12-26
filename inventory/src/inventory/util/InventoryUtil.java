package inventory.util;

import inventory.constants.Constants;
import inventory.model.Item;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InventoryUtil {

	GetInput getInputService = new GetInput();
	PrintOutput printOutputService = new PrintOutput();
	Logger logger = Logger.getLogger(InventoryUtil.class.getName());
	public void start() {
		while(true) {
			Item item = getInputService.getItems();
			printOutputService.printItem(item);
			logger.log(Level.INFO,Constants.ADD_ANOTHER_ITEM);
			Character ch = getInputService.addNextItem();
			if(ch.equals('n')) {
				logger.log(Level.INFO,Constants.THANK_YOU);
				break;
			}
		}
	}
}
