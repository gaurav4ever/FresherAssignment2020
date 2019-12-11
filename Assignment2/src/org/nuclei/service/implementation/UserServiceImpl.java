package org.nuclei.service.implementation;

import org.nuclei.DAO.Implementation.UserDAOImpl;
import org.nuclei.model.User;
import org.nuclei.service.UserService;
import org.nuclei.utils.comparator.*;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDAOImpl userDAO = new UserDAOImpl("./pathToFile");

    @Override
    public void addUser(User user) /*throws UserAlreadyExistsException*/ {

        User tempUser = null;
        tempUser = userDAO.getUserByRollNo(user.getRollNo());

        if (tempUser != null) {
            //TODO: throw new UserAlreadyExistsException("User Already Exists with given Rollno");
            System.out.println("User already exists");
        } else {
            userDAO.addUser(user);
        }
        Collections.sort(userDAO.getAllUsers(), new DefaultComparator());
    }

    @Override
    public void deleteUser(int rollNo) {
        User user = null;
        user = userDAO.getUserByRollNo(rollNo);
        if(user != null){
            userDAO.deleteUser(user);
        }else{
            //TODO: Change if/else to exception based system
            System.out.println("User not found");
        }
    }

    @Override
    public List<User> getUsers() {
        return userDAO.getAllUsers();

    }

    @Override
    public List<User> getSortedUsers(int choice, char order) {

        List<User> tempUserList = getUsers();
        switch (choice) {
            case 1:
                if (order == 'a') {
                    Collections.sort(tempUserList, new NameComparatorAscending());
                } else
                    Collections.sort(tempUserList, new NameComparatorDescending());
                break;
            case 2:
                if (order == 'a') {
                    Collections.sort(tempUserList, new RollNoComparatorAscending());
                } else
                    Collections.sort(tempUserList, new RollNoComparatorDescending());
                break;
            case 3:
                if (order == 'a') {
                    Collections.sort(tempUserList, new AgeComparatorAscending());
                } else
                    Collections.sort(tempUserList, new AgeComparatorDescending());
                break;
            case 4:
                if (order == 'a') {
                    Collections.sort(tempUserList, new AddressComparatorAscending());
                } else
                    Collections.sort(tempUserList, new AddressComparatorDescending());
                break;
            default:
                System.out.println("Invalid choice");
        }
        return tempUserList;
    }

    @Override
    public void flushIntoDisk() throws IOException {

        userDAO.serialize();
    }

    @Override
    public List<User> fetchFromDisk() throws IOException, ClassNotFoundException {

        List<User> tempList = userDAO.deserialize();
        return null;
    }

}
