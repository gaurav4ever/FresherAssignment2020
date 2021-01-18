package asgn.util;

import asgn.model.Student;
import asgn.service.ServiceOperations;

import java.util.List;
import java.util.stream.IntStream;

public class OuputUtil {

  // print results on command prompt in proper format
  public static void displayUserDetails(List<Student> list, int sortChoice) {

    //get sorted list according to the choice entered by the user
    List<Student> studentRecordList = sortUserDetails(list, sortChoice);

    if (studentRecordList.isEmpty()) {
      System.out.println("No user details present\n");
    }
    System.out.println("User Details : \n");
    System.out.println(
        "----------------------------------------------------------------------------------------------------------------------------------------------------------------");
    System.out.printf("%-30s %-30s %-30s %-30s %-30s%n \n", "Name", "Age", "Address", "Roll Number",
        "Courses");
    System.out.println(
        "----------------------------------------------------------------------------------------------------------------------------------------------------------------");

    for (Student student : studentRecordList) {
      StringBuilder coursesString = new StringBuilder();
      int size = student.getCourse().getCourses().size();

      //formatting the courses in form of a string
      IntStream.range(0, size).forEach(j -> {
        coursesString.append(student.getCourse().getCourses().get(j));
        if (j != size - 1) {
          coursesString.append(", ");
        }
      });

      //print output
      System.out.printf("%-30s %-30s %-30s %-30s %-30s%n", student.getName(),
          student.getAge(), student.getAddress(),
          student.getRollNumber(), coursesString.toString());
    }
  }

  public static List<Student> sortUserDetails(List<Student> studentRecordList, int sortChoice) {
    ServiceOperations serviceOperations = new ServiceOperations();
    return serviceOperations.sortByChoice(studentRecordList, sortChoice);
  }
}
