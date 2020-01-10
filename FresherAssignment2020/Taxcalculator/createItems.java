import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class createItems {

    private List<Item> items;
    private Scanner input;
    //constructor
    createItems(){
        input = new Scanner(System.in);
        items = new ArrayList<>();
    }
    public void readItems()
    {
        Item item = new Item();
        System.out.println("Enter the item details: ");
        checkInput(item);
        addItem(item);
        System.out.println("Item added successfully");
    }

    String addItem(Item item) {
        if(item.getName().equals(""))
            return ("No name entered");
        if(item.getPrice()<0)
            return ("price should be positive");
        if(item.getQuantity()<0)
            return ("Quantity should be positive");
        if((item.getType().equals("")))
            return ("Enter the type");

        items.add(item);
        return "item added successfully";
    }

    public void displayDetails() {
        System.out.println("Name \t\tPrice \t\tTax \t\tFinal Price");
        System.out.println("----\t\t-----\t\t----------\t\t-----------");
        for( Item it: items)
            System.out.println(it.getName() + "\t\t" + it.getPrice() + "\t\t" + it.getTax() + "\t\t" + (it.getPrice() + it.getTax()));
    }
    public void displayItems()
    {
        for( Item item: items)
            System.out.println(item);

    }
    private void checkInput(Item item) {
        String name="";
        Type value = Type.RAW;

        double price = 0;
        double quantity = 0;

        for (int i = 0; i < 4; i++) {
            System.out.print("--> ");
            String cmd = input.next();
            if (cmd.equals("-name") && input.hasNext()) {
                if (item.isNameFlag()) {
                    System.out.println("Name is already added...");
                    i--;
                    input.next();
                    continue;
                }
                item.setName(input.nextLine());
                //name=input.nextLine();
                item.setNameFlag(true);
                System.out.println("Name added");
            } else if (cmd.equals("-price") && input.hasNextDouble()) {
                if (item.isPriceFlag()) {
                    System.out.println("Price is already added...");
                    i--;
                    input.next();
                    continue;
                }
                item.setPrice(input.nextDouble());
                item.setPriceFlag(true);
                System.out.println("Price added");
            } else if (cmd.equals("-quantity") && input.hasNextDouble()) {
                if (item.isQuantityFlag()) {
                    System.out.println("Quantity is already added...");
                    i--;
                    input.next();
                    continue;
                }
                item.setQuantity(input.nextDouble());
                item.setQuantityFlag(true);
                System.out.println("Quantity added");
            } else if (cmd.equals("-type") && input.hasNext()) {
                if (item.isTypeFlag()) {
                    System.out.println("Type is already added...");
                    i--;
                    input.next();
                    continue;
                }
                // tp.valueOf(scan.next());
                //  tp=scan.next();
                item.setType(Type.valueOf(input.next().toUpperCase()));
                item.setTypeFlag(true);
                System.out.println("Type added");
            } else {
                System.out.println("Please enter a valid input...");
                i--;
                input.next();
            }

        }
        item.setTax();
        item.setFinalPrice();

    }
}
