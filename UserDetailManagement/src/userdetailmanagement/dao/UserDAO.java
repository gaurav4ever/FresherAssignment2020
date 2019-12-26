package userdetailmanagement.dao;

import java.util.List;

import userdetailmanagement.models.UserDetails;

//dao layer
public interface UserDAO {

	//creates file and returns its name
	String getFile();

	//write user detail in file
	void writeFile(List<UserDetails> list, String file);

	//read user details from the file
	List<UserDetails> readFile(String file);
	
}
