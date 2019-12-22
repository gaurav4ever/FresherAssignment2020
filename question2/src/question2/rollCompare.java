package question2;

import java.util.Comparator;

public class rollCompare implements Comparator<user> {
	
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	
	int asc;
	int result;
	
	public rollCompare(int asc) {
		this.asc=asc;
	}
	
	
	@Override
	public int compare(user o1, user o2) {
		if(o1.getRollno()>o2.getRollno()) {
			result= 1;
		}
		else if(o1.getRollno()<o2.getRollno()) {
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
