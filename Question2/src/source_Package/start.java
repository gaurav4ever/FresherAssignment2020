package source_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.util.Scanner;
import java.util.Collections;
import java.util.HashMap;

public class start {
	
	//This function is used only for JUnit Testing
	public static student add_user_test(String name,int roll_no,String addr,int age)
	{
		return new student(name,roll_no,addr,age);
	}
	

	//The main function 
	public static void main(String[] args) {
		
		int ans=8,med_ans;
		String response,res2;
		HashMap<Integer,student> hm = new HashMap<>();
		ArrayList<student> arr = new ArrayList<>();
		nameCompare nc = new nameCompare();
		ageCompare ac = new ageCompare();
		rollCompare rc = new rollCompare();
		parser p = new parser();
        String file = "C:\\Users\\Mahe\\Desktop\\dot.txt";
        save_data sv = new save_data(file);
        if(sv.pop_data()==1)
        {
        	arr = sv.get_list();
        }
        arr.forEach((stud)-> hm.put(stud.get_roll(),stud));
		Scanner sc = new Scanner(System.in);
		
		while(ans!=5)
		{
			System.out.println("Press 1 to Enter Records");
			System.out.println("Press 2 to Display Records");
			System.out.println("Press 3 to Delete a Record");
			System.out.println("Press 4 to Save Records to Disk");
			System.out.println("Press 5 to Exit");
			try
			{
				ans = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Entry!Try Again");
				continue;
			}
			switch(ans)
			{
				case 1 : med_ans = p.parseme(hm);
						 if(med_ans==-1)
						 {
							 System.out.println("Couldnt Insert Record For Above Reason!Try Again.");
						 }
						 else
						 {
							 student s = new student(p.get_name(),p.get_roll(),p.get_addr(),p.get_age(),p.get_num_courses());
							 arr.add(s);
							 hm.put(p.get_roll(),s);
							 System.out.println("Inserted");
						 }
						 break;
				case 2 : System.out.println("Press 1 to Sort by name");
						 System.out.println("Press 2 to Sort by Age");
						 System.out.println("Press 3 to Sort by roll number");
						 response = sc.nextLine();
						 System.out.println("Press 1 for Descending");
						 System.out.println("Press any other key for Ascending");
						 res2 = sc.nextLine();
						 switch(response)
						 {
						 	case "1" :  Collections.sort(arr,nc);
						 				if(res2.equals("1"))
						 			    {
						 					Collections.reverse(arr);
						 				}
						 				break;
						 	case "2" : Collections.sort(arr,ac);
						 			   if(res2.equals("1"))
						 			   {
						 				   Collections.reverse(arr);
						 			   }
						 			   break;
						 	case "3" : Collections.sort(arr,rc);
				 			   		   if(res2.equals("1"))
				 			           {
				 			   			    Collections.reverse(arr);
				 			           }
				 			   		   break;
				 			default: System.out.println("Invalid Option! Displaying based on name");
				 					 Collections.sort(arr,nc);
				 					 if(res2.equals("1"))
				 					 {
				 						 Collections.reverse(arr);
				 					 }
						 }
						 for(student stud : arr)
						 {
							 System.out.print(stud.get_name()+" "+stud.get_roll()+" "
									 +stud.get_age()+" "+stud.get_addr()+" ");
							 stud.print_courses();
							 System.out.println();
						 }
						 break;
				case 3 : System.out.println("Enter Roll Number To be deleted");
						 try
						 {
							 med_ans = Integer.parseInt(sc.nextLine());
						 }
						 catch(NumberFormatException e)
						 {
							 System.out.println("Invalid Entry! Try Again");
							 break;
						 }
						 if(hm.containsKey(med_ans))
						 {
							 arr.remove(hm.get(med_ans));
							 hm.remove(med_ans);
							 System.out.println("Deleted");
						 }
						 else
						 {
							 System.out.println("Roll Number Not Present in Database!Try Again.");
						 }
						 break;
				case 4 : sv.push_data(arr);
						 break;
				case 5 : System.out.println("Do You Want to Save Data Before Exiting? Press 1 to save data.");
						 res2 = sc.nextLine();
						 if(res2.equals("1"))
						 {
							 sv.push_data(arr);
						 }
						 break;
				default:System.out.println("Invalid Option! Try Again.");
			}
		}
		System.out.println("Deallocating Resources");
		arr.clear();
		sc.close();
		hm.clear();
		System.out.println("Terminating");
	}

}
