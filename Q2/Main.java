package assignment2;

import assignment2.models.User;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static String filename = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath()
            + "/../../../data/userDetails.bin";

    public static boolean saveUserDetails(UsersDetails userDetailsObj) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(userDetailsObj);
            out.close();
            file.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("user details are not saved");
            return false;
        }
    }

    public static UsersDetails deserializeUserDetails() {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            UsersDetails userDetailsObj = (UsersDetails) in.readObject();
            return userDetailsObj;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("could not deserialize object");
            return null;
        }
    }

    public static void main(String args[]) {
        Boolean flag = true;
        UsersDetails userDetailsObj = deserializeUserDetails();
        if (userDetailsObj == null) {
            userDetailsObj = new UsersDetails();
        }
        while (flag) {
            System.out.println("Choices :\n" + " 1. Add User Details\n" + " 2. Display User Details\n"
                    + " 3. Delete User Details\n" + " 4. Save User Details\n" + " 5. Exit\n");

            int choice = sc.nextInt();
            switch (choice) {
            case 1:
                try {
                    System.out.print("Name : ");
                    sc.nextLine();
                    String name = sc.nextLine();

                    System.out.print("Age : ");
                    int age = sc.nextInt();
                    System.out.print("Address : ");
                    sc.nextLine();
                    String address = sc.nextLine();

                    System.out.print("Rollno : ");
                    String rollno = sc.next();

                    ArrayList<Character> cources = new ArrayList<Character>();
                    char course = 'A';
                    while (course <= 'F') {
                        System.out.print("enroll for course " + course + " (y/n) : ");
                        String answer = sc.next();
                        if (answer.equals("y")) {
                            cources.add(course);
                        }
                        course++;
                    }
                    userDetailsObj.addUser(new User(name, rollno, address, age, cources));
                    System.out.println(" done : user added ");
                } catch (Exception e) {
                    System.out.println("failed : to add user ");
                    e.printStackTrace();
                }
                break;
            case 2:
                System.out.print("Display user Details by : \n" + "1. asc by name\n" + "2. desc by name\n"
                        + "3. asc by rollno\n" + "4. desc by rollno\n" + "5. asc by addres \n" + "6. desc by address\n"
                        + "7. asc by age \n" + "8.desc by age\n");
                int orderChoice = sc.nextInt();

                System.out.println(" Name    Rollno   Address       age        courses  ");
                switch (orderChoice) {
                case 1:
                    userDetailsObj.displayAllUserSortedByNameAsc();
                    break;
                case 2:
                    userDetailsObj.displayAllUserSortedByNameDesc();
                    break;
                case 3:
                    userDetailsObj.displayAllUserSortedByRollnoAsc();
                    break;
                case 4:
                    userDetailsObj.displayAllUserSortedByRollnoDesc();
                    break;
                case 5:
                    userDetailsObj.displayAllUserSortedByAddressAsc();
                    break;
                case 6:
                    userDetailsObj.displayAllUserSortedByAddressDesc();
                    break;
                case 7:
                    userDetailsObj.displayAllUserSortedByAgeAsc();
                    break;
                case 8:
                    userDetailsObj.displayAllUserSortedByAgeDesc();
                    break;
                }
                break;
            case 3:
                System.out.print("Enter the rollno of user to be deleted : ");
                try {
                    String rollno = sc.next();
                    userDetailsObj.deleteUser(rollno);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 4:
                saveUserDetails(userDetailsObj);
                break;
            case 5:
                flag = false;
                System.out.println("Do you want to save users details y/n");
                String ans = sc.next();
                if ("y".equals(ans))
                    saveUserDetails(userDetailsObj);
                break;
            default:
                System.out.println("Invalid choice");
            }
        }
    }
}