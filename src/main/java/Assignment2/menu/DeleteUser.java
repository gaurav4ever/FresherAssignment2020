package Assignment2.menu;

import Assignment2.models.User;
import static Assignment2.MenuDriver.CHANGES_MADE;

import java.util.HashMap;
import java.util.Scanner;

public class DeleteUser {
    private Scanner scan;
    public DeleteUser(){
        scan = new Scanner(System.in);
    }
    public HashMap<String, User> delete(HashMap<String, User> users){
        System.out.println("Enter user roll number: ");
        int roll_number = scan.nextInt();

        if(!users.containsKey(roll_number+""))
            System.out.println("Invalid user, User with roll number " + roll_number + " doesn't exist");
        else {
            CHANGES_MADE = true;
            users.remove(roll_number + "");
            System.out.println("User deleted successfully");
        }
        return users;
    }
}
