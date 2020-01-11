package assignment4;

public class Main {
    public static void main(String args[]){
        try {
            DBConnectionManager.initOperation();
            final Factory factory = new Factory();

            Thread producerThread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    factory.produce();
                }
            });

            Thread consumerThread = new Thread(new Runnable() {
                @Override
                public void run()
                {
                    factory.consume();
                }
            });

            producerThread.start();
            consumerThread.start();
            producerThread.join();
            consumerThread.join();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
