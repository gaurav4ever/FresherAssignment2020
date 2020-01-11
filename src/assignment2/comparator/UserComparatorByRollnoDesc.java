package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByRollnoDesc implements Comparator<User>{
    public int compare(User user1, User user2){
        return user2.rollno.compareTo(user1.rollno);
    }
}
