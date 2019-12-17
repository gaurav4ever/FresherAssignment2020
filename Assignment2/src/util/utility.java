package util;

import model.Student;
import serviceUtil.inputOutputUtil;
import serviceUtil.userService;

import java.util.List;
import java.util.Scanner;

public class utility {
    private static Student student;
    public static String studentRecFileName = "/Users/amulverma/Downloads/Assignment2/studentData.txt";
    public static List<Student> studentRecordList = fileReadWriteUtil.readFile(studentRecFileName);

    public static void performAction(int choice) {
        switch (choice) {
            case 1:
                student = inputOutputUtil.getInputUserDetails(); // get command line input of user details
                studentRecordList.add(student); // add all the new entries to a list
                break;
            case 2:
                System.out.print("\nChoose  :\n 1 for sorting according to rollnumber\n 2 for name\n 3 for age\n 4 for address\n");
                Scanner sc = new Scanner(System.in);
                int choose = sc.nextInt();
                userService.displayUserDetails(studentRecordList, choose);
                break;
            case 3:
                userService.deleteUser();
                break;
            case 4:
                userService.saveUserDetails(studentRecordList, studentRecFileName);
                break;
            case 5:
                userService.exitProgram();
                break;
        }

        // ask user for multiple input
        int choice1 = askAnotherInput();
        performAction(choice1);
    }

    public static int askAnotherInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to CONTINUE? Enter (y/n): ");
        String choice = sc.next();
        int inputChoice = 0;
        if ("Y".equals(choice) || "y".equals(choice)) {
            inputChoice = getInputItemChoice();
        } else {
            userService.exitProgram();
        }
        return inputChoice;
        // return isAnotherInputAsked(choice);
    }

    public static int getInputItemChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.println(
                "\nChoose from the given menu :\n 1. for Add User details\n 2. for Display User details\n 3. for Delete User details\n4. for Save User details\n5. for Exit\n");
        return sc.nextInt();
    }

}
