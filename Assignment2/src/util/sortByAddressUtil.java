package util;

import model.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortByAddressUtil {
    public static List<Student> sortByAddress(List<Student> studentRecordList) {

        Comparator<Student> comparator = Comparator.comparing(Student::getAddress);
        Collections.sort(studentRecordList, comparator);
        return studentRecordList;
    }
}
