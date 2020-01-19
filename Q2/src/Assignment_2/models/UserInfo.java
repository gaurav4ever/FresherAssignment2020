package Assignment_2.models;

import java.io.Serializable;
import java.util.Comparator;

public class UserInfo implements Serializable, Comparable<UserInfo>{
    public static final long serialVersionUID = 1L;
    public String name;
    public int age;
    public String address;
    public int rollNumber;
    public String [] courses = new String[4];

    //getName
    public String getName(){
        return name;
    }

    //setName
    public void setName(final String newName) throws Exception {
        if (newName.length() <= 0) {
            throw new Exception("Invalid Name.");
        }
        name = newName;
    }

    // getAge
    public int getAge() {
        return age;
    }

    // setAge
    public void setAge(final int newAge) throws Exception {
        if (newAge <= 0) {
            throw new Exception("Invalid Age.");
        }
        age = newAge;
    }

    // getAddress
    public String getAddress() {
        return address;
    }

    // setAddress
    public void setAddress(final String newAddress) throws Exception {
        if (newAddress.length() <= 0) {
            throw new Exception("Invalid Address.");
        }
        address = newAddress;
    }

    // getRollNumber
    public int getRollNumber() {
        return rollNumber;
    }

    // setRollNumber
    public void setRollNumber(final int newRollNumber) throws Exception {
        if (newRollNumber <= 0) {
            throw new Exception("Invalid Roll Number.");
        }
        rollNumber = newRollNumber;
    }

    // getCources
    public String[] getCources() {
        return courses;
    }

    // setCources
    public void setCourses(final String[] newCourses) throws Exception {
        courses = newCourses;
    }

    //comparable
    public int compareTo(UserInfo user){
        if(name.compareTo(user.name)==0){
            if(rollNumber==user.rollNumber){
                return 0;
            }
            else if(rollNumber>user.rollNumber){
                return 1;
            }
            else{
                return 0;
            }
        }
        else if(name.compareTo(user.name)>0){
            return 1;
        }
        else{
            return -1;
        }

    }

}
