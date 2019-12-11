package org.nuclei.DAO.Implementation;

import org.nuclei.DAO.UserDAO;
import org.nuclei.model.User;
import org.nuclei.utils.DeserializeData;
import org.nuclei.utils.SerializeData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private List<User> users = new ArrayList<User>();

    private String fileName = null;

    public UserDAOImpl(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void deleteUser(User user) {
        users.remove(user);
    }

    @Override
    public User getUserByRollNo(int rollNo) {
        for(User user: users) {
            if(user.getRollNo()==rollNo) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return users;
    }

    @Override
    public void serialize() throws IOException {
        //TODO: Serialize object
        SerializeData<User> handler = new SerializeData<User>();
        handler.serializeData(users, fileName);
    }

    @Override
    public List<User> deserialize() throws IOException, ClassNotFoundException{
        //TODO: Deserialize object
        DeserializeData<User> handler = new DeserializeData<User>();
        List<User> tempList = new ArrayList<User>();
        tempList = handler.deserializeData(fileName);
        return tempList;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
