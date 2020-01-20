import Services.Operations;


class Main{
    public static void main(String [] args) {
        Operations op = new Operations();

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                // database operation
                try{
                    op.databaseOperation();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                //tax Operations
                try{
                    op.taxOperation();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
            op.displayItem();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}