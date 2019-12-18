package service;

import model.Course;
import model.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.FileReadWriteUtil;

public class InputOutputUtil {
    public static final Scanner scan = new Scanner(System.in);

    public static Student getInputUserDetails() {
        System.out.println("Enter the following details:");
        System.out.print("Name: ");
        String name = scan.next();
        System.out.print("Age: ");
        final int age = inputAge();
        System.out.print("Address: ");
        final String address = scan.next();
        // Roll Number
        final int rno = inputRno();
        // Courses
        final int nCourses = inputCourses();
        ArrayList<String> courses = new ArrayList<>();
        System.out.print("Courses Undertaken(A,B,C,D,E,F): ");
        for (int i = 0; i < nCourses; i++) {
            courses.add(scan.next());
        }
        // set and return details of Student and Course objects
        return new Student(rno, name, age, address, new Course(courses));
    }
//to be changed to non static methods (check for all methods implemented)
    private static int inputCourses() {
        System.out.println("Enter number of courses :");
        int number_of_course = scan.nextInt();
        if (number_of_course >= 4) {
            return number_of_course;
        } else {
            System.out.println("number of courses should be more than or equal to 4");
            return inputCourses();
        }
    }

    // input and verify age

    private static int inputAge() {
        int age;
        try {
            age = scan.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("\nYou can only enter integer value for age");
            age = inputAge();
        }
        return age;
    }

    // input roll no
    private static int inputRno() {
        System.out.print("Enter Roll Number : ");
        int rno = scan.nextInt();
        if (verifyRNo(rno)) {
            return rno;
        } else
        {System.out.print("Roll number already exists ");
            return inputRno();}
    }

    public static boolean verifyRNo(int rno) {
        List<Student> studentRecordList;
       try {
           studentRecordList = FileReadWriteUtil.readFile("src/resource/studentData.txt");
           for (Student student : studentRecordList) {
               if (student.getRollNumber() == rno) {
                   return false;
               }
           }
       }catch(Exception e)
       {
           System.err.print("no student record file found");
       }
        return true;
    }

    public static int inputRnoToBeDeleted() {
        System.out.print("enter roll number of the student to be deleted: ");
        return scan.nextInt();
    }


}
