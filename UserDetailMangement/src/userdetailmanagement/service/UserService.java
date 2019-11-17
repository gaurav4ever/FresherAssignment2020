package userdetailmanagement.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

import userdetailmanagement.DAO.UserDao;
import userdetailmanagement.model.User;

public class UserService {
	static Scanner sc=new Scanner(System.in);
	static UserDao dao=new UserDao();
//	public void addUser(TreeMap<String,ArrayList<User>> tm,ArrayList<Integer> roll) {
//		//User user=new User();
//		
//		if(tm.containsKey(user.getName())) {
//			tm.get(user.getName()).add(user);
//			Collections.sort(tm.get(user.getName()));
//		}
//		else {
//			ArrayList<User> l = new ArrayList<>();
//			l.add(user);
//			tm.put(user.getName(),l);
//		}
//			
//	}
	public static void addUser(User user) {
		dao.add(user);
	}
		
	
	
	public static void deleteUser() {
		
	}
	
	public static void saveUser() {
		
	}
	
	public static void displayUser() {
		List<User> l = dao.findAllUsers();
		for(User user : l) {
			System.out.println(user.toString());
		}
	}
}
