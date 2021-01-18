package asgn;

import asgn.model.Student;
import asgn.service.ServiceOperations;
import asgn.util.InputUtil;
import asgn.util.OuputUtil;
import asgn.util.StudentFileReadWrite;

import java.util.List;

public class StudentRecord {

  private static String studentRecFileName;
  private static List<Student> studentRecordList;

  public static void main(String[] args) {
    studentRecFileName = StudentFileReadWrite
        .getFile(); // extract and read student file from memory
    studentRecordList = StudentFileReadWrite.readFile("studentData.txt");

    int choice = InputUtil.getInputItemChoice(); // menu for selecting options
    performAction(choice); // perform task according to the option chosen
  }

  private static void performAction(int choice) {
    ServiceOperations serviceOperations = new ServiceOperations();
    switch (choice) {
      case 1:
        // get command line input of user details
        final Student student = InputUtil.getInputUserDetails();
        // add all the new entries to a list
        studentRecordList.add(student);
        break;
      case 2:
        //display details
        OuputUtil.displayUserDetails(studentRecordList, InputUtil.inputSortByChoise());
        break;
      case 3:
        //delete details
        serviceOperations.deleteUserDetails(studentRecordList, studentRecFileName);
        break;
      case 4:
        //save user details in file
        serviceOperations.saveUserDetails(studentRecordList, studentRecFileName);
        break;
      case 5:
        //exit program
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
