package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByNameAsc implements Comparator<User> {
    public int compare(User user1, User user2) {
        if (user1.name.equals(user2.name)) {
            return user1.rollno.compareTo(user2.rollno);
        } else {
            return user1.name.compareTo(user2.name);
        }
    }
}
