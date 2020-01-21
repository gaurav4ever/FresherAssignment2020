package com.company;

import java.io.IOException;

public class InputChecker {

        public boolean checkName(String name) {
            if (!Character.isAlphabetic(name.charAt(0)))
            {
                System.out.println("Invalid name. Please Re-enter");
                return true;
            }
            return false;
        }

        public boolean checkAge(String age) {
            if (!age.matches("[0-9]*"))
            {
                System.out.println("Invalid Age. Please Re-enter");
                return true;
            }
            return false;
        }

        public boolean checkRollNumber(String roll) {
        if (!roll.matches("[0-9]*"))
        {
            System.out.println("Invalid Roll Number. Please Re-enter");
            return true;
        }
        return false;
    }

        public boolean checkAddress(String address) {
        if (!Character.isAlphabetic(address.charAt(0)))
        {
            System.out.println("Invalid Address. Please Re-enter");
            return true;
        }
        return false;
    }

        public boolean checkCourses(String course) {
            if (!course.matches("A|B|C|D|E"))
            {
                System.out.println("Invalid Course Name. Please Re-enter");
                return true;
            }
            return false;
        }


    }

