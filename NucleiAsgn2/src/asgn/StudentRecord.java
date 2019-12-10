package asgn;

import java.util.List;

import asgn.model.Student;
import asgn.service.ServiceOperations;
import asgn.util.InputUtil;
import asgn.util.OuputUtil;
import asgn.util.StudentFileReadWrite;

public class StudentRecord {

    private static Student student;
    private static String studentRecFileName;
    private static List<Student> studentRecordList;

    public static void main(String[] args) {
        studentRecFileName = StudentFileReadWrite.getFile(); // extract and read student file from memory
        studentRecordList = StudentFileReadWrite.readFile("studentData.txt");
        int choice = InputUtil.getInputItemChoice(); // menu for selecting options
        performAction(choice); // perform task according to the option chosen
    }

    private static void performAction(int choice) {
        ServiceOperations serviceOperations = new ServiceOperations();
        switch (choice) {
            case 1:
                student = InputUtil.getInputUserDetails(); // get command line input of user details
                studentRecordList.add(student); // add all the new entries to a list
                break;
            case 2:
                OuputUtil.displayUserDetails(studentRecordList, InputUtil.inputSortByChoise());
                break;
            case 3:
                serviceOperations.deleteUserDetails(studentRecordList, studentRecFileName);
                break;
            case 4:
                serviceOperations.saveUserDetails(studentRecordList, studentRecFileName);
                break;
            case 5:
                serviceOperations.exitProgram();
                break;
        }

        // ask user for multiple input
        int choice1 = InputUtil.askAnotherInput();
        performAction(choice1);
    }

    public static List<Student> getStudentRecordList() {
        return studentRecordList;
    }
}
