package userdetailmanagement.dao.implementation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import java.util.logging.Level;
import java.util.logging.Logger;
import userdetailmanagement.contants.Constants;
import userdetailmanagement.dao.UserDAO;
import userdetailmanagement.models.UserDetails;

public class UserDAOImpl implements UserDAO {
    /*
     saves data in disk by writing each item of the list to disk
     */
    Logger logger = Logger.getLogger(UserDAOImpl.class.getName());
    public void writeFile(List<UserDetails> list, String file) {
        try(ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(file))){
            for (UserDetails p : list) {
                outStream.writeObject(p);
            }
        } catch (Exception e) {
            logger.log(Level.INFO, Constants.ERROR_WRITING_FILE);
        }
    }

    /*
     extract student file from memory if exists
     */
    public String getFile() {
        String fileName = Constants.FILE_PATH;
        File file = new File(fileName);
        try {
            boolean fileCreated  = file.createNewFile();
            if(fileCreated){
                logger.log(Level.INFO,Constants.FILE_CREATED_SUCCESSFULLY);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING,Constants.NO_RECORD_FOUND);
        }
        return fileName;
    }

    public List<UserDetails> readFile(String file) {
        List<UserDetails> list = new ArrayList<>();
        try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(file))) {
           /*
            reading of data from the file
             */
            while (true) {
                UserDetails p = (UserDetails) inputStream.readObject();
                if(p==null){
                    break;
                }
                list.add(p);
            }
        } catch (Exception e) {
            logger.log(Level.WARNING,Constants.ERROR_READING_FILE);
        }
        return list;
    }
}
