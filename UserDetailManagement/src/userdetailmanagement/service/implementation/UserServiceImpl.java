package userdetailmanagement.service.implementation;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import userdetailmanagement.contants.Constants;
import userdetailmanagement.dao.implementation.UserDAOImpl;
import userdetailmanagement.models.UserDetails;
import userdetailmanagement.service.IUserService;

public class UserServiceImpl implements IUserService {
	static Scanner sc=new Scanner(System.in);
	UserDAOImpl userDao = new UserDAOImpl();
	Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

	public void deleteUser(List<UserDetails> userDetailsList,int rollNo) {
		int flag=0;
		for(UserDetails userDetails : userDetailsList) {
			if(userDetails.getRollNo() == rollNo) {
				userDetailsList.remove(userDetails);
				logger.log(Level.INFO,"Successfully removed");
				flag=1;
			}
		}
		if(flag==0){
			logger.log(Level.INFO,"Invalid roll no.");
		}
	}

	public List<UserDetails> sortNameAndRoll(List<UserDetails> userDetailsList){
		 Collections.sort(userDetailsList, (UserDetails userDetails1, UserDetails userDetails2)->{
			 if(userDetails1.getName().equalsIgnoreCase(userDetails2.getName())) {
				 return userDetails1.getRollNo() - userDetails2.getRollNo();
			 }
			 else return userDetails1.getName().compareToIgnoreCase(userDetails2.getName());
		 });
		 return userDetailsList;
	}

	public List<UserDetails> sortUser(int choice,String order,List<UserDetails> usersList){
		List<UserDetails> userDetails = getSortedUserDetails(choice,usersList);
		if(order.equalsIgnoreCase("a")){
			return userDetails;
		}
		Collections.reverse(userDetails);
		return userDetails;
	}
	public List<UserDetails> getSortedUserDetails(int choice,List<UserDetails> userDetails){
		switch(choice) {
		case 1:
			userDetails.sort((UserDetails o1, UserDetails o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
			break;
		case 2:
			userDetails.sort(Comparator.comparingInt(UserDetails::getRollNo));
			break;
		case 3:
			userDetails.sort(Comparator.comparingInt(UserDetails::getAge));
			break;
		case 4:
			userDetails.sort((UserDetails o1, UserDetails o2) -> o1.getAddress().compareToIgnoreCase(o2.getAddress()));
			break;
		default :
			logger.log(Level.INFO, Constants.INVALID_INPUT);
		}

		return userDetails;
	}

	public String getFile() {
		return userDao.getFile();
	}

	public List<UserDetails> readFile(String fileName){
		return userDao.readFile(fileName);
	}

	public void writeFile(List<UserDetails> userDetails,String fileName) {
		userDao.writeFile(userDetails, fileName);
	}

}
