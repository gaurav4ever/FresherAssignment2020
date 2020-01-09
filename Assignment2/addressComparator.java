import java.util.Comparator;

public class addressComparator implements Comparator<userInfo>{
    
    public int compare(userInfo user1, userInfo user2){
        if(user1.address.equals(user2.address)){
            return 0;
        }
        else if(user1.address.compareTo(user2.address)>0){
            return 1;
        }
        else{
            return -1;
        }
    }

}