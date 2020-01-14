package assignment4;

import assignment1.models.ItemDetail;

import java.util.List;
import java.util.Random;

public class Consumer implements  Runnable{
    final List<ItemDetail> list ;

    public Consumer(List<ItemDetail> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){
                if(list.size()>0){
                    list.remove(0).display(); ;
                }
            }
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
