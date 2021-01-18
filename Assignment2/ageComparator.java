import java.util.Comparator;

public class ageComparator implements Comparator<userInfo>{
    
    public int compare(userInfo user1, userInfo user2){
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