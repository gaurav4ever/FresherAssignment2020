import java.util.Comparator;

public class rollComparator implements Comparator<userInfo>{
    
    public int compare(userInfo user1, userInfo user2){
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