package userdetailmanagement.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import userdetailmanagement.UserUtil.AscAddressComparator;
import userdetailmanagement.UserUtil.AscAgeComparator;
import userdetailmanagement.UserUtil.AscNameComparator;
import userdetailmanagement.UserUtil.AscRollNoComparator;
import userdetailmanagement.UserUtil.ComparatorNameAndRoll;
import userdetailmanagement.UserUtil.DescAddressComparator;
import userdetailmanagement.UserUtil.DescAgeComparator;
import userdetailmanagement.UserUtil.DescNameComparator;
import userdetailmanagement.UserUtil.DescRollNoComparator;
import userdetailmanagement.model.User;

public class UserService {
	static Scanner sc=new Scanner(System.in);
	
	public boolean verifiedRollNo(int rollNo,List<User> l) {
		for(User user : l) {
			if(user.getRollNo() == rollNo) {
				System.out.println("This roll no already exist. Please re-enter unique roll no.");
				return false;
			}
		}
		return true;
	}
	
	public void deleteUser(List<User> l,int rollNo) {
		//List<User> l = findAllUser();
		int i=0;
		for(User user : l) {
			if(user.getRollNo() == rollNo) {
				break;
			}
			i++;
		}
		if(i==l.size()) {
			System.out.println("Invalid roll no");
		}
		else {
			l.remove(i);
			System.out.println("Successfully removed");
		}
	}
	public List<User> sortNameAndRoll(List<User> userList){
		 Collections.sort(userList, new ComparatorNameAndRoll());
		 return	userList; 
	}
	

	public void displayUser(List<User> l) {
		System.out.println("-----------------------------------------------------------------------------------------");
		String head = String.format("%1$-15s %2$-15s %3$-15s %4$-20s %5$-10s", "Name", "Roll Number", "Age", "Address", "Courses");
		System.out.println(head);
		System.out.println("-----------------------------------------------------------------------------------------");
		for(User user: l) {
			System.out.println(user);
		}	
		System.out.println();
	}
	
	
	public List<User> getSortedUserDetails(int choice, int order,List<User> users){
		//List<User> users = findAllUser();
		switch(choice) {
		case 1:
			if(order == 'a') {
				Collections.sort(users,new AscNameComparator());
			}
			else {
				Collections.sort(users,new DescNameComparator());
			}
			break;
		case 2:
			if(order == 'a') {
				Collections.sort(users,new AscRollNoComparator());
			}
			else {
				Collections.sort(users,new DescRollNoComparator());
			}
			break;
		case 3:
			if(order == 'a') {
				Collections.sort(users,new AscAgeComparator());
			}
			else {
				Collections.sort(users,new DescAgeComparator());
			}
			break;
		case 4:
			if(order == 'a') {
				Collections.sort(users,new AscAddressComparator());
			}
			else {
				Collections.sort(users,new DescAddressComparator());
			}
			break;
		default :
			System.out.println("Invalid Input");
		}
		
		return users;
	}
	
	
	public static List<User> readFile(String file) {
        List<User> list = new ArrayList<>();
        ObjectInputStream inputStream=null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(file));
            //reading of data from the file
            while (true) {
            	User p = (User) inputStream.readObject();
                list.add(p);
            }
        } catch (Exception e) {
            //System.err.println("Error opening file."+e);
        } finally {
            try {
                if (inputStream != null)
                    inputStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
        return list;
    }

    // saves data in disk by writing each item of the list to disk
    public static void writeFile(List<User> list, String file) {
        ObjectOutputStream outStream = null;
        try {
            outStream = new ObjectOutputStream(new FileOutputStream(file));
            for (User p : list) {
                outStream.writeObject(p);
            }
        } catch (Exception e) {
            System.err.println("Error in wirtting items!");
        } finally {
            try {
                if (outStream != null)
                    outStream.close();
            } catch (IOException ioException) {
                System.err.println("Error closing file.");
            }
        }
    }

    // extract student file from memory if exists
    public static String getFile() {
        String fileName = "/Users/vishalsinghal/Desktop/nuclei_assignment/FresherAssignment2020/usersData.txt";
        File file = new File(fileName);
        try {
            if (file.createNewFile()) {
                // File created in root directory
            } else {
                // File already exists in root directory
            }
        } catch (IOException e) {
            System.out.print("Users Record not found!");
            e.printStackTrace();
        }
        return fileName;
    }
}
