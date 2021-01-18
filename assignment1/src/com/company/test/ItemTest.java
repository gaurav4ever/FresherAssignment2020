package com.company.test;

import com.company.main.Item;
import com.company.main.Details;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    Item item1,item2,item3,item4;
    @Before
    public void init(){
        item1 = new Item("",1000,10, Details.Type.RAW);
        item2 = new Item("Perfume",-800,10, Details.Type.RAW);
        item3 = new Item("Perfume",800,-1, Details.Type.IMPORTED);
        item4 = new Item("Perfume",900,10, Details.Type.IMPORTED);
    }
    @Test
    public void testItem1(){
        assertEquals("Item added successfully",new Details().addItem(item1));
    }
    @Test
    public void testItem2(){
        assertEquals("Item added successfully",new Details().addItem(item2));
    }
    @Test
    public void testItem3(){
        assertEquals("Item added successfully",new Details().addItem(item3));
    }
    @Test
    public void testItem4(){
        assertEquals("Item added successfully",new Details().addItem(item4));
    }
    @Test
    public void testItem5(){
        assertEquals("Please enter a valid name",new Details().addItem(item1));
    }
}
