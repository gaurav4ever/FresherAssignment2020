package assignmentQ1.model;

// Properties of item
public class Item {
//    Constructor
    public Item(String productName, double productPrice, int productQuantity, int productType) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productType = productType;
    }

    public String productName;
    public double productPrice;
    public int productQuantity;
    public int productType;


}
