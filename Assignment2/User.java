import java.util.HashSet;
import java.util.Set;

public class User {

    private String fullName;
    private int age;
    private String Address;
    private int rollNumber;
    Set<String> courses;

    public User() {
        courses = new HashSet<>();
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return Address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }


}