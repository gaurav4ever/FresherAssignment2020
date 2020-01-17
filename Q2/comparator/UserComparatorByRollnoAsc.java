package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByRollnoAsc implements Comparator<User> {
    public int compare(User user1, User user2) {
        return user1.rollno.compareTo(user2.rollno);
    }
}
