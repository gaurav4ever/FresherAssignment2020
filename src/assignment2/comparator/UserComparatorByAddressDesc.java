package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByAddressDesc implements Comparator<User>{
    public int compare(User user1, User user2){
        if(user2.address.equals(user1.address)){
            return user2.rollno.compareTo(user1.rollno);
        }
        return user2.address.compareTo(user1.address);
    }
}