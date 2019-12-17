package serviceUtil;

import model.Course;
import model.Student;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.fileReadWriteUtil;
public class inputOutputUtil {

    public static Student getInputUserDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the following details:");
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Age: ");
        int age = inputAge();
        System.out.print("Address: ");
        String address = sc.next();
        // Roll Number
        int rno = inputRno();

        // Courses
        int nCourses = inputCourses();
        ArrayList<String> courses = new ArrayList<>();
        System.out.print("Courses Undertaken(A,B,C,D,E,F): ");
        for (int i = 0; i < nCourses; i++) {
            courses.add(sc.next());
        }
        // set and return details of Student and Course objects
        return new Student(rno, name, age, address, new Course(courses));
    }
    private static int inputCourses() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of courses :");
        int n = sc.nextInt();
        if (n>=4) {
            return n;
        } else
            System.out.println("number of courses should be more than or equal to 4");
            return inputCourses();
    }
    // input and verify age
    private static int inputAge() {
        Scanner sc = new Scanner(System.in);
        int age;
        try {
            age = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("\nYou can only enter integer value for age");
            age = inputAge();
        }
        return age;
    }

    // input roll no
    private static int inputRno() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Roll Number : ");
        int rno = sc.nextInt();
        if (checkRno(rno)) {
            return rno;
        } else
            return inputRno();
    }

    private static boolean checkRno(int rno) {
        if (verifyRNo(rno)) {
            return true;
        } else {
            System.out.print("Roll number already exists ");
            return false;
        }
    }
    public static boolean verifyRNo(int rno) {
        List<Student> studentRecordList = new ArrayList<>();
        studentRecordList = fileReadWriteUtil.readFile("studentData.txt");
        for (Student student : studentRecordList) {
            if (student.getRollNumber() == rno) {
                return false;
            }
        }
        return true;
    }

    public static int inputRnoToBeDeleted() {
        System.out.print("enter roll number of the student to be deleted: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }


}
