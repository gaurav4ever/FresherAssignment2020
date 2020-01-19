package Assignment_2.Sorting;

import Assignment_2.models.UserInfo;
import java.util.Comparator;

public class AgeComparator implements Comparator<UserInfo>{

    public int compare(UserInfo user1, UserInfo user2){
        if(user1.age == user2.age){
            return 0;
        }
        else if(user1.age>user2.age){
            return 1;
        }
        else{
            return -1;
        }
    }

}