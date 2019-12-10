package userdetailmanagement.UserUtil;

import java.util.Comparator;

import userdetailmanagement.model.User;

public class AscAddressComparator implements Comparator<User>{

	@Override
	public int compare(User o1, User o2) {
		return o1.getAddress().compareToIgnoreCase(o2.getAddress());
	}

}
