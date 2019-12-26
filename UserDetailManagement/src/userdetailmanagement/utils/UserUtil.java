package userdetailmanagement.utils;

import java.util.List;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;
import userdetailmanagement.models.UserDetails;
import userdetailmanagement.service.implementation.UserServiceImpl;

public class UserUtil {

  static Scanner sc = new Scanner(System.in);
  Logger logger  = Logger.getLogger(UserUtil.class.getName());
  UserServiceImpl service = new UserServiceImpl();


  public int getSortingMenu() {
    int choice = 0;
    logger.log(Level.INFO,"Select an attribute based on which you wanna sort");
    logger.log(Level.INFO,"1. Name");
    logger.log(Level.INFO,"2. Roll Number");
    logger.log(Level.INFO,"3. Age");
    logger.log(Level.INFO,"4. Address");
    try {
      choice = sc.nextInt();
    } catch (Exception e) {
      logger.log(Level.INFO,"Invalid Choice");
    }
		if (choice == 0) {
			return getSortingMenu();
		} else {
			return choice;
		}
  }


  public void start() {
    String userRecFileName = service.getFile();
    List<UserDetails> userDetailsRecordList = service.readFile("/Users/vishalsinghal/Desktop/nuclei_assignment/FresherAssignment2020/usersData.txt");

    while (true) {
      logger.log(Level.INFO, "Select an option - \n1.Add user\n2.Display user\n3.Delete user\n4.Save user\n5.Exit");
      int t = sc.nextInt();
      switch (t) {
        case 1:
          UserDetailsInput userDetailsInput = new UserDetailsInput();
          UserDetails userDetails = userDetailsInput.getUserInput(userDetailsRecordList);
          userDetailsRecordList.add(userDetails);
          break;
        case 2:
          UserDetailsOutput userDetailsOutput = new UserDetailsOutput();
          service.sortNameAndRoll(userDetailsRecordList);
          userDetailsOutput.displayUser(userDetailsRecordList);
          sc.nextLine();
          logger.log(Level.INFO,"Press -> 's' for sorting menu. (Any other key for main menu)");
          char check = sc.nextLine().toLowerCase().charAt(0);
          while (check == 's') {
            int choice = getSortingMenu();
            sc.nextLine();
            logger.log(Level.INFO,"Press 'a' for ascending and 'd' for descending");
            String order = sc.nextLine().toLowerCase();
            List<UserDetails> users = service.sortUser(choice,order, userDetailsRecordList);
            userDetailsOutput.displayUser(users);
            logger.log(Level.INFO,
                "Press -> 's' for sorting menu. Press any other key to go back to main menu.");
            check = sc.nextLine().toLowerCase().charAt(0);
          }
          break;
        case 3:
          logger.log(Level.INFO,"Enter roll no of the user");
          int rollNo = sc.nextInt();
          sc.nextLine();
          service.deleteUser(userDetailsRecordList, rollNo);
          break;
        case 4:
          service.writeFile(userDetailsRecordList, userRecFileName);
          break;
        case 5:
          sc.nextLine();
          logger.log(Level.INFO,"Do you want to save the latest changes [y/n]");
          char ch = sc.nextLine().toLowerCase().charAt(0);
					if (ch == 'y') {
						service.writeFile(userDetailsRecordList, userRecFileName);
					}
          logger.log(Level.INFO,"Thank you. Bye");
					break;
        default:
          logger.log(Level.INFO,"Wrong option. Please select correct option.");
          break;
      }
      if(t==5){
        break;
      }
    }
  }
}
