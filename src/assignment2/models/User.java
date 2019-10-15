package assignment2.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class User implements Comparable<User> {
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

    void display(){
        System.out.println("======================================");
        System.out.println("Name        : " + name);
        System.out.println("Roll Number : " + name);
        System.out.println("Age         : " + name);
        System.out.println("Address     : " + name);
        System.out.println("Courses Enrolled : " + enrolledCourses );
        System.out.println("======================================");
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
