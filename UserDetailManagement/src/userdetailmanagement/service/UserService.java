package userdetailmanagement.service;

import java.util.List;

import userdetailmanagement.models.User;

public interface UserService {
	public boolean verifiedRollNo(int rollNo,List<User> users);
	public void deleteUser(List<User> users, int rollNo);
	public List<User> sortNameAndRoll(List<User> users);
	public void displayUser(List<User> users);
	public List<User> getSortedUserDetails(int choice, int order,List<User> users);
	public String getFile();
	public List<User> readFile(String fileName);
	public void writeFile(List<User> users,String fileName);
}
