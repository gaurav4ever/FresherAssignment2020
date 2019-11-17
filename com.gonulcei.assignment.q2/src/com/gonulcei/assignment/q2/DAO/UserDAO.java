package com.gonulcei.assignment.q2.DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.gonulcei.assignment.q2.model.User;

/*
 * This class is used to save the list of users
 * and also provides CRUD operations on user. 
 */
public class UserDAO {
	/*
	 * It stores the list of users (in memory)
	 */
	List<User> userList = new ArrayList();
	/*
	 * Path where the list of users will be stored in the disk
	 */
	String filename = "/home/chicken/Desktop/file.ser";
	
	/*
	 * 
	 */
	public void save(User user) {
		userList.add(user);
	}
	
	/*
	 * Returns  the list of all users i.e. userList 
	 */
	public List<User> findAll() {
		return userList;
	}
	
	/*
	 * This method returns the user with a given roll number, if roll number 
	 * doesn't exist it returns null
	 */
	public User findByRollno(int rollNo) {
		for(User user: userList) {
			if(user.getRollNo()==rollNo) {
				return user;
			}
		}
		return null;
	}
	
	/*
	 * deletes the user from the userList
	 */
	public void delete(User user) {
		userList.remove(user);
	}
	
	/*
	 * This method saves the data in the disk. It takes the list of users i.e. 
	 * userList and directly saves it to the disk
	 */
	public void serialize() {
		 try {    
            FileOutputStream file = new FileOutputStream(filename); 
            ObjectOutputStream out = new ObjectOutputStream(file); 
              
            // Method for serialization of object 
            out.writeObject(userList); 
            
            out.close(); 
            file.close(); 
  
        }    
        catch(IOException ex) { 
            System.out.println("IOException is caught"); 
        } 
	}
	
	/*
	 * This method load the data in memory from the disk
	 * userList is updated.
	 */
	public void deserialize() {
		try
        {    
            // Reading the object from a file 
            FileInputStream file = new FileInputStream(filename); 
            ObjectInputStream in = new ObjectInputStream(file); 
              
            // Method for deserialization of object 
            this.userList = (List<User>)in.readObject(); 
              
            in.close(); 
            file.close();
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
        } 
	}
	
}

















