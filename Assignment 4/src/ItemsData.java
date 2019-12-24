public class ItemsData implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread from data is runnning");
        DatabaseConnection databaseConnection = new DatabaseConnection();
        try {
            databaseConnection.readItemFromDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
