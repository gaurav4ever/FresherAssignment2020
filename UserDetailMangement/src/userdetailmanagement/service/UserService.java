package userdetailmanagement.service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import userdetailmanagement.DAO.UserDao;
import userdetailmanagement.UserUtil.AscAddressComparator;
import userdetailmanagement.UserUtil.AscAgeComparator;
import userdetailmanagement.UserUtil.AscNameComparator;
import userdetailmanagement.UserUtil.AscRollNoComparator;
import userdetailmanagement.UserUtil.DescAddressComparator;
import userdetailmanagement.UserUtil.DescAgeComparator;
import userdetailmanagement.UserUtil.DescNameComparator;
import userdetailmanagement.UserUtil.DescRollNoComparator;
import userdetailmanagement.model.User;

public class UserService {
	static Scanner sc=new Scanner(System.in);
	static UserDao dao=new UserDao();
	public void addUser(User user) {
		dao.add(user);
	}
		
	
	public boolean verifiedRollNo(int rollNo) {
		List<User> l = findAllUser();
		for(User user : l) {
			if(user.getRollNo() == rollNo) {
				System.out.println("This roll no already exist. Please re-enter unique roll no.");
				return false;
			}
		}
		return true;
	}
	
	public void deleteUser(int rollNo) {
		List<User> l = findAllUser();
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
	
	public void saveUserInDisk() {
		dao.serializeData();
	}
	
	public void bringDataInMemory() {
		dao.deserializeData();
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
	
	public List<User> findAllUser(){
		List<User> l = dao.findAllUsers();
		return l;
	}
	
	public List<User> getSortedUserDetails(int choice, int order){
		List<User> users = findAllUser();
		switch(choice) {
		case 1:
			if(order == 'a') {
				Collections.sort(users,new AscNameComparator());
			}
			else {
				Collections.sort(users,new DescNameComparator());
			}
			break;
		case 2:
			if(order == 'a') {
				Collections.sort(users,new AscRollNoComparator());
			}
			else {
				Collections.sort(users,new DescRollNoComparator());
			}
			break;
		case 3:
			if(order == 'a') {
				Collections.sort(users,new AscAgeComparator());
			}
			else {
				Collections.sort(users,new DescAgeComparator());
			}
			break;
		case 4:
			if(order == 'a') {
				Collections.sort(users,new AscAddressComparator());
			}
			else {
				Collections.sort(users,new DescAddressComparator());
			}
			break;
		default :
			System.out.println("Invalid Input");
		}
		
		return users;
	}
}
