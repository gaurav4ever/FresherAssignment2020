package assignment2.comparator;

import java.util.Comparator;
import assignment2.models.User;

public class UserComparatorByAgeAsc implements Comparator<User>{
    public int compare(User user1, User user2){
        if(user1.age.equals(user2.age)){
            return user1.rollno.compareTo(user2.rollno);
        }
        return user1.age.compareTo(user2.age);
    }
}