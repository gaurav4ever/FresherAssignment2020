package com.company;

public class InputCheck {
    public boolean checkName(String name) {
        if (!Character.isAlphabetic(name.charAt(0)))
        {
            System.out.println("Invalid name. Please Re-enter");
            return true;
        }
        return false;
    }
    public boolean checkQuantity(String quantity) {
        if (!quantity.matches("[0-9]*"))
        {
            System.out.println("Invalid quantity. Please Re-enter");
            return true;
        }
        return false;
    }
    public boolean checkPrice(String price) {
        if (!price.matches("[0-9]*.[0-9]*"))
        {
            System.out.println("Invalid price. Please Re-enter");
            return true;
        }
        return false;
    }
    public boolean checkType(String type) {
        if (!type.matches("raw|imported|manufactured"))
        {
            System.out.println("Invalid type. Please Re-enter");
            return true;
        }
        return false;
    }
}
