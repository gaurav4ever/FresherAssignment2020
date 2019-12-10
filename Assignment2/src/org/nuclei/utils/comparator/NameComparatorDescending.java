package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class NameComparatorDescending implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user2.getFullName().compareToIgnoreCase(user1.getFullName());
    }

}
