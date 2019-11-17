package com.gonulcei.assignment.q2.util;

import java.util.Comparator;

import com.gonulcei.assignment.q2.model.User;

public class NameAndRollNumberComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		if(user1.getFullname().equalsIgnoreCase(user2.getFullname())) {
			return user1.getRollNo() - user2.getRollNo();
		}
		else return user1.getFullname().compareToIgnoreCase(user2.getFullname());
	}

}
