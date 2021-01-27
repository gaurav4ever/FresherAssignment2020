package Student;

import java.io.Serializable;
import java.util.Scanner;

public class Main implements Serializable {

    public static void main(String[] args) {
        functionality f=new functionality();
        f.readFromFile();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Menu");
            System.out.println("1. Add User details");
            System.out.println("2. Display User details");
            System.out.println("3. Delete User details");
            System.out.println("4. Save User details");
            System.out.println("5. Exit");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println(f.addDetails());
                    break;
                case 2:
                    f.displayDetails();
                    break;
                case 3:
                    f.deleteDetails();
                    break;
                case 4:
                    f.saveDetails();
                    break;
                case 5:
                    flag = f.end();
                    break;
                default:
                    System.out.println("Invalid option");
                    break;

            }
        }
    }
}
