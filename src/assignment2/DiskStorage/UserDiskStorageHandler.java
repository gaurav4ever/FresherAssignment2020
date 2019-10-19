package assignment2.DiskStorage;

import assignment2.models.User;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class UserDiskStorageHandler {
    public void saveUsersToDisk(Set<User> users) {
        FileOutputStream fstream = null;
        try {
            fstream = new FileOutputStream("userdetails.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fstream) ;
            objectOutputStream.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Set<User> getUsersFromDisk() {
        FileInputStream fstream = null;
        Set<User> users = new TreeSet<>() ;
        try {
            fstream = new FileInputStream("userdetails.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fstream) ;
            users = (Set<User>)objectInputStream.readObject() ;
        } catch (FileNotFoundException e) {
            System.out.println("No User details stored in disk yet.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
