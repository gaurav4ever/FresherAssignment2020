package assignment1.models;

public class Item {
     public String getName() {
        return mName;
    }
     public Double getTax(){
        return null ;
    }

     public Double getPrice() {
        return mPrice;
    }

    private String mName;
    private Double mPrice;
     public Item(String name, Double price) {
        this.mName = name;
        this.mPrice = price;
    }
}

