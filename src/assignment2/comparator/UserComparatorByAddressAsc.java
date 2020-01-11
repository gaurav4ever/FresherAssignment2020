package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByAddressAsc implements Comparator<User>{
    public int compare(User user1, User user2){
        if(user1.address.equals(user2.address)){
            return user1.rollno.compareTo(user2.rollno);
        }
        return user1.address.compareTo(user2.address);
    }
}