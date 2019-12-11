package org.nuclei.service;

import org.nuclei.model.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    void addUser(User user) /*throws UserAlreadyExistsException*/;
    void deleteUser(int rollNo);
    List<User> getUsers();
    List<User> getSortedUsers(int choice, char order);
    void flushIntoDisk() throws IOException;
    List<User> fetchFromDisk() throws IOException, ClassNotFoundException;

}
