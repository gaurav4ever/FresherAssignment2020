package util;

import model.Student;
import service.InputOutputUtil;
import service.UserService;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utility {
    private static Scanner scan = new Scanner(System.in);
    private static final String STUDENT_FILE = "src/resource/studentData.txt";
    private static List<Student> studentRecordList = FileReadWriteUtil.readFile(STUDENT_FILE);
    public static void performAction(final int choice) {
        UserService user=new UserService();
        switch (choice) {
            case 1:
                final Student student = InputOutputUtil.getInputUserDetails();
                studentRecordList.add(student);
                break;
            case 2:
                System.out.print("\nChoose  :\n 1 for sorting according to RollNumber\n 2 by name\n 3 by age\n 4 by address\n");
                user.displayUserDetails(studentRecordList,scan.nextInt());
                break;
            case 3:
                user.deleteUser();
                break;
            case 4:
                user.saveUserDetails(studentRecordList, STUDENT_FILE);
                break;
            case 5:
                exitProgram();
                break;
            default:

        }
        performAction(askAnotherInput());
    }

    public static int askAnotherInput() {
        System.out.print("Do you want to CONTINUE? Enter (y/n): ");
        String choice = scan.next();
        int inputChoice = 0;
        final String yes="Y";
        if (yes.equalsIgnoreCase(choice)) {
            inputChoice = getInputItemChoice();
        } else {
            exitProgram();
        }
        return inputChoice;
    }

    public static void exitProgram() {
        System.out.print("exit");
        System.exit(0);
    }
    public static int getInputItemChoice() {
        System.out.println(
                "\nChoose from the given menu :\n 1. for Add User details\n 2. for Display User details\n 3. for Delete User details\n4. for Save User details\n5. for Exit\n");
        return scan.nextInt();
    }
    public static List<Student> sortedList(final List<Student> student, Comparator<Student> comparator){
        return student.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

}
