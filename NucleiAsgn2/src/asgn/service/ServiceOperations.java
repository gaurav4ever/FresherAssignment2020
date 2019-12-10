package asgn.service;

import asgn.util.StudentFileReadWrite;
import asgn.model.Student;
import asgn.util.InputUtil;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceOperations {

    //get comparator of service implemented wrt to given choice by user
    public List<Student> sortByChoice(List<Student> studentRecordList, int choice) {
        // Records are sorted on basis of choice
        Comparator<Student> comparator = null;
        switch (choice) {

            case 1:
                comparator = new SortRecordByRollNumber().sortStudentRecord(studentRecordList);
                break;
            case 2:
                comparator = new SortRecordByName().sortStudentRecord(studentRecordList);
                break;
            case 3:
                comparator = new SortRecordByAge().sortStudentRecord(studentRecordList);
                break;
            case 4:
                comparator = new SortRecordByAddress().sortStudentRecord(studentRecordList);
                break;
        }

        Collections.sort(studentRecordList, comparator);
        return studentRecordList;
    }


    public void exitProgram() {
        System.out.print("------END------");
        System.exit(0);
    }

    // save user data into memory
    public void saveUserDetails(List<Student> studentRecordList, String studentRecFileName) {
        if (studentRecordList.equals(null)) {
            System.out.println("Nothing to add!");
        } else {
            ServiceSortRecordNameAge serviceSortRecordNameAge = new ServiceSortRecordNameAge();
            StudentFileReadWrite.writeFile(serviceSortRecordNameAge.sortByNameAge(studentRecordList), studentRecFileName);
            System.out.println("Data successfully saved!");
        }
    }

    //delete user with given student name and save in file
    public void deleteUserDetails(List<Student> studentRecordList, String studentRecFileName) {
        int deleteRno = InputUtil.inputRnoToBeDeleted();
        boolean deleted = false;
        for (int i = 0; i < studentRecordList.size(); i++) {
            if (studentRecordList.get(i).getRollNumber() == deleteRno) { // check for matching roll number in the
                // records
                studentRecordList.remove(i);
                saveUserDetails(studentRecordList, studentRecFileName);
                deleted = true;
                System.out.print("Data successfully deleted!");
                break;
            }
        }
        if (!deleted) {
            System.out.println("There is no entry in student record with given roll number!");
        }
    }

}
