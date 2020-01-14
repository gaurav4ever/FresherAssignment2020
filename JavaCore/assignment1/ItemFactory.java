package assignment1;

import assignment1.ItemType;
import assignment1.models.*;

public class ItemFactory {
    public static Item getItem(String name , String type , Double price){
        switch (type){
            case ItemType.RAW :
                return new RawItem(name, price) ;
            case ItemType.IMPORTED :
                return new ImportedItem(name, price);
            case ItemType.MANUFACTURED :
                return new ManufacturedItem(name, price);
            default:
                return null ;
        }
    }
}
