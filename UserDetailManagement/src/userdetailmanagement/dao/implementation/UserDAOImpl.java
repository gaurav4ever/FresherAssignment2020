package userdetailmanagement.dao.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import userdetailmanagement.dao.UserDAO;
import userdetailmanagement.models.User;

public class UserDAOImpl implements UserDAO {
	// saves data in disk by writing each item of the list to disk
    public void writeFile(List<User> list, String file) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(file));
            for (User p : list) {
                outStream.writeObject(p);
            }
        } catch (Exception e) {
            System.err.println("Error in wirtting items!");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
    }

    // extract student file from memory if exists
    public String getFile() {
        String fileName = "/Users/vishalsinghal/Desktop/nuclei_assignment/FresherAssignment2020/usersData.txt";
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                // File created in root directory
            } else {
                // File already exists in root directory
            }
        } catch (IOException e) {
            System.out.print("Users Record not found!");
            e.printStackTrace();
        }
        return fileName;
    }
    
    public List<User> readFile(String file) {
        List<User> list = new ArrayList<>();
        ObjectInputStream inputStream=null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            //reading of data from the file
            while (true) {
            	User p = (User) inputStream.readObject();
                list.add(p);
            }
        } catch (Exception e) {
            //System.err.println("Error opening file."+e);
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return list;
    }
}
