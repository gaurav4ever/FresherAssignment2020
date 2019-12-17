package serviceUtil;

import model.Student;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import util.*;
import static serviceUtil.inputOutputUtil.inputRnoToBeDeleted;
import util.fileReadWriteUtil;

public class userService {
    private static Student student;
    private static String studentRecFileName;
    private static List<Student> studentRecordList;

    /*
       public static void addUser() {
           studentRecFileName = fileReadWriteUtil.getFile(); // extract and read student file from memory
           studentRecordList = fileReadWriteUtil.readFile("studentData.txt");
           student = inputOutputUtil.getInputUserDetails(); // get command line input of user details
           studentRecordList.add(student); // add all the new entries to a list
       }
     */
    public static void deleteUser() {
        studentRecFileName = "/Users/amulverma/Downloads/Assignment2/studentData.txt";
        studentRecordList = fileReadWriteUtil.readFile(studentRecFileName);
        int deleteRno = inputOutputUtil.inputRnoToBeDeleted();
        boolean deleted = false;
        for (int i = 0; i < studentRecordList.size(); i++) {
            if (studentRecordList.get(i).getRollNumber() == deleteRno) { // check for matching roll number in the
                // records
                studentRecordList.remove(i);
                saveUserDetails(studentRecordList, studentRecFileName);
                deleted = true;
                System.out.print("Data successfully deleted!");
                break;
            }
        }
        if (!deleted) {
            System.out.println("There is no entry in student record with given roll number!");
        }

    }

    public static List<Student> sortByChoice(List<Student> studentRecordList, int choice) {
        // Records are sorted on basis of choice
        switch (choice) {
            case 1:
                studentRecordList= sortByRnoUtil.sortByRno(studentRecordList);
                break;
            case 2:
                studentRecordList = sortByNameUtil.sortByName(studentRecordList);
                break;
            case 3:
                studentRecordList= sortByAgeUtil.sortByAge(studentRecordList);
                break;
            case 4:
                studentRecordList=sortByAddressUtil.sortByAddress(studentRecordList);
                break;
        }
        return studentRecordList;
    }


    public static void exitProgram() {
        System.out.print("exit");
        System.exit(0);
    }

    // save user data into memory
    public static void saveUserDetails(List<Student> studentRecordList, String studentRecFileName) {

        if (studentRecordList.equals(null)) {
            System.out.println("Nothing to add!");
        } else {
            // Records are sorted on full name. If name is same for two students then
            // sorting based on the roll number.
            sortByNameUtil.sortByName(studentRecordList);

            fileReadWriteUtil.writeFile(studentRecordList, studentRecFileName);
            System.out.println("Data successfully saved!");

        }
    }

    public static void displayUserDetails(List<Student> studentList, int choice) {
        if (studentList.isEmpty()) {
            System.out.println("No user details present\n");
        }
        studentList=sortByChoice(studentList, choice);
        System.out.println("User Details : \n");
        System.out.printf("%s %s %s %s %s %n \n", "Name", "Age", "Address", "Roll Number", "Courses");

        for (Student value : studentList) {
            StringBuilder coursesString = new StringBuilder();
            int size = value.getCourse().getCourses().size();

            for (int j = 0; j < size; j++) {
                coursesString.append(value.getCourse().getCourses().get(j));
                if (j != size - 1) {
                    coursesString.append(", ");
                }
            }
            System.out.printf("%s %s %s %s %s %n", value.getName(),
                    value.getAge(), value.getAddress(),
                    value.getRollNumber(), coursesString.toString());
        }
    }
}
