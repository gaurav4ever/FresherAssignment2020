package com.company.main.file_operations;

import static com.company.main.Main.scan;

public class SaveChanges {
    public void start(){
        System.out.println("Save changes done? y/n : ");
        String acceptChanges = scan.next();
        if(acceptChanges.equals("y"))
        {
            new WriteToFile().start();
            System.out.println("Changes saved to file");
        }
    }
}
