package assignment2;
import java.io.Serializable;
import java.util.*;

public class User implements Comparable<User>, Serializable {
    String name;
    int age;
    String address;
    int rollNumber;
    Set<String> courses;

    public User(String name, int age, String address, int rollNumber, Set<String> courses) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.rollNumber = rollNumber;
        this.courses = courses;
    }

    public void print() {
        System.out.printf("%s\t\t%d\t\t%d\t%s\t%s\n", name, rollNumber, age, address, courses);
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

    public Set<String> getEnrolledCourses() {
        return courses;
    }

    @Override
    public int compareTo(User x) {
        if (name.equals(x.name))
            return rollNumber - x.rollNumber;
        return name.compareTo(x.name);
    }
}
