package com.gonulcei.assignment.q2.util;

import java.util.Comparator;

import com.gonulcei.assignment.q2.model.User;

public class RollNoAscComparator implements Comparator<User> {

	@Override
	public int compare(User o1, User o2) {
		return o1.getRollNo()-o2.getRollNo();
	}

}
