package com.company;

public class TaxCalculator {
    void calculate() {
        System.out.println("Thread 2 in TaxCalculator - calculate()");
        int index = 0;
        while (true) {
            System.out.println("TaxCalculator - calculate() - while1");
            System.out.println("");
            if (index == Details.items.size() && Details.completed) {
                System.out.println("Thread 2 in TaxCalculator - calculate() - if 2");
                System.out.println("Tax calculated ");
                break;
            }
            while (Details.lock);
            Details.lock = true;
            if (index > (Details.items.size() - 1)) {
                Details.lock = false;
                continue;
            }
            Item item = Details.items.get(index);
            Details.lock = false;
            double tax = 0;
            switch (item.getType()) {
                case RAW:
                    tax = item.getPrice() * 0.125;
                    break;
                case MANUFACTURED: tax = item.getPrice() * 0.125 + (item.getPrice() * 0.125 + item.getPrice()) * 0.02;
                    break;
                case IMPORTED:
                    tax = 0.1 * item.getPrice();
                    if (tax <= 100) tax += 5;
                    else if (tax <= 200) tax += 10;
                    else tax += 0.05 * (item.getPrice() + tax);
                    break;
                }
                item.setTax(tax * item.getQuantity());
                displayDetails(item, index + 1);
                while (Details.lock);
                Details.lock = true;
                Details.items.get(index).setTax(tax * item.getQuantity());
                index++;
                Details.lock = false;
        }
    }
    public void displayDetails(Item item , int index){
        System.out.println("Tax calculated for item "+index+" \t=>\tNAME: " + item.getName() + "\tPRICE: " +
        item.getPrice() + "\tTYPE: " + item.getType() + "\tTAX: " + item.getTax() + "\tFINAL PRICE: " +
                (item.getPrice()*item.getQuantity() + item.getTax()));
    }
}

