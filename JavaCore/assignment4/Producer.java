package assignment4;

import assignment1.models.ItemDetail;

import java.sql.Connection;
import java.util.List;

public class Producer implements Runnable  {
    final List<ItemDetail> list ;

    public Producer(List<ItemDetail> list) {
        this.list = list;
    }

    @Override
    public void run() {
        synchronized (list){
            list.addAll(new ItemDAO().getItems()) ;
        }
    }
}
