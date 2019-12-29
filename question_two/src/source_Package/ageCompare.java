package source_Package;

import java.util.Comparator;

//To Sort List Based on Age using Comparator
public class ageCompare implements Comparator<student> {
	
	@Override
	public int compare(student n1,student n2)
	{
		if(n1.get_age()==n2.get_age())
		{
			return n1.get_roll()-n2.get_roll();
		}
		else
		{
			return n1.get_age()-n2.get_age();
		}
	}

}