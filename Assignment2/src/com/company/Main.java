package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {


    public Set<Integer> loadRollNumber(){

        Set<Integer> rollNos = null;
        try {
            String filename = "Nuclei:\\rollNos.bin";
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            rollNos = (Set<Integer>) in.readObject();
        } catch (Exception ex) {

            rollNos = new HashSet<>();
            System.out.println("Load Error " + ex);
        }
        return rollNos;
    }


    public TreeSet<User> loadUserList(){
        TreeSet<User> users = null;
        // Deserialization
        try
        {
            // Reading the object from a file
            String filename = "Nuclei:\\users.bin";
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            users = (TreeSet<User>) in.readObject();

            in.close();
            file.close();

        }
        catch(Exception ex)
        {
            users = new TreeSet<>();
        }
        return users;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //error variable used for displaying error
        String error = "Invalid Input !! Try Again!!";


        UserServices service = new UserServices(); //class containing all the services related to the problem
        TreeSet<User> users = loadUserList(); // loading the list of user from the existing file
        service.setUsers(users);
        Set<Integer> uniqueRollNumbers = loadRollNumber(); // loading the list of user from the existing file
        service.setUniqueRollNumbers(uniqueRollNumbers);

        //displaying the main menu
        while (true) {

            System.out.println("Main Menu");
            System.out.println("1. Add User details.");
            System.out.println("2. Display User details.");
            System.out.println("3. Delete User details.");
            System.out.println("4. Save User details.");
            System.out.println("5. Exit.");

            System.out.println("Choose an option (1,2,3,4,5) : ");
            int choice;
            //handling the integer or other exception
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
}
