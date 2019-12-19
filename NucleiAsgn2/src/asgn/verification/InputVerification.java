package asgn.verification;

import asgn.StudentRecord;
import asgn.model.Student;

import java.util.List;

//class for verifying input entered by user

public class InputVerification {

  // verify number of courses, it should be more than 4
  public static boolean verifyNoOfCourses(int nCourses) {
    if (nCourses >= 4) {
      return true;
    } else {
      System.out.print("number of courses shoud be more than or equal to 4 : ");
      return false;
    }
  }

  // verify that roll number is unique
  public static boolean isRnoVerified(int rno) {
    if (verifyRNo(rno)) {
      return true;
    } else {
      System.out.print("enter unique roll number : ");
      return false;
    }
  }

  // Check if number is unique or not
  public static boolean verifyRNo(int rno) {
    List<Student> studentRecordList = StudentRecord.getStudentRecordList();
    return studentRecordList.stream().noneMatch(student -> student.getRollNumber() == rno);
  }
}
