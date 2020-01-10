
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class createItemsTest {
    Item it1,it2,it3,it4,it5;

    @Before
    public void init(){
        it1 = new Item("",Type.RAW,100,100,0);
        it2 = new Item("qwerty",Type.RAW,-100,100,0);
        it3 = new Item("qwerty",Type.RAW,100,-100,0);
        it4 = new Item("qwerty",Type.RAW,100,100,0);

    }

    @Test
    public void checkItem1()
    {
        assertEquals("No name entered",new createItems().addItem(it1));

    }
    @Test
    public void checkItem2()
    {
        assertEquals("item added succesfully",new createItems().addItem(it2));

    }
    @Test
    public void checkItem3()
    {

        assertEquals("item added successfully",new createItems().addItem(it3));

    }
    @Test
    public void checkItem4()
    {

        assertEquals("item added successfully",new createItems().addItem(it4));

    }

}