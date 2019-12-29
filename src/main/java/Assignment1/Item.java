package Assignment1;

class Item {
    private String name, type;
    private double price, tax, quantity;
    private boolean priceFlag, nameFlag, quantityFlag, typeFlag;

    Item() {
        this.priceFlag = false;
        this.nameFlag = false;
        this.quantityFlag = false;
        this.typeFlag = false;
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

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getType() {
        return type;
    }

    void setType(String type) {
        this.type = type;
    }

    double getTax() {
        return tax;
    }

    void setTax(double tax) {
        this.tax = tax;
    }

    double getPrice() {
        return price;
    }

    void setPrice(double price) {
        this.price = price;
    }

    double getQuantity() {
        return quantity;
    }

    void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
