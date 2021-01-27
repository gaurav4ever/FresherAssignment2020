import java.util.ArrayList;
import java.util.List;

public class CalculateTax extends DatabaseConnection implements Runnable {
    public List<Item> itemTax = new ArrayList<Item>();

    @Override
    public void run() {
        try {
            boolean isThreadEnd = false;
            int index = 0;
            while (true) {
                try {
                    System.out.println("Thread for Tax Calculation is Running");

                    while (!(Main.items.isEmpty() && index < Main.items.size())) {
                        Item item = Main.items.get(index);
                        item = calculateTax(item);
                        itemTax.add(item);
                        index++;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(itemTax.toString());
                if (isThreadEnd) {
                    break;
                } else if (!(Main.thread1.isAlive())) {
                    isThreadEnd = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Item calculateTax(Item item) {
        String type = item.getType();
        double tax, overallTax;
        switch (type) {
            case "raw":
                tax = item.getPrice() * (12.5 / 100);
                item.setTax(tax);
                item.setOverallTax(tax * item.getQuantity());
                break;
            case "manufactured":
                tax = item.getPrice() * (12.5 / 100);
                tax = tax + (item.getPrice() + tax) * 2 / 100;
                item.setTax(tax);
                item.setOverallTax(tax * item.getQuantity());
                break;
            case "imported":
                tax = item.getPrice() * 10 / 100;
                if (tax + item.getPrice() <= 100) {
                    tax += 5;
                } else if (tax + item.getPrice() <= 200) {
                    tax += 10;
                } else {
                    tax += (item.getPrice() + tax) * 5 / 100;
                }
                item.setTax(tax);
                item.setOverallTax(tax * item.getQuantity());
                break;
        }
        return item;
    }

}
