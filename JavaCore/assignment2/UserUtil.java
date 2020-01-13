package assignment2;

import assignment2.exceptions.InvalidUserDetailException;
import assignment2.models.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserUtil {

    private static Scanner scan  ;

    public UserUtil() {
        scan = new Scanner(System.in) ;
    }

    public static void showFieldChoicesForSorting(){
        System.out.println("1. Name");
        System.out.println("2. roll number");
        System.out.println("3. age");
        System.out.println("4. address");
        System.out.print("On what field should the users be sorted on (Enter choice) :  ");
    }
    public static void showChoiceForSortingOrder(){
        System.out.println("1. Ascending order ");
        System.out.println("2. Descending order");
        System.out.print("Enter choice : ");
    }
    public static void showUserDisplayHeader(){
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("Name\t\t\t\t\tRoll Number\t\t\t\t\tAge\t\t\t\t\tAddress\t\t\t\t\tCourses");
        System.out.println("-------------------------------------------------------------------------------------------------");
    }
    public static String getName(){
        System.out.print("Full Name : ");
        return scan.nextLine();
    }

    public static int getAge(){
        System.out.print("Age : ");
        int age ;
        try {
            age = Integer.parseInt(scan.nextLine());
            if (age <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new InvalidUserDetailException("Age must be a valid positive integer");
        }
        return age ;
    }


    public static int getRollNumber(){
        System.out.print("Roll Number : ");
        int roll ;
        try {
            roll = Integer.parseInt(scan.nextLine());
            if (roll <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new InvalidUserDetailException("Roll number must be a valid positive integer");
        }
        return roll ;
    }

    public static String getAddress(){
        System.out.print("Address : ");
        String address = scan.nextLine();
        return address ;
    }

    public static List<Course> getEnrolledCourses(){
        System.out.print("Course enrolled : ");
        String[] courses = scan.nextLine().split(" ");
        List<Course> coursesList = new ArrayList<>(
                Stream.of(courses).map(c -> new Course(c)).collect(Collectors.toList())
        );
        return coursesList ;
    }
}
