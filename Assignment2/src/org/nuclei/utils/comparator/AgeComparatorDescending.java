package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class AgeComparatorDescending implements Comparator<User> {

    @Override
    public int compare(User user1, User user2) {
        return user2.getAge() - user1.getAge();
    }

}
