package userdetailmanagement.DAO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import userdetailmanagement.UserUtil.ComparatorNameAndRoll;
import userdetailmanagement.model.User;

public class UserDao {
	List<User> users=new ArrayList<>();
	String filename = "/home/vishal/Desktop/user.ser";
	public void add(User user) {
		users.add(user);
		sortNameAndRoll(users);
	}
	
	public List<User> findAllUsers(){
		return users;
	}
	
	public List<User> sortNameAndRoll(List<User> userList){
		 Collections.sort(userList, new ComparatorNameAndRoll());
		 return	userList; 
	}
	public void serializeData() {
		 try {    
	            FileOutputStream file = new FileOutputStream(filename); 
	            ObjectOutputStream out = new ObjectOutputStream(file); 
	              
	            // Method for serialization of object 
	            out.writeObject(users); 
	            
	            out.close(); 
	            file.close(); 
		 }
		 catch(Exception ex) {
			 System.out.println("Exception is caught");
		 }
	  
	}
	public void deserializeData() {
		try {
			FileInputStream file= new FileInputStream(filename);
			ObjectInputStream in = new ObjectInputStream(file);
			this.users = (List<User>)in.readObject();
			in.close();
			file.close();
		}
		catch(IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}
	}
}
