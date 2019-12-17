package userdetailmanagement.dao;

import java.util.List;

import userdetailmanagement.models.User;

public interface UserDAO {
	public String getFile();
	public void writeFile(List<User> list, String file);
	public List<User> readFile(String file);
	
}
