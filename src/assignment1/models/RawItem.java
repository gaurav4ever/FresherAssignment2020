package assignment1.models;

public class RawItem extends Item {
    private Double mTax;

    public RawItem(String name, Double price) {
        super(name, price);
        mTax = 12.5 / 100 * price;
    }

    @Override
    public Double getTax() {
        return mTax;
    }
}
