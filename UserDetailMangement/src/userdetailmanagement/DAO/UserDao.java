package userdetailmanagement.DAO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import userdetailmanagement.UserUtil.ComparatorNameAndRoll;
import userdetailmanagement.model.User;

public class UserDao {
	List<User> users=new ArrayList<>();
	
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
}
