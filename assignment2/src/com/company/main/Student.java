package com.company.main;
import java.util.Comparator;
import java.util.List;
import java.io.Serializable;

public class Student implements Serializable{
    public String name, addr, courses;
    public int age, rollNo;

    public void Assign(String name, String addr,String courses, int age, int rollNo){
        this.name = name;
        this.addr = addr;
        this.courses = courses;
        this.age = age;
        this.rollNo = rollNo;
    }
    public String getName()
    {
        return name;
    }

    public String getAddr()
    {
        return addr;
    }

    public String getCourses()
    {
        return courses;
    }

    public int getAge()
    {
        return age;
    }

    public int getRollNo()
    {
        return rollNo;
    }

    @Override
    public String toString(){
        return (name +"\t\t"+ age +"\t\t"+ addr + "\t\t" + rollNo + "\t\t" + courses +" ");
    }

    public static Comparator<Student> stuNameComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            String StudentName1 = s1.getName().toUpperCase();
            String StudentName2 = s2.getName().toUpperCase();

            if(StudentName1.equals(StudentName2))
            {
                int StudentRoll1 = s1.getRollNo();
                int StudentRoll2 = s2.getRollNo();

                return StudentRoll1-StudentRoll2;
            }
            return StudentName1.compareTo(StudentName2);
        }};

    public static Comparator<Student> stuRollComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            int StudentRoll1 = s1.getRollNo();
            int StudentRoll2 = s2.getRollNo();

            return StudentRoll1-StudentRoll2;
        }};

    public static Comparator<Student> stuAgeComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            int StudentAge1 = s1.getAge();
            int StudentAge2 = s2.getAge();

            return StudentAge1-StudentAge2;
        }};

    public static Comparator<Student> stuAddrComparator = new Comparator<Student>() {
        @Override
        public int compare(Student s1, Student s2) {
            String StudentAddr1 = s1.getAddr().toUpperCase();
            String StudentAddr2 = s2.getAddr().toUpperCase();

            return StudentAddr1.compareTo(StudentAddr2);
        }};
}
