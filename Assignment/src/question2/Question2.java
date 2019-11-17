package question2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Aditya
 */
class User implements Serializable {

    private String fullName;
    private int age;
    private String Address;
    private int rollNumber;
    private Set<String> courses;

    public User() {
        courses = new HashSet<>();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName.toUpperCase();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public Set<String> getCourses() {
        return courses;
    }

    public void setCourses(Set<String> courses) {
        this.courses = courses;
    }

}

class UserServices implements Serializable {

    //rollnumber , user
    Scanner sc = new Scanner(System.in);
    Set<String> availableCourses = new HashSet(Arrays.asList("A", "B", "C", "D", "E", "F"));
    String error = "Invalid Input !! Try Again";
    
    private ArrayList<User> users; //To Store different users
    private Set<Integer> uniqueRollNumbers; //To mark rollNumber of Users uniquely

    public void setUniqueRollNumbers(Set<Integer> uniqueRollNumbers) {
        this.uniqueRollNumbers = uniqueRollNumbers;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public void addUser() {
        User new_user = new User();
        System.out.println("Enter Full Name");
        String fullName = sc.next();
        new_user.setFullName(fullName);

        System.out.println("Enter you age");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.next());
                
                if (age >= 1) {
                    
                    break;
                } else {
                    System.out.println("Inappropriate Age!!"); //Age cannot be zero or negative
                }
            } catch (NumberFormatException ex) {
                System.out.println(error);

            }

        }
        new_user.setAge(age);

        System.out.println("Enter your address");
        String address = sc.next();
        new_user.setAddress(address);

        int rollNo;
        System.out.println("Enter RollNo. ");
        while (true) {

            while (true) {
                try {
                    rollNo = Integer.parseInt(sc.next());
                    if (rollNo >= 1) {
                        //Roll No can not be 0 or negative
                        break;
                    } else {
                        System.out.println("Inappropriate RollNo");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println(error);

                }

            }

            if (uniqueRollNumbers.contains(rollNo)) {
                System.out.println("Roll Number already Exist, Try Again!!");
            } else {
                uniqueRollNumbers.add(rollNo);
                break;
            }

        }
        new_user.setRollNumber(rollNo);

        Set<String> courses = new HashSet<>();

        int count = 0;
        System.out.println("Select 4 courses from " + availableCourses.toString());
        while (count != 4) {

            System.out.println("Enter " + (count + 1) + " course:");
            String course = sc.next().toUpperCase();
            while (!availableCourses.contains(course) || courses.contains(course)) {
                System.out.println("Error!! Either Course not available or already selected");
                System.out.println("Try Again");
                course = sc.next().toUpperCase();
            }
            courses.add(course);

            count++;
        }
        new_user.setCourses(courses);

        users.add(new_user);
        System.out.println("User Successfully Added!!!");

    }

    public void displayUsers() {
        System.out.println("How you want to display data");
        System.out.println("1. Sort on basis of Name");
        System.out.println("2. Sort on basis of RollNo");
        System.out.println("3. Sort on basis of Age");
        System.out.println("4. Sort on basis of Address");
        System.out.println("5. Go Back");
        System.out.println("Enter an option (1,2,3,4,5) : ");
        int option;
        while (true) {
            try {
                option = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid Input !! Try Again!!");
            }
        }

        switch (option) {
            case 1:
                //Compare wrt to names of users
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getFullName().compareTo(u2.getFullName());
                    }
                });
                break;
            case 2:
                //Compare wrt to roll numbers of users
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getRollNumber() - u2.getRollNumber();
                    }
                });
                break;
            case 3:
              //Compare wrt to ages of users
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getAge() - u2.getAge();
                    }
                });
                break;
            case 4:
                 //Compare wrt to ages of users
                Collections.sort(users, new Comparator<User>() {
                    @Override
                    public int compare(User u1, User u2) {
                        return u1.getAddress().compareTo(u2.getAddress());
                    }
                });
                break;
            case 5:
                return;

        }

        System.out.println("------------------------------------------------------------------------");
