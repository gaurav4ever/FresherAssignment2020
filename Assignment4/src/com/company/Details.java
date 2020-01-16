package com.company;

import java.util.ArrayList;
import java.util.List;

public class Details {
    public static List<Item> items;
    public static boolean lock;
    public static boolean completed;
    public enum Type{
        RAW,
        IMPORTED,
        MANUFACTURED;
    }

    Details(){
        items = new ArrayList<>();
        lock = false;
        completed = false;
    }

    void start(){
        System.out.println("Details - start()");
        new Thread(() -> new Database().getItem()).start();
        new Thread(() -> new TaxCalculator().calculate()).start();
    }
}
