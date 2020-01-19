package Assignment_2.services;

import java.util.ArrayList;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.Collections;
import Assignment_2.Sorting.*;
import Assignment_2.models.UserInfo;

public class UserServices implements Serializable{
    private static final long serialVersionUID = 1L;
    public ArrayList<UserInfo> usersInfo = null;
    public UserServices(){
        usersInfo = deserialization();
    }

    //addUser
    public void addUser(UserInfo newUser) {
        usersInfo.add(newUser);
    }

    //deleteUser
    public String deleteUser(int newRollNumber){
        for(UserInfo user: usersInfo){
            if(user.rollNumber == newRollNumber){
                usersInfo.remove(user);
                return user.name+" deleted";
            }
        }
        return "User not Found!";
    }

    //displayUser
    public void displayUser(String param, String order){
        if(param.equals("Name")){
            Collections.sort(usersInfo);
        }
        else if(param.equals("Age")){
            Collections.sort(usersInfo, new AgeComparator());
        }
        else if(param.equals("Roll Number")){
            Collections.sort(usersInfo, new RollComparator());
        }
        else if(param.equals("Address")){
            Collections.sort(usersInfo, new AddressComparator());
        }
        if(order.equals("b")){
            Collections.reverse(usersInfo);
        }

        System.out.println("--------------------------------------------------------------------------------");
        System.out.format("%-15s%-15s%-15s%-15s%-15s\n", "Name","Roll Number" ,"Age" , "Address", "Courses");
        System.out.println("--------------------------------------------------------------------------------");
        for(UserInfo user : usersInfo){
            System.out.format("%-15s%-15s%-15s%-15s%-15s\n", user.name,user.rollNumber ,user.age , user.address, String.join(", ", user.courses));
        }
    }

    // Serialization
    public void serialization() {
        ArrayList<UserInfo> UserServicesInfo = usersInfo;
        try {
            String path = UserServices.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/data/users.ser";
            File file = new File(path);
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(file, false);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.reset();
            out.writeObject(UserServicesInfo);
            out.close();
            fileOut.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    // Deserialization
    public ArrayList<UserInfo> deserialization() {
        ArrayList<UserInfo> UserServicesInfo = null;
        try {
            String path = UserServices.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "/data/users.ser";
            File file = new File(path);
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            if(file.length()>0){
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                UserServicesInfo = (ArrayList<UserInfo>) in.readObject();
                in.close();
                fileIn.close();
            }
        }
        catch ( IOException e) {
            e.printStackTrace();
        }
        catch ( ClassNotFoundException e) {
            e.printStackTrace();
        }

        if(UserServicesInfo == null){
            UserServicesInfo = new ArrayList<UserInfo>();
        }

        return UserServicesInfo;
    }
}
