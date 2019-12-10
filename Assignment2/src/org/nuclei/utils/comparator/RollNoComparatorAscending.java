package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class RollNoComparatorAscending implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getRollNo() - user2.getRollNo();
    }

}
