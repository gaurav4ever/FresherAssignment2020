public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {

        connectionClass conn = new connectionClass();
        Operations operate = new Operations();
        conn.create();


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    conn.insert("asd",34,34,"manufactured");
                    operate.select();

                } catch (InterruptedException e) {
                    System.out.println("Exception while Reading from database");
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    operate.CalculateTaxAndUpdatePrice();
                } catch (InterruptedException e) {
                    System.out.println("Exception while Reading from database");
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Item\tPrice\tTax\tFinal Price");

        for(Items i1: operate.finalPricedItems)
        {
            System.out.println(i1.getName() + "\t" + i1.getPrice()+ "\t" + i1.getTax() + "\t" + i1.getFinalPrice());

        }

    }
}