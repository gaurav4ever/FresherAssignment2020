package org.nuclei.service;

import org.nuclei.exception.UserAlreadyExistsException;
import org.nuclei.exception.UserNotFoundException;
import org.nuclei.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentService {

    void addUser(Student student) throws UserAlreadyExistsException;
    void deleteUser(int rollNo) throws UserNotFoundException;
    List<Student> getUsers();
    List<Student> getSortedUsers(String choice, String order);
    void flushIntoDisk() throws IOException;
    void fetchFromDisk() throws IOException, ClassNotFoundException;

}
