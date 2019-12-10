package com.gonulcei.assignment.q2.service;

import java.util.List;

import com.gonulcei.assignment.q2.exception.UserAlreadyExistsException;
import com.gonulcei.assignment.q2.model.User;

public interface UserService {

	public void addUser(User user) throws UserAlreadyExistsException;
	public List<User> getUserDetails();
	public List<User> getSortedUserDetails(int choice, char sortOrder);
	public String deleteUser(int rollNumber);
	public void saveDetailsIntoDisk();
	public void bringDataInMemory();
	
}
