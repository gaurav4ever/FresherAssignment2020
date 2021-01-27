package service;

import sortenum.sortChoice;
import model.Student;

import java.util.List;
import java.util.Objects;

import util.*;

public class UserService {
    /*
       public static void addUser() {
           studentRecFileName = fileReadWriteUtil.getFile(); // extract and read student file from memory
           studentRecordList = fileReadWriteUtil.readFile("studentData.txt");
           student = inputOutputUtil.getInputUserDetails(); // get command line input of user details
           studentRecordList.add(student); // add all the new entries to a list
       }
     */
    public void deleteUser() {
        final String Student_FILE = "src/resource/studentData.txt";
        final int deleteRno = InputOutputUtil.inputRnoToBeDeleted();
        try {
            List<Student> studentRecordList = FileReadWriteUtil.readFile(Student_FILE);
            boolean deleted = false;
            for (int i = 0; i < studentRecordList.size(); i++) {
                if (studentRecordList.get(i).getRollNumber() == deleteRno) { // check for matching roll number in the
                    // records
                    studentRecordList.remove(i);
                    saveUserDetails(studentRecordList, Student_FILE);
                    deleted = true;
                    System.out.print("Data successfully deleted!");
                    break;
                }
            }
            if (!deleted) {
                System.out.println("There is no entry in student record with given roll number!");
            }
        }catch (Exception e)
        {
            System.err.print(e);
        }

    }
    // save user data into memory
    public void saveUserDetails(List<Student> studentRecordList,String studentRecFileName) {

        if (Objects.isNull(studentRecordList)) {
            System.out.println("Nothing to add!");
        } else {
            // Records are sorted on full name. If name is same for two students then
            // sorting based on the roll number.
            SortByNameUtil.sortByName(studentRecordList);
            FileReadWriteUtil.writeFile(studentRecordList, studentRecFileName);
            System.out.println("Data successfully saved!");

        }
    }
    public void displayUserDetails(List<Student> studentList, int choice) {

        if (studentList.isEmpty()) {
            System.out.println("No user details present\n");
            return;
        }
        studentList=util.Utility.sortedList(studentList,sortChoice.values()[choice-1].getComparator() );
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
