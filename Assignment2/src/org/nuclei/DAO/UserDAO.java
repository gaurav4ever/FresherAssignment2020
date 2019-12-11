package org.nuclei.DAO;

import org.nuclei.model.User;

import java.io.IOException;
import java.util.List;

public interface UserDAO {

    String fileName = null;
    
    void addUser(User user) /*throws aleradyThereException*/;
    void deleteUser(User user);
    User getUserByRollNo(int rollNo);
    List<User> getAllUsers();
    void serialize() throws IOException;
    List<User> deserialize() throws IOException, ClassNotFoundException;

}
