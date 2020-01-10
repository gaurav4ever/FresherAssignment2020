

enum Type{RAW,IMPORTED,MANUFACTURED, DEFAULT}
public class Item {
    private String name;
    private Type type;
    private double price;
    private double quantity, tax;
    private double finalPrice;
    boolean nameFlag, priceFlag, quantityFlag, typeFlag;
    public Item() {
        this.priceFlag = false;
        this.nameFlag = false;
        this.quantityFlag = false;
        this.typeFlag = false;
    }
    public Item(String name, Type type, double price, double quantity, double tax) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice =(tax+price*quantity);
    }

    /*public item(String name, Type type, double price, double quantity, double tax) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.tax = tax;
    }

    public void  assignitem(String iname, Type itype, double iprice, double iquantity ){
        name=iname;
        type=itype;
        price=iprice;
        quantity=iquantity;
        tax=calculatetax();
    }*/

    /*public void  acceptitems(String iname, Type itype, double iprice, double iquantity ){
        this.name=iname;
        this.type=itype;
        this.price=iprice;
        this.quantity=iquantity;
        this.tax=calculatetax();
    }*/
    /* public void accepttype(String itype)
      {
          if(itype.equals("Raw")||itype.equals("Manufactured")||itype.equals("imported"))
          {
              this.type=itype;
          }
          else
          {
              System.out.println("invalid type");
          }
      }*/
    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }


    public double getTax() {
        return tax;
    }


    public double getPrice() {
        return price;
    }



    public double getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setTax() {
        this.tax =calculateTax();
    }

    public double calculateTax (){

        double itax=0;
        switch (type) {
            case RAW:
                itax = price * 0.125;

                break;
            case MANUFACTURED:
                tax = price* 0.125 + (price* 0.125 + price) * 0.02;
                break;
            case IMPORTED:
                tax = 0.1 * price;
                if (itax <= 100) itax += 5;
                else if (itax <= 200) itax += 10;
                else itax += 0.05 * (price + itax);
                break;
        }
    return (itax*quantity);
    }

    public boolean isPriceFlag() {
        return priceFlag;
    }

    public void setPriceFlag(boolean priceFlag) {
        this.priceFlag = priceFlag;
    }

    public boolean isNameFlag() {
        return nameFlag;
    }

    public void setNameFlag(boolean nameFlag) {
        this.nameFlag = nameFlag;
    }

    public boolean isQuantityFlag() {
        return quantityFlag;
    }

    public void setQuantityFlag(boolean quantityFlag) {
        this.quantityFlag = quantityFlag;
    }

    public boolean isTypeFlag() {
        return typeFlag;
    }

    public void setTypeFlag(boolean typeFlag) {
        this.typeFlag = typeFlag;
    }
    @Override
    public String toString() {
        return "name=" + name + ", price=" + price + ", SalesTax=" + tax + ", FinalPrice=" + finalPrice;
    }

}
