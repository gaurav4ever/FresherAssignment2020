import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        String choice="";
        createItems items=new createItems();
        System.out.println("-name <first item name>\n-price <price of first item>\n -quantity <quantity of first item>\n -type <type of first item>");
        do{

            items.readItems();
            System.out.println("Do you want to enter details of any other item (y/n)");
            Scanner input = new Scanner(System.in);
            choice=input.nextLine();
        }while( choice.equals("y") );
        items.displayItems();
    }
}
