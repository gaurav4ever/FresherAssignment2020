package userdetailmanagement.UserUtil;

import java.util.Comparator;

import userdetailmanagement.model.User;

public class DescNameComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return -1*o1.getName().compareToIgnoreCase(o2.getName());
	}
	
}
