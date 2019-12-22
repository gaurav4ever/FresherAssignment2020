package question2;

import java.util.Comparator;

public class AgeCompare implements Comparator<user> {
	
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	
	int asc;
	int result;
	
	public AgeCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user o1, user o2) {
		if(o1.getAge()>o2.getAge()) {
			result= 1;
		}
		else if(o1.getAge()<o2.getAge()) {
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
