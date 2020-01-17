package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByNameDesc implements Comparator<User> {
    public int compare(User user1, User user2) {
        if (user2.name.equals(user1.name)) {
            return user2.rollno.compareTo(user1.rollno);
        } else {
            return user2.name.compareTo(user1.name);
        }
    }
}
