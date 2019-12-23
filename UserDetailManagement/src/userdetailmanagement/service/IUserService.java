package userdetailmanagement.service;

import java.util.List;

import userdetailmanagement.models.UserDetails;

public interface IUserService {
	void deleteUser(List<UserDetails> userDetails, int rollNo);
	List<UserDetails> sortNameAndRoll(List<UserDetails> userDetails);
	List<UserDetails> getSortedUserDetails(int choice,List<UserDetails> userDetails);
	String getFile();
	List<UserDetails> readFile(String fileName);
	void writeFile(List<UserDetails> userDetails,String fileName);
	List<UserDetails> sortUser(int choice, String order,List<UserDetails> userDetails);
}
