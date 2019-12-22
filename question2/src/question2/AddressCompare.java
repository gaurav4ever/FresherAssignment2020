package question2;

import java.util.Comparator;

public class AddressCompare implements Comparator<user>{
	int asc;
	int result;
	
	public AddressCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user o1, user o2) {
		if(o1.getAddress().compareTo(o2.getAddress())>0) {
			result= 1;
		}
		else if(o1.getAddress().compareTo(o2.getAddress())<0) {
			result= -1;
		}
		else {
			result= 0;
		}
		if(asc==2) {
			result*=-1;
		}
		return result;
	}
}
