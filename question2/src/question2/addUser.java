package question2;
import java.util.*;
import java.io.*;


public class addUser {

	public static ArrayList<user> users ;
	public static user user1;
	public static HashSet<Integer> rollSet= new HashSet<>();
	
	public addUser() {
		displayUser disp = new displayUser();
		this.users=disp.readFromFile();
		
		for(user u1:users)
			rollSet.add(u1.getRollno());
	}
	
	public void AddUser() {
		Scanner sc = new Scanner(System.in);
		String name , address;
		int age,rollno,flag=1;
		ArrayList<String> subj = new ArrayList<String>();
		int max_sub=6;
		System.out.println("enter name");
		name=sc.next();
		System.out.println("enter roll no");
		rollno=sc.nextInt();
		
		if(rollSet.contains(rollno))
			flag=0;
		else
			rollSet.add(rollno);
		
		System.out.println("enter age");
		age = sc.nextInt();
		System.out.println("enter address");
		address = sc.next();
		
		int count=0;
		System.out.println("Available Subjects are A,B,C,D,E,F ");
		while(count<max_sub)
		{
		    System.out.println("want to add subject ? if yes type 'y/Y' else type any character ");
		    ArrayList<String> availableSubjects= new ArrayList<>(Arrays.asList("A","B","C","D","E","F"));
		    String st = sc.next();
		    if(st.equalsIgnoreCase("y"))
		    {
			String sub = sc.next();
		        if(availableSubjects.contains(sub))
			   subj.add(sub);
		        else {
			   System.out.println("Available Subjects are A,B,C,D,E,F only.Select Among these !!");
			   count=count-1;
			 }
		    }
		    else if(count<4 && !(st.equalsIgnoreCase("y"))) {
			System.out.println("enter atleast 4 subjects");
		    }
		    else
			break;
		  count++;	
		}

		if(flag==1) {
		  user1 = new user(name,age,rollno,address,subj);
		  users.add(user1);
		}
		else if(flag==0){
		  System.out.println("This user Already Exists !! ");
		}
	}
}