//         System.out.format("%10s%10s%10s%10s%0s", "Name", "RollNumber","Age","Address","Courses");
        System.out.println("Name\t\tRollNumber\t\tAge\t\tAddress\t\tCourses");
        System.out.println("------------------------------------------------------------------------");
        for (User u : users) {
            System.out.println(u.getFullName() + "\t\t" + u.getRollNumber() + "\t\t" + u.getAge() + "\t\t" + u.getAddress() + "\t\t"
                    + u.getCourses().toString());
        }

    }

    public int findIndex(int rollNo) {
        int i = 0;
        for (User u : users) {
            if (rollNo == u.getRollNumber()) {
                break;
            }
            i++;
        }
        return i;
    }

    public void deleteUser() {
        System.out.println("Enter Roll Number of User to be deleted");
        int rollNo;
        while (true) {
            try {
                rollNo = Integer.parseInt(sc.next());
                if (rollNo < 1) {
                    System.out.println("Inappropriate RollNo");
                } else {
                    if (uniqueRollNumbers.contains(rollNo)) {
                        //if roll number exist then perform delete operation
                        uniqueRollNumbers.remove(rollNo);

                        int index = findIndex(rollNo);
                        users.remove(index);
                        System.out.println("User Deleted Succesfully");
                        break;
                    } else {
                        System.out.println("User Doesn't exit"); // Roll number doesnt exit
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println(error);

            }

        }

    }

    public void saveToDisk() {
        // FIle names to store user data
        String filename = "D:\\users.bin";
        String rollfile = "D:\\rollno.bin";
        try {
            //saving users list
            ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream(filename));
            outStream.writeObject(users);
            
//            saving roll number set
            outStream = new ObjectOutputStream(new FileOutputStream(rollfile));
            outStream.writeObject(uniqueRollNumbers);
            outStream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        System.out.println("Succesfully Saved");
    }

    public void exitRequest() {
        System.out.println("Do you want to save changes. Enter [y] to proceed . Else enter anything ");
        String option = sc.next();
        if (option.equals("y")) {
            saveToDisk();
        }
    }
}

public class Question2 {

    public static Set<Integer> loadRoll() {
        ObjectInputStream inStream = null;
        Set<Integer> rollnos = null;
        try {
            String filename = "D:\\rollno.bin";
            inStream = new ObjectInputStream(new FileInputStream(filename));
            rollnos = (Set<Integer>) inStream.readObject();
        } catch (Exception ex) {

            rollnos = new HashSet<>();
            System.out.println("Load Error " + ex);
        }

        return rollnos;
    }

    public static ArrayList<User> loadUserList() {
        ObjectInputStream inStream = null;
        ArrayList<User> users = null;
        try {
            String filename = "D:\\users.bin";
            inStream = new ObjectInputStream(new FileInputStream(filename));
            users = (ArrayList<User>) inStream.readObject();
        } catch (Exception ex) {

            users = new ArrayList<>();
           
        }

        return users;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //load file if it exit or create new instance UserList
        UserServices service = new UserServices();
        ArrayList<User> users = loadUserList();
        service.setUsers(users);
        Set<Integer> uniqueRollNumbers = loadRoll();
        service.setUniqueRollNumbers(uniqueRollNumbers);

        while (true) {

            System.out.println("Main Menu");
            System.out.println("1. Add User details.");
            System.out.println("2. Display User details.");
            System.out.println("3. Delete User details.");
            System.out.println("4. Save User details.");
            System.out.println("5. Exit.");

            System.out.println("Enter an option (1,2,3,4,5) : ");
            int option;
            while (true) {
                try {
                    option = Integer.parseInt(sc.next());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid Input !! Try Again!!");
                }
            }

            switch (option) {
                case 1:
                    service.addUser();
                    break;
                case 2:
                    service.displayUsers();
                    break;
                case 3:
                    service.deleteUser();
                    break;
                case 4:
                    service.saveToDisk();
                    break;
                case 5:
                    service.exitRequest();
                    return;

            }

        }
    }
}
