package Student;

import java.io.Serializable;

public class student implements Serializable {
    public String Name, Address, Courses;
    public int age, rollNumber;

    public void create(String Name, String address, String Courses, int age, int rollNumber) {
        this.Name = Name;
        this.Address = address;
        this.Courses = Courses;
        this.age = age;
        this.rollNumber = rollNumber;
    }

    public String getName()
    {
        return Name;
    }

    public String getAddress()
    {
        return Address;
    }

    public String getCourses()
    {
        return Courses;
    }

    public int getAge()
    {
        return age;
    }

    public int getRollNo()
    {
        return rollNumber;
    }

}
