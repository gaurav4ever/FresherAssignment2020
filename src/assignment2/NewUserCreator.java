package assignment2;

import assignment2.exceptions.InvalidUserDetailException;
import assignment2.models.Course;
import assignment2.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: 08/01/20 Seperate user methods 
// TODO: 08/01/20 displayUserDetailsInSortedOrderBasedOnUserChoice
// TODO: 08/01/20 deleteUserBasedOnChoice
// TODO: 08/01/20 Strings class to StringConstants  , enum for itemtype , factory pattern

public class NewUserCreator {

    static User getNewUser() throws InvalidUserDetailException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new user details");
        System.out.print("Full Name : ");
        String name = scan.nextLine();
        System.out.print("Age : ");
        int age, roll;
        try {
            age = Integer.parseInt(scan.nextLine());
            if (age <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new InvalidUserDetailException("Age must be a valid positive integer");
        }
        System.out.print("Address : ");
        String address = scan.nextLine();
        System.out.print("Roll Number : ");
        try {
            roll = Integer.parseInt(scan.nextLine());
            if (roll <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            throw new InvalidUserDetailException("Roll number must be a valid positive integer");
        }
        System.out.print("Course enrolled : ");

        String[] courses = scan.nextLine().split(" ");
        List<Course> coursesList = new ArrayList<>(
                Stream.of(courses).map(c -> new Course(c)).collect(Collectors.toList())
        );
        if (coursesList.size() < 4)
            throw new InvalidUserDetailException("Failed adding new user : You must choose at least 4 out of 6 courses ! ");
        return new User(name, age, address, roll, coursesList);
    }
}
