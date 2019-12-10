package org.nuclei.utils.comparator;

import org.nuclei.model.User;

import java.util.Comparator;

public class DefaultComparator implements Comparator<User> {

     @Override
    public int compare(User user1, User user2) {
        if(user1.getFullName().equalsIgnoreCase(user2.getFullName())) {
            return user1.getRollNo() - user2.getRollNo();
        }
        else return user1.getFullName().compareToIgnoreCase(user2.getFullName());
    }

}
