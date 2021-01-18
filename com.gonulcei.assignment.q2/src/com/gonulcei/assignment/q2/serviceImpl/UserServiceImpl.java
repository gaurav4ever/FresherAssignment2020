package com.gonulcei.assignment.q2.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.gonulcei.assignment.q2.DAO.UserDAO;
import com.gonulcei.assignment.q2.exception.UserAlreadyExistsException;
import com.gonulcei.assignment.q2.model.User;
import com.gonulcei.assignment.q2.service.UserService;
import com.gonulcei.assignment.q2.util.AddressAscComparator;
import com.gonulcei.assignment.q2.util.AddressDescComparator;
import com.gonulcei.assignment.q2.util.AgeAscComparator;
import com.gonulcei.assignment.q2.util.AgeDescComparator;
import com.gonulcei.assignment.q2.util.NameAndRollNumberComparator;
import com.gonulcei.assignment.q2.util.NameAscComparator;
import com.gonulcei.assignment.q2.util.NameDescComparator;
import com.gonulcei.assignment.q2.util.RollNoAscComparator;
import com.gonulcei.assignment.q2.util.RollNoDescComparator;

public class UserServiceImpl implements UserService{

	UserDAO userDAO = new UserDAO();

	/*
	 * This method take the user object, checks whether it a user with given roll
	 * exists, if so throws an exception else adds the user and sorts the list based
	 * on name
	 */
	public void addUser(User user) throws UserAlreadyExistsException {
		User tempUser = null;
		tempUser = userDAO.findByRollno(user.getRollNo());
		
		if (tempUser != null)
			throw new UserAlreadyExistsException("User Already Exists with given Rollno");
		else {
			userDAO.save(user);
		}
		nameAndRollNoSort(userDAO.findAll());
	}

	/*
	 * This returns the sorted list of users
	 */
	public List<User> getUserDetails() {
		List<User> userList = new ArrayList();
		userList = userDAO.findAll();
		return userList;
	}

	/*
	 * this methods takes the attribute and sorting order as parameters and returns
	 * the corresponding sorted list.
	 */
	public List<User> getSortedUserDetails(int choice, char sortOrder) {
		List<User> tempUserList = getUserDetails();
		switch (choice) {
		case 1:
			if (sortOrder == 'a') {
				Collections.sort(tempUserList, new NameAscComparator());
			} else
				Collections.sort(tempUserList, new NameDescComparator());
			break;
		case 2:
			if (sortOrder == 'a') {
				Collections.sort(tempUserList, new RollNoAscComparator());
			} else
				Collections.sort(tempUserList, new RollNoDescComparator());
			break;
		case 3:
			if (sortOrder == 'a') {
				Collections.sort(tempUserList, new AgeAscComparator());
			} else
				Collections.sort(tempUserList, new AgeDescComparator());
			break;
		case 4:
			if (sortOrder == 'a') {
				Collections.sort(tempUserList, new AddressAscComparator());
			} else
				Collections.sort(tempUserList, new AddressDescComparator());
			break;
		default:
			System.out.println("Invalid choice");
		}
		return tempUserList;
	}

	/*
	 * If the user exists with the given roll number this method deletes the user
	 */
	public String deleteUser(int rollNumber) {
		User user = null;
		user = userDAO.findByRollno(rollNumber);
		if (user == null) {
			return "Sorry.. User with given Roll number doesn't exists";
		} else {
			userDAO.delete(user);
			return "User Succesfully deleted";
		}
	}

	/*
	 * This method is used to save the user list into the disk
	 */
	public void saveDetailsIntoDisk() {
		userDAO.serialize();
	}

	/*
	 * This method retrieves the user list from the memory
	 */
	public void bringDataInMemory() {
		userDAO.deserialize();
	}

	public List<User> nameAndRollNoSort(List<User> userList) {
		Collections.sort(userList, new NameAndRollNumberComparator());
		return userList;
	}
}
