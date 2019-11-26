package asgn2.sort;

import java.util.Comparator;

import asgn2.User;

public class SortByAddress implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return o1.getAddress().compareTo(o2.getAddress());
	}

}
