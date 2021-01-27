package source_Package;

import java.util.HashSet;
import java.util.Scanner;
import java.io.Serializable;

//To Save Courses Chosen By a Student
public class course implements Serializable{
	
	private static final long serialVersionUID = 2L;
	private int num;								//Number of courses to be undertaken by a student
	private String[] courses;						//Array of Courses undertaken by a student
	private static HashSet<String> maxset = new HashSet<>();
	
	//Initializes a HashSet with All Possible Types of Subjects For Check of Existence Later
	public static void initialize()
	{
		maxset.add("A");
		maxset.add("B");
		maxset.add("C");
		maxset.add("D");
		maxset.add("E");
		maxset.add("F");
	}
	
	course(int num)
	{
		this.num = num;
		courses = new String[num];
		initialize();
		assign_courses();
	}

	void assign_courses()
	{
		String res;
		Scanner sc = new Scanner(System.in);
		HashSet<String> hs = new HashSet<>();
		for(int i=0;i<num;++i)
		{
			while(true)
			{
				System.out.println("Enter Subject Number "+(i+1));
				res = sc.nextLine();
				if(hs.contains(res))
				{
					System.out.println("Subject Is Already Present! Try Again");
				}
				else
				{
					if(maxset.contains(res))
					{
						hs.add(res);
						courses[i] = res;
						System.out.println("Course Added");
						break;
					}
					else
					{
						System.out.println("Invalid Subject! Enter Again");
					}
				}
			}
		}
	}
	
	void print_courses()
	{
		for(String str : courses)
		{
			System.out.print(str+" ");
		}
	}
	
}
