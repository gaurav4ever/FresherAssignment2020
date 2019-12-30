package Assignment2;

import java.io.Serializable;

public class User implements Serializable {
    String name, address, courses;
    int roll_number, age;

    public User() {
        this.name = "";
        this.address = "";
        this.courses = "";
        this.roll_number = 0;
        this.age = 0;
    }

    public User(String name, String address, String courses, int roll_number, int age) {
        this.name = name;
        this.address = address;
        this.courses = courses;
        this.roll_number = roll_number;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public int getRoll_number() {
        return roll_number;
    }

    public void setRoll_number(int roll_number) {
        this.roll_number = roll_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "User [name=" + name + ", address=" + address + ", age=" + age + ", roll_number=" + roll_number + ", courses=" + courses + "]";
    }

}
