package question2;

import java.util.Comparator;

public class nameCompare implements Comparator<user>{
	/** 
	 *  asc=1 then it is ascending 
	 *  if asc= 2 then descending 
	 */
	int asc;
	int result;
	
	public nameCompare(int asc) {
		this.asc=asc;
	}
	
	@Override
	public int compare(user o1, user o2) {
		
		if(o1.getName().compareTo(o2.getName())>0) {
			result= 1;
		}
		else if(o1.getName().compareTo(o2.getName())<0) {
			result= -1;
		}
		else {
			//if both names are same then arrange based on their roll numbers
			return o1.getRollno() - o2.getRollno();
		}
		if(asc==2) {
			result*=-1;
		}
		return result;
	}

}
