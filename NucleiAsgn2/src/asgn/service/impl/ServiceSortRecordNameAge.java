package asgn.service.impl;

import asgn.model.Student;
import asgn.service.ServiceSortRecordByChoice;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ServiceSortRecordNameAge {

  public List<Student> sortByNameAge(List<Student> studentRecordList) {
    // Records are sorted on full name. If name is same for two students then
    // sorting based on the roll number.
    Comparator<Student> comparator = Comparator.comparing(Student::getName)
        .thenComparing(Student::getRollNumber);
    Collections.sort(studentRecordList, comparator);
    return studentRecordList;
  }

  public static class SortRecordByAddress implements ServiceSortRecordByChoice {

    @Override
    public Comparator sortStudentRecord(List<Student> studentList) {
      Comparator<Student> comparator = Comparator.comparing(Student::getAddress);
      return comparator;
    }
  }
}
