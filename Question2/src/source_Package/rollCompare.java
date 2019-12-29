package source_Package;

import java.util.Comparator;

//To sort students based on roll numbers using comparators
public class rollCompare implements Comparator<student> {

	@Override
	public int compare(student n1,student n2)
	{
		return n1.get_roll()-n2.get_roll();
	}
}
