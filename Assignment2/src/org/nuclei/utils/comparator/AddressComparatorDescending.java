package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class AddressComparatorDescending implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user2.getAddress().compareToIgnoreCase(user1.getAddress());
    }

}
