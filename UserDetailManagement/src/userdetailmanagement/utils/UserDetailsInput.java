package userdetailmanagement.utils;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import userdetailmanagement.models.UserDetails;

public class UserDetailsInput {
  Logger logger = Logger.getLogger(UserDetailsInput.class.getName());
  Scanner sc=new Scanner(System.in);
  private String inputName() {
    String fullName = sc.nextLine();
    //validations
    while (fullName.isBlank()) {
      logger.log(Level.INFO,"Please try again");
      fullName = sc.nextLine();
    }
    return fullName;
  }

  private int inputAge() {
    logger.log(Level.INFO,"-age [Integer] ");
    int age;
    try {
      age = sc.nextInt();
    } catch (InputMismatchException e) {
      logger.log(Level.INFO,"Age can only be integer. Please re-enter age");
      sc.nextLine();
      age = inputAge();
    }
    return age;
  }

  private String inputAddress() {
    logger.log(Level.INFO,"-address ");
    sc.nextLine();
    String address = sc.nextLine();
    while (address.equals("")) {
      logger.log(Level.INFO,"Please try again");
      address = sc.nextLine();
    }
    return address;
  }
  private boolean verifiedRollNo(int rollNo,List<UserDetails> l) {
    for(UserDetails userDetails : l) {
      if(userDetails.getRollNo() == rollNo) {
        logger.log(Level.INFO,"This roll no already exist. Please re-enter unique roll no.");
        return false;
      }
    }
    return true;
  }

  private int inputRollNo(List<UserDetails> userDetailsRecordList) {
    logger.log(Level.INFO,"-Roll Number [Integer] ");
    int rollno;
    try {
      rollno = sc.nextInt();
      if (verifiedRollNo(rollno, userDetailsRecordList)) {
        return rollno;
      } else {
        rollno = inputRollNo(userDetailsRecordList);
      }
    } catch (InputMismatchException e) {
      logger.log(Level.INFO,"Roll no should be integer. Please re-enter");
      rollno = inputRollNo(userDetailsRecordList);
      sc.nextLine();
    }
    return rollno;
  }
  private List<String> getCourses(){
    logger.log(Level.INFO,"Enter number of courses you want");
    int nCourses = sc.nextInt();
    sc.nextLine();
    logger.log(Level.INFO,"Select courses [ A, B, C, D, E, F]");
    List<String> courses = new ArrayList<>();
    for(int i=0;i<nCourses;i++){
      String course = sc.nextLine();
      if(!courses.contains(course)){
        courses.add(course);
      }
      else{
        logger.log(Level.INFO,"You have already taken this course");
        printCourses(courses);
        nCourses+=1;
      }
    }
    return courses;
  }
  public UserDetails getUserInput(List<UserDetails> userDetailsRecordList) {
    UserDetails userDetails = new UserDetails();

    logger.log(Level.INFO,"Enter the Details of the User");
    sc.nextLine();

    logger.log(Level.INFO,"-Fullname ");
    String fullName = inputName();
    userDetails.setName(fullName);

    int age = inputAge();
    userDetails.setAge(age);

    String address = inputAddress();
    userDetails.setAddress(address);

    int rollno = inputRollNo(userDetailsRecordList);
    userDetails.setRollNo(rollno);


    List<String> courses = getCourses();
    userDetails.setCourses(courses);

    return userDetails;
  }
  private void printCourses(List<String> courses){
    courses.forEach(x -> logger.log(Level.INFO,x));
  }
}
