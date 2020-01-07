import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main{

    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
       
        String error = "Invalid Input !! Try Again!!";

       UserServices service = new UserServices();
        while (true) {

            System.out.println("Main Menu");
            System.out.println("1. Add User details.");
            System.out.println("2. Display User details.");
            System.out.println("3. Delete User details.");
            System.out.println("4. Save User details.");
            System.out.println("5. Exit.");

            System.out.println("Choose an option (1,2,3,4,5) : ");
            int choice;
           
            while (true) {
                try {
                    choice = Integer.parseInt(sc.next());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println(error);
                }
            }

            switch (choice) {
                case 1:
                    service.addUser();
                    break;
                case 2:
                    service.displayUser();
                    break;
                case 3:
                    service.deleteUser();
                    break;
                case 4:
                    service.saveToDisk();
                    break;
                case 5:
                    service.exitRequest();
                    return;
            }
        }
    }
}
