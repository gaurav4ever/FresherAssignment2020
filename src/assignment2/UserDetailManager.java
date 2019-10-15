package assignment2;

import assignment2.exceptions.InvalidUserDetailException;
import assignment2.models.Course;
import assignment2.models.User;

import java.util.*;

public class UserDetailManager {
    Set<User> users ;

    public UserDetailManager() {
        this.users = new TreeSet<>() ;
    }

    private int showMainMenu(){
        System.out.println("1.Add User details");
        System.out.println("2.Display User details");
        System.out.println("3.Delete User details");
        System.out.println("4.Save User details");
        System.out.println("5.Exit\n");
        System.out.println("Enter choice : ");
        return (new Scanner(System.in)).nextInt() ;
    }

//    Get a new user by showing a menu to add the new user
    private User getNewUser() throws InvalidUserDetailException {
        Scanner scan = new Scanner(System.in) ;
        System.out.println("Enter new user details");
        System.out.print("Full Name : "); String name = scan.nextLine() ;
        System.out.print("Age : ");
        int age, roll ;
        try{
            age = Integer.parseInt(scan.nextLine()) ;
            if(age <=0) throw new NumberFormatException() ;
        }
        catch (NumberFormatException e){
            throw new InvalidUserDetailException("Age must be a valid positive integer") ;
        }
        System.out.print("Address : ");
        String address = scan.nextLine() ;
        System.out.print("Roll Number : ");
        try{
            roll = Integer.parseInt(scan.nextLine()) ;
            if(roll <=0) throw new NumberFormatException() ;
        }
        catch (NumberFormatException e){
            throw new InvalidUserDetailException("Roll number must be a valid positive integer") ;
        }
        System.out.print("Courses enrolled : ");

        String[] courses = scan.nextLine().split(" ") ;
        List<Course> coursesList = new ArrayList<>() ;
        for(String course : courses){
            coursesList.add(new Course(course)) ;
        }
        return new User(name , age , address , roll, coursesList) ;
    }

    public void startManager(){
        int choice = showMainMenu();
        while(choice!=5){
            choice = showMainMenu() ;
            switch (choice){
                case 1 :
                    try{
                        User user = getNewUser() ;
                    }
                    catch (InvalidUserDetailException e){
                        System.out.println("Invalid Details entered : " + e.getMessage());
                    }
            }
        }
        System.exit(0);
    }
}
