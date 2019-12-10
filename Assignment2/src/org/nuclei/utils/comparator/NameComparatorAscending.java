package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class NameComparatorAscending implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user1.getFullName().compareToIgnoreCase(user2.getFullName());
    }

}
