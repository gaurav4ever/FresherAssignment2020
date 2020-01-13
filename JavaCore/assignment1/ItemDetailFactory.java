package assignment1;

import assignment1.models.*;

public class ItemDetailFactory {
    public static ItemDetail getItem(String name , String type , Double price , Integer quantity){
        switch (type){
            case ItemType.RAW :
                return new ItemDetail(new RawItem(name, price), quantity);
            case ItemType.IMPORTED :
                return new ItemDetail(new ImportedItem(name, price), quantity);
            case ItemType.MANUFACTURED :
                return new ItemDetail(new ManufacturedItem(name, price), quantity);
            default:
                return null ;
        }
    }
}
