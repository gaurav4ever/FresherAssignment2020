package com.gonulcei.assignment.q2.util;

import java.util.Comparator;

import com.gonulcei.assignment.q2.model.User;

public class NameDescComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		return -1*user1.getFullname().compareToIgnoreCase(user2.getFullname());
	}

}
