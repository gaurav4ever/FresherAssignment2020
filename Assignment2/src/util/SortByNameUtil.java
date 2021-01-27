package util;

import model.Student;

import java.util.Comparator;
import java.util.List;

public class SortByNameUtil {
    public static void sortByName(List<Student> studentRecordList) {
        // Records are sorted on full name. If name is same for two students then
        // sorting based on the roll number.
        Comparator<Student> comparator = Comparator.comparing(Student::getName)
                .thenComparing(Student::getRollNumber);
        studentRecordList.sort(comparator);
    }
}
