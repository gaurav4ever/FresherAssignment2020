package assignment2.util;

import assignment2.exceptions.InvalidUserDetailException;
import assignment2.models.Course;
import assignment2.models.User;
import assignment2.util.UserUtil;

import java.util.List;

public class NewUserCreatorUtil {
   public static User getNewUser() throws InvalidUserDetailException {
        System.out.println("Enter new user details");
        String name = UserUtil.getName() ;
        System.out.print("Age : ");
        int age =  UserUtil.getAge() ;
        int  roll = UserUtil.getRollNumber() ;
        String address = UserUtil.getAddress() ;
        List<Course> coursesList = UserUtil.getEnrolledCourses() ;
        if (coursesList.size() < 4)
            throw new InvalidUserDetailException("Failed adding new user : You must choose at least 4 out of 6 courses ! ");
        return new User(name, age, address, roll, coursesList);
    }
}
