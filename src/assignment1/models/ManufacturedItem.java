package assignment1.models;

public class ManufacturedItem extends Item {
    private Double mTax;

    public ManufacturedItem(String name, Double price) {
        super(name, price);
        mTax = 12.5 / 100 * price; // 12.5 % of price
        mTax += 2.0 / 100 * (price + mTax);  //  12.5 % of price + 2% of ( price + 12.5% of price)
    }

    @Override
    public Double getTax() {
        return mTax;
    }
}
