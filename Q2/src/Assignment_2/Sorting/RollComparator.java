package Assignment_2.Sorting;

import Assignment_2.models.UserInfo;
import java.util.Comparator;

public class RollComparator implements Comparator<UserInfo>{

    public int compare(UserInfo user1, UserInfo user2){
        if(user1.rollNumber == user2.rollNumber){
            return 0;
        }
        else if(user1.rollNumber>user2.rollNumber){
            return 1;
        }
        else{
            return -1;
        }
    }

}