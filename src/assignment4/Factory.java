package assignment4;

import java.util.LinkedList;
import java.util.List;
import assignment1.models.Item;
import assignment4.Exceptions.AllRecordsFetchException;

public class Factory extends Thread {
    List<Item> list;
    public static final int capacity = 2;
    boolean allProduced = false;

    public Factory(){
        list = new LinkedList<Item>();
    }

    public void produce() {
        try {
            while (allProduced == false) {
                synchronized (this) {
                    while (list.size() == capacity)
                        wait();
                    Item item = DBConnectionManager.getNextItem();
                    System.out.println("produced Item : " + item.name);
                    list.add(item);
                    notify();
                }
            }
        } catch (AllRecordsFetchException e) {
            allProduced = true;
        }catch (Exception e){
                e.printStackTrace();
        }
    }
    public void consume() {
        try {
            while (allProduced == false || list.size() > 0) {
                synchronized (this) {
                    while (list.size() == 0)
                        wait();
                    System.out.println("consumed Item : " + list.remove(0));
                    notify();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

