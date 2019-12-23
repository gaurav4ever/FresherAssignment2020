package com.utils;

import com.models.ItemDetails;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemDetailOutput {
  private ItemDetailOutput(){}
  static Logger logger = Logger.getLogger(ItemDetailOutput.class.getName());
  public static void itemOutput(ItemDetails item) {
    String itemName = "Item Name    		 :  " + item.getName();
    logger.log(Level.INFO,itemName);
    String itemPrice = "Item Price   		 :  " + item.getPrice();
    logger.log(Level.INFO,itemPrice);
    String itemTax = "Tax per Item		 :  " + item.getTax();
    logger.log(Level.INFO,itemTax);
    String totalPrice = "Total price for " + item.getQuantity() + " items  : " +
        " " + item.getQuantity()*(item.getTax() + item.getPrice());
    logger.log(Level.INFO,totalPrice);
    logger.log(Level.INFO,"-----------------------------------------------------------");
  }
}
