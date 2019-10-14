package assignment1;

class ItemDetail {
    Item item ;
    int quantity ;

     ItemDetail(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

}

 class Item {
     String getName() {
        return mName;
    }
     Double getTax(){
        return null ;
    }

     Double getPrice() {
        return mPrice;
    }

    private String mName;
    private Double mPrice;
     Item(String name, Double price) {
        this.mName = name;
        this.mPrice = price;
    }
}

class RawItem extends Item{
    private Double mTax;

    @Override
     Double getTax() {
        return mTax;
    }

     RawItem(String name , Double price) {
        super(name , price) ;
        mTax = 12.5/100 * price ;
    }
}

class ManufacturedItem extends Item{
    @Override
     Double getTax() {
        return mTax;
    }

    private Double mTax;
     ManufacturedItem(String name, Double price) {
        super(name, price);
        mTax = 12.5/100 * price ; // 12.5 % of price
        mTax += 2.0/100 * (price + mTax) ;  //  12.5 % of price + 2% of ( price + 12.5% of price)
    }
}

class ImportedItem extends Item{
    private Double mTax;

    @Override
     Double getTax() {
        return mTax ;
    }

     ImportedItem(String name, Double price) {
        super(name, price);
        mTax = 10.0/100 * price  ;
        if(mTax<=100) mTax+=5 ;
        else if(mTax>=100 && mTax<=200) mTax+=10 ;
        else mTax+= 5.0/100 * (mTax+price) ; // 5 % of final cost which means original price + tax
    }
}
