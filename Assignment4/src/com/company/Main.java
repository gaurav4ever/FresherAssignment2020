package com.company;

import java.io.PrintStream;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Details details = new Details();
        System.out.println("//Main function");
        details.start();
    }
}
