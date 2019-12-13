package userdetailmanagement.UserUtil;

import java.util.Comparator;

import userdetailmanagement.model.User;

public class ComparatorNameAndRoll implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		if(user1.getName().equalsIgnoreCase(user2.getName())) {
			return user1.getRollNo() - user2.getRollNo();
		}
		else return user1.getName().compareToIgnoreCase(user2.getName());
	}
	
}
