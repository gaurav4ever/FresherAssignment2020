package assignment2.src.com.company;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String  address;
    private int age;
    private int rollNumber;
    private char courese[] = new char[4];

    public Student () {
        name = "";
        address = "";
        age = 0;
        rollNumber = 0;
    }


    public String getName () {
        return name;
    }

    public void setName ( final String name ) {
        this.name = name;
    }

    public String getAddress () {
        return address;
    }

    public void setAddress ( final String address ) {
        this.address = address;
    }

    public int getAge () {
        return age;
    }

    public void setAge ( final int age ) {
        this.age = age;
    }

    public int getRollNumber () {
        return rollNumber;
    }

    public void setRollNumber ( final int rollNumber ) {
        this.rollNumber = rollNumber;
    }

    public char[] getCourese () {
        return courese;
    }

    public void setCourese ( final char[] courese ) {
        this.courese = courese;
    }
}
