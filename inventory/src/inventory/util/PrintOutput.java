package inventory.util;

import inventory.model.Item;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrintOutput {
  Logger logger = Logger.getLogger(PrintOutput.class.getName());
  public void printItem(Item item) {
    logger.log(Level.INFO,"Item Name	  : "+ item.getName());
    logger.log(Level.INFO,"Item Price           : "+ item.getPrice());
    logger.log(Level.INFO,"Tax on single Item          : "+ item.getTax());
    double itemPrice = item.getPrice() + item.getQuantity()*item.getTax();
    String str = "Overall Price :"+itemPrice;
    logger.log(Level.INFO,str );
  }
}
