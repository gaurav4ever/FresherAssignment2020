package assignment2;

import java.util.TreeMap;

import assignment2.comparator.*;
import assignment2.models.User;

import java.io.*;

public class UsersDetails implements Serializable{
    int size;
    TreeMap<String, User> rollnoToUserMap;

    public UsersDetails(){
        rollnoToUserMap = new TreeMap<String,User>();
        size = 0;
    }

    public boolean addUser(User user)throws Exception{
        if(rollnoToUserMap.containsKey(user.rollno)){
            throw new Exception("roll no already exists");
        }
        size++;
        rollnoToUserMap.put(user.rollno, user);
        return true;
    }

    public User getUser(String rollno)throws Exception{
        if(rollnoToUserMap.containsKey(rollno)){
            throw new Exception("roll no not exists");
        }
        return rollnoToUserMap.get(rollno);
    }

    public void displayAllUserSortedByNameAsc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByNameAsc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByNameDesc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByNameDesc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByRollnoAsc(){
        rollnoToUserMap.values().forEach(System.out::println);
    }
    public void displayAllUserSortedByRollnoDesc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByRollnoDesc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByAddressAsc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByAddressAsc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByAddressDesc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByAddressDesc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByAgeAsc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByAgeAsc())
                .forEach(System.out::println);
    }
    public void displayAllUserSortedByAgeDesc(){
        rollnoToUserMap.values().stream()
                .sorted(new UserComparatorByAgeDesc())
                .forEach(System.out::println);
    }

    public boolean deleteUser(String rollno)throws Exception{
        if(!rollnoToUserMap.containsKey(rollno)){
            throw new Exception("user with rollno "+ rollno + " does not exists");
        }
        rollnoToUserMap.remove(rollno);
        --size;
        return true;
    }

}