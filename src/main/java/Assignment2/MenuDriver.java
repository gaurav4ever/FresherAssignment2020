package Assignment2;

import Assignment2.menu.AddUser;
import Assignment2.menu.DeleteUser;
import Assignment2.menu.DisplayUser;
import Assignment2.menu.SaveUser;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MenuDriver {
    private Scanner scan;
    private HashMap<String, User> users;
    public static boolean CHANGES_MADE = false;
    MenuDriver(){
        scan = new Scanner(System.in);
        users = new HashMap<>();
        retrieveObjects();
    }
    void start()
    {
        System.out.println("Welcome to user manager tool");
        boolean terminate = false;
        while(!terminate){
            System.out.println("Choose any of the available options");
            System.out.println("1.Add User details\n2.Display User details\n3.Delete User details\n4.Save User details\n5.Exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    users = new AddUser().add(users);
                    break;
                case 2:
                    new DisplayUser().display(users);
                    break;
                case 3:
                    users = new DeleteUser().delete(users);
                    break;
                case 4:
                    new SaveUser().storeObject(users);
                    break;
                case 5:
                    if(CHANGES_MADE)
                    {
                        System.out.println("Do you want to save your latest changes (yes/no): ");

                        if(scan.next().equals("yes"))
                            new SaveUser().storeObject(users);
                    }
                    System.out.println("Thank you");
                    terminate = true;
                    break;
                default:
                    System.out.println("Please enter a valid option...");
            }
        }
    }

    private void retrieveObjects(){
        try{
            File toRead=new File("userdetails.dat");
            FileInputStream fis=new FileInputStream(toRead);
            ObjectInputStream ois=new ObjectInputStream(fis);
            users = (HashMap<String,User>)ois.readObject();
            ois.close();
            fis.close();
        }catch(Exception ignored){}
    }

}
