package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByAgeDesc implements Comparator<User>{
    public int compare(User user1, User user2){
        if(user2.age.equals(user1.age)){
            return user2.rollno.compareTo(user1.rollno);
        }
        return user2.age.compareTo(user1.age);
    }
}