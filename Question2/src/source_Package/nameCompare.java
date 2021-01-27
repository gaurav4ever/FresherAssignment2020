package source_Package;

import java.util.Comparator;

//To Sort Students based on Name using Comparator
public class nameCompare implements Comparator<student>{
    

	@Override
	public int compare(student n1, student n2) {
		
		if(n1.get_name().compareTo(n2.get_name())==0)
		{
			return n1.get_roll()-n2.get_roll();
		}
		else
		{
			return n1.get_name().compareTo(n2.get_name());
		}
	}

}
