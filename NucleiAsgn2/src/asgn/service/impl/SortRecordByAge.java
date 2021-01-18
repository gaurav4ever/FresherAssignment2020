package asgn.service.impl;

import asgn.model.Student;
import asgn.service.ServiceSortRecordByChoice;

import java.util.Comparator;
import java.util.List;

public class SortRecordByAge implements ServiceSortRecordByChoice {

  @Override
  public Comparator sortStudentRecord(List<Student> studentRecordList) {
    Comparator<Student> comparator = Comparator.comparing(Student::getAge);
    return comparator;
  }
}
