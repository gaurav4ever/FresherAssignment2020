package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> arraylist = new ArrayList<Student>();
        arraylist.add(new Student("sh", 21, 26));
        arraylist.add(new Student("ks", 22, 24));
        arraylist.add(new Student("gs", 23, 32));

        Collections.sort(arraylist);

        for(Student str: arraylist){
            System.out.println(str);
        }


    }

}
