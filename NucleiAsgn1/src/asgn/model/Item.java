package asgn.model;

//Class to describe the properties of item
public class Item {
  public String name;
  public double price ;
  public int quantity;
  public int type;
  
  /**
   *
   * @param name
   * @param price
   * @param quantity
   * @param type
   */
  public Item(String name, double price, int quantity, int type) {
      this.name = name;
      this.price= price;
      this.quantity =quantity;
      this.type = type;
  }
  
  public String getname() {
      return name;
  }
  public double getPrice() {
      return price;
  }
  public int getQuantity() {
      return quantity;
  }
  public int getType() {
      return type;
  }
}