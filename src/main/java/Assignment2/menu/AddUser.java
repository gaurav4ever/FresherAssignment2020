package Assignment2.menu;

import Assignment2.models.User;
import static Assignment2.MenuDriver.CHANGES_MADE;

import java.util.HashMap;
import java.util.Scanner;

public class AddUser {
    private User user;
    private Scanner scan;
    public AddUser(){
        user = new User();
        scan = new Scanner(System.in);
    }
    public HashMap<String, User> add(HashMap<String, User>users){

        System.out.println("Enter the user details:");
        System.out.println("Full name: ");
        do {
            user.setName(scan.nextLine());
        }while(checkValidityofString(user.getName()));

        System.out.println("Address: ");
        do {
            user.setAddress(scan.nextLine());
        }while(checkValidityofString(user.getAddress()));

        System.out.println("Courses (Seperated by camma without spaces)(Valid courses: A B C D E F): ");
        while(true) {
            if(scan.hasNext("[A-F],[A-F],[A-F],[A-F](,[A-F],[A-F])?")) {
                user.setCourses(scan.next("[A-F],[A-F],[A-F],[A-F](,[A-F],[A-F])?"));
                if (!checkValidityOfCourse(user.getCourses()))
                    break;
            }else{
                scan.next();
                System.out.println("Please enter a valid course, Courses must be seperated by camma and between A to F");
            }
        }

        System.out.println("Age: ");
        do {
            user.setAge(scan.nextInt());
        }while(checkValidityofNumber(user.getAge()));


        System.out.println("Roll Number: ");
        do {
            user.setRoll_number(scan.nextInt());
        }while(checkValidityofNumber(user.getRoll_number()));

        if(users.containsKey(user.getRoll_number()+"")){
            System.out.println("User with roll number " + user.getRoll_number() + " already exist");
            return users;
        }
        users.put(user.getRoll_number()+"", user);
        CHANGES_MADE = true;
        System.out.println("User added successfully");
        return users;
    }

    private boolean checkValidityOfCourse(String name) {
        String temp = name.replaceAll(",","");
        String uniq_string = "";
        for (int i = 0; i < temp.length(); i++)
            if (uniq_string.indexOf(temp.charAt(i)) < 0)
                uniq_string = uniq_string + temp.charAt(i);
        if(uniq_string.length()<4) {
            System.out.println("Atleast 4 course must be selected");
            return true;
        }
        return false;
    }

    private boolean checkValidityofString(String name) {
        if(name.equals("")) {
            System.out.println("Please enter a valid data");
            return true;
        }
        return false;
    }
    private boolean checkValidityofNumber(int name) {
        if( name < 0 ) {
            System.out.println("Please enter a positive number");
            return true;
        }
        return false;
    }
}
