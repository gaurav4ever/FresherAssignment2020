package assignment2;
import java.io.*;
import java.util.*;

public class DiskHandler {
    public void saveToDisk(Set<User> users) {
        try {
            FileOutputStream fstream = new FileOutputStream("userdetails.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fstream);
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Set<User> getFromDisk() {
        Set<User> users = new TreeSet<>();
        try {
            FileInputStream fstream = new FileInputStream("userdetails.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fstream);
            users = (Set<User>) objectInputStream.readObject();
            objectInputStream.close();
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
