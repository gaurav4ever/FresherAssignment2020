package Assignment2.menu;

import Assignment2.User;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DisplayUser {
    Scanner scan;
    public DisplayUser(){
        scan = new Scanner(System.in);
    }
    public void display(HashMap<String, User> users){
        System.out.println("Choose the field to be sorted\n1.Name\n2.Rool number\n3.Age\n4.Address");
        int ch = scan.nextInt();
        HashMap<String, User> map = new HashMap<>();
        switch(ch){
            case 1:
                for(String key: users.keySet())
                    map.put(users.get(key).getName(), users.get(key));
                break;
            case 2:
                for(String key: users.keySet())
                    map.put(users.get(key).getRoll_number()+"", users.get(key));
                break;
            case 3:
                for(String key: users.keySet())
                    map.put(users.get(key).getAge()+"", users.get(key));
                break;
            case 4:
                for(String key: users.keySet())
                    map.put(users.get(key).getAddress(), users.get(key));
                break;
        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Name\t\tRoll Number\t\tAge\t\tAddress\t\t\tCourses");
        System.out.println("-----------------------------------------------------------------------------------------");
        for(String key: map.keySet().stream().sorted().collect(Collectors.toList())) {
            User user = map.get(key);
            System.out.println(user.getName() + "\t\t" + user.getRoll_number() + "\t\t\t\t" + user.getAge() + "\t\t" + user.getAddress() + "\t\t\t" + user.getCourses());
        }
        System.out.println("-----------------------------------------------------------------------------------------\n\n");
    }

    void displaySorted(HashMap<String, User> users){
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("Name\t\tRoll Number\t\tAge\t\tAddress\t\t\tCourses");
        System.out.println("-----------------------------------------------------------------------------------------");
        for(String key: users.keySet()) {
            User user = users.get(key);
            System.out.println(user.getName() + "\t\t" + user.getRoll_number() + "\t\t\t\t" + user.getAge() + "\t\t" + user.getAddress() + "\t\t\t" + user.getCourses());
        }
        System.out.println("-----------------------------------------------------------------------------------------\n\n");
    }
}
