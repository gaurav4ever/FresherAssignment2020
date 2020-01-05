package assignment2;
import java.util.*;
import java.io.Serializable;

public class UserCreator{
	public User create(){
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter new user details");
        System.out.print("Enter Name : ");
        String name = sc.nextLine();
        System.out.print("Enter Age : ");
        int age, roll;

        age = Integer.parseInt(sc.nextLine());
        if (age <= 0) throw new RuntimeException("Age must be a valid positive integer");

        System.out.print("Enter Address : ");
        String address = sc.nextLine();

        System.out.print("Enter Roll Number : ");
        try{
        	roll = Integer.parseInt(sc.nextLine());
        	if (roll <= 0) throw new RuntimeException();
        }
        catch(RuntimeException e){
        	throw new RuntimeException("Roll number must be a valid positive integer");
        }

        System.out.print("Enter space separated four cources (Available courses A, B, C, D, E, F): ");
        Set<String> validCourses = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F"));
        Set<String> courses = new HashSet<>(Arrays.asList(sc.nextLine().split(" ")));
		

        try{
        	if (courses.size() < 4)
            	throw new RuntimeException("You must choose at least 4 out of 6 courses ! ");
        }
        catch(RuntimeException e){
        	throw new RuntimeException("You must choose at least 4 out of 6 courses ! ");
        }
        for(String course : courses){
        	try{
				if(validCourses.add(course))
	        		throw new RuntimeException();
	        }
	        catch(RuntimeException e){
	        	throw new RuntimeException("Courses should be A, B, C, D, E or F.");
	        }
        
        }
        return new User(name, age, address, roll, courses);
    }
}