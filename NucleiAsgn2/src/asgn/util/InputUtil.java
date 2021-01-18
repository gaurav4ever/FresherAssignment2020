package asgn.util;

import asgn.model.Course;
import asgn.model.Student;
import asgn.service.ServiceOperations;
import asgn.verification.InputVerification;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

//Class to generate menu for user entry
public class InputUtil {

  // Menu for displaying choices
  public static int getInputItemChoice() {
    Scanner sc = new Scanner(System.in);
    System.out.println(
        "\nChoose from the given menu :\n press : 1 for Add User details\n 2 for Display User details\n 3 for Delete User details\n 4 for Save User details\n 5 for Exit\n");
    int choice = sc.nextInt();
    return choice;
  }

  // Menu for asking if user wants to add another input
  public static int askAnotherInput() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Do you want to CONTINUE? Enter (y/n): ");
    String choice = sc.next();
    return isAnotherInputAsked(choice);
  }

  // If yes show menu for choices
  // If no exit program
  public static int isAnotherInputAsked(String yn) {
    int choice = 0;
    if ("Y".equals(yn) || "y".equals(yn)) {
      choice = getInputItemChoice();
    } else {
      ServiceOperations serviceOperations = new ServiceOperations();
      serviceOperations.exitProgram();
      // add condition
    }
    return choice;
  }

  // Menu to get user details like name,age,etc
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

  // Input number of courses user wants to enter
  private static int inputCourses() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of courses : ");
    int n = sc.nextInt();
		if (InputVerification.verifyNoOfCourses(n)) {
			return n;
		} else {
			return inputCourses();
		}
  }

  // input and verify age
  private static int inputAge() {
    Scanner sc = new Scanner(System.in);
    int age;
    try {
      age = sc.nextInt();
    } catch (InputMismatchException e) {
      System.out.println(
          "\nYou can only enter integer value for age.\nPlease enter age in integer only!\n");
      age = inputAge();
    }
    return age;
  }

  // input roll no
  private static int inputRno() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Roll Number : ");
    int n = sc.nextInt();
		if (InputVerification.isRnoVerified(n)) {
			return n;
		} else {
			return inputRno();
		}
  }

  // get roll number of entry to be deleted
  public static int inputRnoToBeDeleted() {
    System.out.print("enter roll number of the student you want to delete from record : ");
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }

  public static int inputSortByChoise() {
    System.out.print(
        "\nChoose from the given menu :\n press : 1 for sorting according to rollnumber\n 2 for name\n 3 for age\n 4 for address\n");
    Scanner sc = new Scanner(System.in);
    return sc.nextInt();
  }
}
