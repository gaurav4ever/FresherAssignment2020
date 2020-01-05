package assignment2;
import java.util.*;

import java.util.stream.Stream; 
import java.util.stream.Collectors; 
public class Controller{
	Set<User> users;
	DiskHandler diskHandler = new DiskHandler();
	boolean isUpdated = false;
	Scanner sc = new Scanner(System.in);
	public void choice(Integer choice){
		switch(choice){
			case 1:
				UserCreator us = new UserCreator();
				User newUser = us.create();
				users.add(newUser);
				isUpdated = true;
				break;
			case 2:
				if(users.size()==0)
					System.out.println("No records to display.");
				else{
					System.out.println("Please select a field on which you want to sort :");
					System.out.println("1. Name");
					System.out.println("2. Roll No.");
					System.out.println("3. Age");
					System.out.println("4. Address");
					int op1, op2;
					while(true){
						op1 = Integer.parseInt(sc.nextLine());
						if(op1 < 1 || op1 > 4)
							System.out.println("Please select valid option[1-4].");
						else{
							System.out.println("Please select sorting method:");
							System.out.println("1. Ascending");
							System.out.println("2. Descending");
							while(true){
								op2 = Integer.parseInt(sc.nextLine());
							if(op2 < 1 || op2 > 2)
								System.out.println("Please select valid option[1,2].");
							else
								break;
							}
							break;
						}
					}
					final int opt1 = op1;
					final int opt2 = op2;
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("Name\t\tRoll No\t\tAge\t Address\t\tCourses");
					System.out.println("------------------------------------------------------------------------------------------");
					Stream<User> sortedUsers = users.stream().sorted((a, b) -> {
		            int result = 0;
		            switch (opt1) {
		                case 1:
		                    result = a.name.compareTo(b.name);
		                    break;
		                case 2:
		                    result = a.rollNumber - b.rollNumber;
		                    break;
		                case 3:
		                    result = a.age - b.age;
		                    break;
		                case 4:
		                    result = a.address.compareTo(b.address);
		                    break;
		            }
	            	if (opt2 == 2) result = -result;
		            return result;
	    		    });
					sortedUsers.forEach(x -> x.print());
					break;
				}
			case 3:
				System.out.println("Enter roll number to delete record:");
				int roll = Integer.parseInt(sc.nextLine());
				int len = users.size();
				for(User user : users)
					if(user.rollNumber == roll){
						System.out.println("The following record is deleting...\n\n");
						System.out.println("------------------------------------------------------------------------------------------");
						System.out.println("Name\t\tRoll No\t\tAge\t Address\t\tCourses");
						System.out.println("------------------------------------------------------------------------------------------");
						user.print();
						users.remove(user);
						System.out.println("User deleted successfully.");
						isUpdated = true;
					}
				if(len == users.size())
					System.out.printf("No record found for this roll number.\n");
				break;
			case 4:
				if(users.size()==0)
					System.out.println("No users to save.");
				else
					diskHandler.saveToDisk(users);
				isUpdated = false;
				break;
		}
	}

	public void start(){
		users = diskHandler.getFromDisk();	
		while(true){
			Scanner sc = new Scanner(System.in);
			System.out.println("Select option :");
			System.out.println("1. Add User Details");
			System.out.println("2. Display User Details");
			System.out.println("3. Delete User Details");
			System.out.println("4. Save User Details");
			System.out.println("5. Exit");
			String choice = sc.nextLine();
			try{
				Integer option = Integer.parseInt(choice);
				if(option < 1 || option >5){
					throw new NumberFormatException(); 
				}
				if(option == 5){
					if(isUpdated){
						System.out.println("Do you want to save changes?[y/n]");
						while(true){
							String opt = sc.nextLine();
							if (opt.equals("y")){
								diskHandler.saveToDisk(users);
								break;
							}
							else
								if(opt.equals("n"))
									break;
								else
									System.out.println("Please enter valid input  [y/n]");
						}
					}
					break;
				}
				choice(option);
			}
			catch(NumberFormatException e){
				System.out.println("Please povide valid input.");
			}
		}	
	}

}