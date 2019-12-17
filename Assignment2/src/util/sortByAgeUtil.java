package util;

import model.Student;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sortByAgeUtil {
    public static List<Student> sortByAge(List<Student> studentRecordList) {
        Comparator<Student> comparator = Comparator.comparing(Student::getAge);
        studentRecordList.sort(comparator);
        return studentRecordList;
    }
}
