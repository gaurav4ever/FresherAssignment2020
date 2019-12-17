package userdetailmanagement.service.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import userdetailmanagement.dao.implementation.UserDAOImpl;
import userdetailmanagement.models.User;
import userdetailmanagement.service.UserService;

public class UserServiceImpl implements UserService {
	static Scanner sc=new Scanner(System.in);
	
	UserDAOImpl userDao = new UserDAOImpl();
	
	public boolean verifiedRollNo(int rollNo,List<User> l) {
		for(User user : l) {
			if(user.getRollNo() == rollNo) {
				System.out.println("This roll no already exist. Please re-enter unique roll no.");
				return false;
			}
		}
		return true;
	}
	
	public void deleteUser(List<User> l,int rollNo) {
		//List<User> l = findAllUser();
		int i=0;
		for(User user : l) {
			if(user.getRollNo() == rollNo) {
				break;
			}
			i++;
		}
		if(i==l.size()) {
			System.out.println("Invalid roll no");
		}
		else {
			l.remove(i);
			System.out.println("Successfully removed");
		}
	}
	
	public List<User> sortNameAndRoll(List<User> userList){
		 Collections.sort(userList, (User user1,User user2)->{
			 if(user1.getName().equalsIgnoreCase(user2.getName())) {
				 return user1.getRollNo() - user2.getRollNo();
			 }
			 else return user1.getName().compareToIgnoreCase(user2.getName());
		 });
		 return	userList; 
	}
	
	public void displayUser(List<User> l) {
		System.out.println("-----------------------------------------------------------------------------------------");
		String head = String.format("%1$-15s %2$-15s %3$-15s %4$-20s %5$-10s", "Name", "Roll Number", "Age", "Address", "Courses");
		System.out.println(head);
		System.out.println("-----------------------------------------------------------------------------------------");
		for(User user: l) {
			System.out.println(user);
		}	
		System.out.println();
	}
	
	public List<User> getSortedUserDetails(int choice, int order,List<User> users){
		//List<User> users = findAllUser();
		switch(choice) {
		case 1:
			if(order == 'a') {
				Collections.sort(users,(User o1,User o2)->{
					return o1.getName().compareToIgnoreCase(o2.getName());
				});
			}
			else {
				Collections.sort(users,(User o1, User o2)->{
					return -1*o1.getName().compareToIgnoreCase(o2.getName());
				});
			}
			break;
		case 2:
			if(order == 'a') {
				Collections.sort(users,(User o1,User o2)->{
					if(o1.getRollNo()>o2.getRollNo()){
						return 1;
					}
					return -1;
				});
			}
			else {
				Collections.sort(users,(User o1,User o2)->{
					if(o1.getRollNo()>o2.getRollNo()){
						return -1;
					}
					return 1;
				});
			}
			break;
		case 3:
			if(order == 'a') {
				Collections.sort(users,(User o1,User o2)->{
					if(o1.getAge()>o2.getAge()){
						return 1;
					}
					return -1;
				});
			}
			else {
				Collections.sort(users,(User o1,User o2)->{
					if(o1.getAge()>o2.getAge()){
						return -1;
					}
					return 1;
				});
			}
			break;
		case 4:
			if(order == 'a') {
				Collections.sort(users,(User o1,User o2)->{
					return o1.getAddress().compareToIgnoreCase(o2.getAddress());
				});
			}
			else {
				Collections.sort(users,(User o1,User o2)->{
					return -1*o1.getAddress().compareToIgnoreCase(o2.getAddress());
				});
			}
			break;
		default :
			System.out.println("Invalid Input");
		}
		
		return users;
	}
	
	public String getFile() {
		return userDao.getFile();
	}
	
	public List<User> readFile(String fileName){
		return userDao.readFile(fileName);
	}
	
	public void writeFile(List<User> users,String fileName) {
		userDao.writeFile(users, fileName);
	}
    
}
