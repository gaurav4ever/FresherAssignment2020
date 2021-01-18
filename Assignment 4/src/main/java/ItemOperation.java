import java.util.ArrayList;
import java.util.List;

public class ItemOperation {
    public static List<Item> items;
    public static boolean lock;
    public static boolean completed;
    public enum Type{
        RAW,
        IMPORTED,
        MANUFACTURED
    }

    ItemOperation(){
        items = new ArrayList<>();
        lock = false;
        completed = false;
    }

    void start(){
        new Thread(() -> new Database().getItem()).start();
        new Thread(() -> new TaxCalculator().calculate()).start();
    }
}
