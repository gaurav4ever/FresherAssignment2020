/*
 * Created by Manu KJ 
 */
package Assignment2;

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentController studentController = new StudentController();

		while (true) {
			System.out.println(
					"\n\n\nMenu \n1. add Student \n2. display Student details \n3. delete Student details \n4. save Student details \n5. exit \nenter your choice \n");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				studentController.addStudent();
				break;
			case 2:
				System.out.println(
						"select 1 : Sort by Name\n select 2 : Sort by roll number \n select 3 : Sort by age \n select 4 : Sort by address");
				int c = sc.nextInt();
				sc.nextLine();
				studentController.disaplayAlllistOfStudents(c);
				break;
			case 3:
				System.out.println("Enter the rollnumber, whoes record needs to be deleted");
				int rollnumber = sc.nextInt();
				sc.nextLine();
				studentController.deleteStudent(rollnumber);
				break;
			case 4:
				studentController.saveStudentsDetails();
				break;
			case 5:
				System.out.println("do you want to store the latest changes to the disk? (y/n)");
				String saveData = sc.next();
				if (saveData.equalsIgnoreCase("y")) {

					studentController.saveStudentsDetails();
					System.out.println("details stored to memory");
				} else {
					System.out.println("details not stored ");
				}

				sc.close();
				System.exit(0);
			}
		}
	}
}
