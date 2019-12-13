package userdetailmanagement.UserUtil;

import java.util.Comparator;

import userdetailmanagement.model.User;

public class DescAddressComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return -1*o1.getAddress().compareToIgnoreCase(o2.getAddress());
	}

}
