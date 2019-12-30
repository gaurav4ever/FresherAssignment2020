package Assignment2.menu;

import Assignment2.User;
import static Assignment2.MenuDriver.CHANGES_MADE;

import java.io.*;
import java.util.HashMap;

public class SaveUser {
    public void storeObject(HashMap<String, User> users){
        try{
            File fileOne=new File("userdetails.dat");
            FileOutputStream fos=new FileOutputStream(fileOne);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.flush();
            oos.close();
            fos.close();
            CHANGES_MADE = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
