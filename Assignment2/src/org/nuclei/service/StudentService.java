package org.nuclei.service;

import org.nuclei.exception.UserAlreadyExistsException;
import org.nuclei.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    void addUser(Student student) throws UserAlreadyExistsException;
    void deleteUser(int rollNo);
    List<Student> getUsers();
    List<Student> getSortedUsers(int choice, char order);
    void flushIntoDisk() throws IOException;
    void fetchFromDisk() throws IOException, ClassNotFoundException;

}
