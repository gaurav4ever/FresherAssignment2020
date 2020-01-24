package assignment1.src.com.company;

// class has methods to read and validate input
public class InputCheck {

    // validate name
    public boolean checkName( final String name) {
        if (!Character.isAlphabetic(name.charAt(0)))
        {
            System.out.println("Invalid name. Please Re-enter");
            return true;
        }
        return false;
    }

    //validate Quantity
    public boolean checkQuantity(final String quantity) {
        if (!quantity.matches("[0-9]*"))
        {
            System.out.println("Invalid quantity. Please Re-enter");
            return true;
        }
        return false;
    }

    //validate Price
    public boolean checkPrice(final String price) {
        if (!price.matches("[0-9]*.[0-9]*"))
        {
            System.out.println("Invalid price. Please Re-enter");
            return true;
        }
        return false;
    }

    //validate Type
    public boolean checkType(final String type) {
        if (!type.matches("raw|imported|manufactured"))
        {
            System.out.println("Invalid type. Please Re-enter");
            return true;
        }
        return false;
    }
}
