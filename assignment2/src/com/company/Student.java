package assignment2.src.com.company;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, address;
    private int age, rollNumber;
    private char courese[] = new char[4];

    public void setName(String name){
        this.name = name;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }

    public void setCourese(int index, char course){
        this.courese[index] = course;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public int getAge(){
        return age;
    }

    public int getRollNumber(){
        return rollNumber;
    }

    public String getCourese(){
        return courese[0]+","+courese[1]+","+courese[2]+","+courese[3];
    }

}
