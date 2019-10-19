package assignment2.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class User implements Comparable<User> , Serializable {
    private String name ;
    private int age ;
    private String address ;
    private int rollNumber ;
    private List<Course> enrolledCourses;

    public User(String name, int age, String address, int rollNumber, List<Course> enrolledCourses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.enrolledCourses = enrolledCourses;
    }

    public void display(){
        System.out.printf("%s\t\t\t\t\t%d\t\t\t\t\t\t\t%d\t\t\t\t\t%s\t\t\t\t\t%s\n\n" , name , rollNumber , age, address , enrolledCourses);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    @Override
    public int compareTo(User o) {
        if(name.equals(o.name))
            return rollNumber - o.rollNumber ;
        return name.compareTo(o.name) ;
    }
}
