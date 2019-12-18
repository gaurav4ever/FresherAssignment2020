package util;

import model.Student;
import service.InputOutputUtil;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Utility {
    private static Scanner scan = new Scanner(System.in);
    private static final String STUDENT_FILE = "src/resource/studentData.txt";
    private static List<Student> studentRecordList = FileReadWriteUtil.readFile(STUDENT_FILE);

    public static void performAction(final int choice) {
        switch (choice) {
            case 1:
                final Student student = InputOutputUtil.getInputUserDetails(); // get command line input of user details
                studentRecordList.add(student); // add all the new entries to a list
                break;
            case 2:
                System.out.print("\nChoose  :\n 1 for sorting according to rollnumber\n 2 for name\n 3 for age\n 4 for address\n");
                final int choose = scan.nextInt();
                UserService.displayUserDetails(studentRecordList, choose);
                break;
            case 3:
                UserService.deleteUser();
                break;
            case 4:
                UserService.saveUserDetails(studentRecordList, STUDENT_FILE);
                break;
            case 5:
                UserService.exitProgram();
                break;
            default:

        }

        // ask user for multiple input
        final int choice1 = askAnotherInput();
        performAction(choice1);
    }

    public static int askAnotherInput() {
        System.out.print("Do you want to CONTINUE? Enter (y/n): ");
        String choice = scan.next();
        int inputChoice = 0;
        final String yes="Y";
        if (yes.equalsIgnoreCase(choice)) {
            inputChoice = getInputItemChoice();
        } else {
            UserService.exitProgram();
        }
        return inputChoice;
    }

    public static int getInputItemChoice() {
        System.out.println(
                "\nChoose from the given menu :\n 1. for Add User details\n 2. for Display User details\n 3. for Delete User details\n4. for Save User details\n5. for Exit\n");
        return scan.nextInt();
    }

}
