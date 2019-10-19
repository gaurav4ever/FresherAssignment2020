package assignment1.models;

public class ImportedItem extends Item{
    private Double mTax;

    @Override
    public Double getTax() {
        return mTax ;
    }

     public ImportedItem(String name, Double price) {
        super(name, price);
        mTax = 10.0/100 * price  ;
        if(mTax<=100) mTax+=5 ;
        else if(mTax>=100 && mTax<=200) mTax+=10 ;
        else mTax+= 5.0/100 * (mTax+price) ; // 5 % of final cost which means original price + tax
    }
}
