package Assignment_2;

import java.util.Scanner;
import Assignment_2.models.UserInfo;
import Assignment_2.services.UserServices;


class Menu{
    static Scanner sc = new Scanner(System.in);
    UserServices users = new UserServices();

    // AddUser
    void addUser() throws Exception {
        UserInfo user = new UserInfo();

        System.out.print("Enter Full Name : ");
        String newName = sc.nextLine();
        user.setName(newName);

        System.out.print("Enter Age : ");
        int newAge = sc.nextInt();
        sc.nextLine();
        user.setAge(newAge);

        System.out.print("Enter Address : ");
        String newAddress = sc.nextLine();
        user.setAddress(newAddress);

        System.out.print("Enter Roll Number : ");
        int newRollNumber = sc.nextInt();
        sc.nextLine();
        user.setRollNumber(newRollNumber);

        String[] newCourses = new String[4];
        String[] temp = { "A", "B", "C", "D", "E", "F" };
        int counter = 0;
        System.out.println("Select Cources : ");
        for (int i = 0; i < 6; i++) {
            System.out.print("Select " + temp[i] + " : (y/n) ");
            String check = sc.nextLine();
            if (check.equals("y") || check.equals("Y")) {
                newCourses[counter] = temp[i];
                counter++;
            } else if (!check.equals("n") && !check.equals("N")) {
                System.out.println("Invalid Input.");
                i--;
                continue;
            }
            if (counter == 4) {
                break;
            }
        }
        if (counter != 4) {
            throw new Exception("Selecting 4 courses is compulsary.");
        }
        user.setCourses(newCourses);

        users.addUser(user);
    }

    // DisplayUser
    void displayUser() {
        while(true){
            System.out.println("Sort data based on 'Name'/ 'Roll Number' / 'Age' / 'Address'? ");
            String param = sc.nextLine();
            System.out.println("Type 'a' for ascending order and 'b' for descending order. ");
            String order = sc.nextLine();
            if((!param.equals("Name") && !param.equals("Roll Number") && !param.equals("Age") && !param.equals("Address")) || (!order.equals("a") && !order.equals("b"))){
                System.out.println("Invalid input.");
                System.out.println("Back to Menu? (y/n )");
                String back = sc.nextLine();
                if(back.equals("y") || back.equals("Y")){
                    break;
                }
                continue;
            }
            users.displayUser(param, order);

        }
    }

    // DeleteUser
    void deleteUser() throws Exception{
        System.out.print("Enter the Roll Number : ");
        int rollNumber = sc.nextInt();
        sc.nextLine();
        try{
            System.out.println(users.deleteUser(rollNumber));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    // SaveUsers
    void saveUsers() {
        users.serialization();
    }

    // Exit
    void exitmenu() {
        System.out.println("Save User Details : (y/n) ");
        String saver = sc.nextLine();
        if(saver.equals("y") || saver.equals("Y")){
            users.serialization();
        }
    }

    public static void main(String[] args) throws Exception{
        Menu menuObj = new Menu();
        int option = 0;

        while (true) {
            System.out.println("Select an option : ");
            System.out.println("1. Add User Details.");
            System.out.println("2. Display User Details.");
            System.out.println("3. Delete User Details.");
            System.out.println("4. Save User Details.");
            System.out.println("5. Exit.");

            option = sc.nextInt();
            sc.nextLine();
            switch(option){
                case(1):
                    menuObj.addUser();
                    continue;
                case(2):
                    menuObj.displayUser();
                    continue;
                case(3):
                    menuObj.deleteUser();
                    continue;
                case(4):
                    menuObj.saveUsers();
                    continue;
                case(5):
                    menuObj.exitmenu();
                    return;
                default:
                    System.out.println("Invalid Input.");
                    continue;
            }
        }

    }
}
