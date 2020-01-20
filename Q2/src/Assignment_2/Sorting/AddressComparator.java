package Assignment_2.Sorting;

import Assignment_2.models.UserInfo;
import java.util.Comparator;

public class AddressComparator implements Comparator<UserInfo> {

    public int compare(UserInfo user1, UserInfo user2) {
        if (user1.address.equals(user2.address)) {
            return 0;
        } else if (user1.address.compareTo(user2.address) > 0) {
            return 1;
        } else {
            return -1;
        }
    }

}