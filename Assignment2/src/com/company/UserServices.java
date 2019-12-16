package com.company;

import java.io.*;
import java.util.*;

public class UserServices {

    Scanner sc = new Scanner(System.in);

    //datastructure to store in ascending order on basis of fullname and on rollno and if fullname is same
    TreeSet<User> users = new TreeSet<>(new Comparator<User>() {
        @Override
        public int compare(User o1, User o2) {
            int fullNameCompare = o1.getFullName().compareTo(o2.getFullName());
            if (fullNameCompare != 0)
                return fullNameCompare;
            else
                return o1.getRollNumber() - o2.getRollNumber();

        }
    });

    Set<String> availableCourses = new HashSet<>(Arrays.asList("A", "B", "C", "D", "E", "F")); // providing list of courses
    String error = "Invalid input! Try again!!";

    private Set<Integer> uniqueRollNumbers; // students have unique roll numbers
    private ArrayList<User> userlist;


    public void setUniqueRollNumbers(Set<Integer> uniqueRollNumbers) {
        this.uniqueRollNumbers = uniqueRollNumbers;
    }

    public TreeSet<User> getUsers() {
        return users;
    }

    public void setUsers(TreeSet<User> users) {
        this.users = users;
    }

    public void addUser() {

        User new_user = new User();

        //getting one by one details of user
        System.out.println("Enter full name");
        String fullName = sc.next();
        if (!fullName.isBlank())
            new_user.setFullName(fullName);


        System.out.println("Enter age");
        int age;
        while (true) {
            try {
                age = Integer.parseInt(sc.next());
                if (age >= 1)
                    break;
                else
                    System.out.println("Inappropriate age...!!!");
            } catch (NumberFormatException ex) {
                System.out.println(error);
            }
        }
        new_user.setAge(age);

        System.out.println("Enter address");
        String address = sc.next();
        if (!address.isBlank())
            new_user.setAddress(address);

        System.out.println("Enter roll number");
        int rollNo;
        while (true) {
            while (true) {
                try {
                    rollNo = Integer.parseInt(sc.next());
                    break;
                } catch (NumberFormatException ex) {
                    System.out.println(error);

                }
            }
            if (!uniqueRollNumbers.contains(rollNo)) {
                uniqueRollNumbers.add(rollNo);
                break;
            }


        }
        new_user.setRollNumber(rollNo);

        Set<String> courses = new HashSet<>();
        int numberofcourses = 0; //choose courses for a student
        String singleCourse; //store a single course at a time
        //every student should choose 4 courses
        System.out.println("Choose 4 courses from " + availableCourses.toString());
        while (numberofcourses != 4) {
            singleCourse = sc.next().toUpperCase();
            //check if a course already choosen or entered course is present in availableCourses or not...!!!
            while (courses.contains(singleCourse) || !availableCourses.contains(singleCourse)) {
                System.out.println("Course is already choosen or not present. Please enter again");
                singleCourse = sc.next().toUpperCase();
            }
            numberofcourses++;

        }
        new_user.setCourses(courses);

        users.add(new_user);
        System.out.println("User added successfully");

    }

    public void displayUser() {
        userlist = new ArrayList<>(users);
        //either in ascending or descending order on the basis of fullname or age or rollnumber or address
        System.out.println("In what order you want to display your data");
        System.out.println("1. Sort in ascending order on basis of Name");
        System.out.println("2. Sort in descending order on basis of Name");
        System.out.println("3. Sort in ascending order on basis of Age");
        System.out.println("4. Sort in descending order on basis of Age");
        System.out.println("5. Sort in ascending order on basis of RollNumber");
        System.out.println("6. Sort in descending order on basis of RollNumber");
        System.out.println("7. Sort in ascending order on basis of Address");
        System.out.println("8. Sort in descending order on basis of Address");
        System.out.println("9. Go back");
        System.out.println("Choose an option from (1,2,3,4,5,6,7,8,9) : ");
        int option;
        while (true) {
            try {
                option = Integer.parseInt(sc.next());
                break;
            } catch (NumberFormatException ex) {
                System.out.println(error);
            }
        }

        switch (option) {
            case 1:
                //generating comparator identifier and already have userlist and using lambda function
                Comparator<User> compareByFullName = (User o1, User o2) -> o1.getFullName().compareTo(o2.getFullName());
                Collections.sort(userlist, compareByFullName);
                break;

            case 2:
                Collections.sort(userlist, compareByFullName.reversed());
                break;

            case 3:
                Comparator<User> compareByAge = (User o1, User o2) -> o1.getAge() - o2.getAge();
                Collections.sort(userlist, compareByAge);
                break;

            case 4:
                Collections.sort(userlist, compareByAge.reversed());
                break;

            case 5:
                Comparator<User> compareByRollNumber = (User o1, User o2) -> o1.getRollNumber() - o2.getRollNumber();
                Collections.sort(userlist, compareByRollNumber);
                break;

            case 6:
                Collections.sort(userlist, compareByRollNumber.reversed());
                break;

            case 7:
                Comparator<User> compareByAddress = (User o1, User o2) -> o1.getAddress().compareTo(o2.getAddress());
                Collections.sort(userlist, compareByAddress);
                break;

            case 8:
                Collections.sort(userlist, compareByAddress.reversed());
                break;

            case 9:
                return;
        }
        //displaying the details in given orders ie -- Name    Roll Number    Age       Address     Courses
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Name\t\tRollNumber\t\tAge\t\tAddress\t\t\t\tCourses");
        System.out.println("------------------------------------------------------------------------");
        for (User user : users) {
            System.out.println(user.getFullName() + "\t\t" + user.getRollNumber() + "\t\t" + user.getAge() + "\t\t" + user.getAddress() + "\t\t"
                    + user.getCourses().toString());
        }
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
                    if (uniqueRollNumbers.contains(rollNo)) { // checking in list that it contains rollno or not
                        //if roll number exist then perform delete operation
                        uniqueRollNumbers.remove(rollNo);
                        int index = findIndex(rollNo); // finding the index of particular user in users to delete
                        users.remove(index);
                        System.out.println("User Deleted Succesfully");
                        break;
                    } else {
                        System.out.println("User Doesn't exit"); // Roll number doesnt exit as roll no not found
                    }
                }
            } catch (NumberFormatException ex) {
                System.out.println(error);

            }

        }
    }

    //returning index of user in userlist by its rollno
    public int findIndex(int rollNo) {
        int index = 0;
        for (User u : users) {
            if (rollNo == u.getRollNumber()) {
                break;
            }
            index++;
        }
        return index;
    }

    public void saveToDisk() {
        // FIle names to store user data
        String userfile = "D:\\users.bin";
        String rollfile = "D:\\rollno.bin";
        try {
            //saving users list
            FileOutputStream file = new FileOutputStream(userfile);
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(users);

//            saving roll number set
            out = new ObjectOutputStream(new FileOutputStream(rollfile));
            out.writeObject(uniqueRollNumbers);
            out.close();
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
        if ("y".equalsIgnoreCase(option)) {
            saveToDisk();
        }
    }
}
}
