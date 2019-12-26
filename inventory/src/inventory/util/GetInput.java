package inventory.util;

import inventory.constants.Constants;
import inventory.model.Item;
import inventory.service.GetItemFactory;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetInput {
  Scanner sc=new Scanner(System.in);
  Logger logger = Logger.getLogger(GetInput.class.getName());
  public Item getItems() {
    logger.log(Level.INFO,"Enter item details : ");

    // add exception for name type to be string
    logger.log(Level.INFO,"-name");
    String name = sc.nextLine();

    logger.log(Level.INFO,"-price");
    double price = sc.nextDouble();

    logger.log(Level.INFO,"-quantity");
    int quantity = sc.nextInt();

    logger.log(Level.INFO,"-type \t1.raw\t2.manufactured\t3.imported");
    String type = sc.next();
    Item item = GetItemFactory.getItem(type);
    while(item == null) {
      logger.log(Level.INFO,"Invalid item type. Re-enter item type");
      type = sc.next();
      item = GetItemFactory.getItem(type);
    }

    item.setName(name);
    item.setPrice(price);
    item.setQuantity(quantity);
    item.calculateTaxes();

    sc.nextLine();
    return item;
  }

  public char addNextItem() {
    logger.log(Level.INFO,Constants.ADD_ANOTHER_ITEM);
    char ch = sc.next().toLowerCase().charAt(0);
    if(ch == 'n' || ch == 'y'){
      return ch;
    }
    else{
      logger.log(Level.INFO,Constants.INCORRECT_INPUT);
      return addNextItem();
    }
  }

}
