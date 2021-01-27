package test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import question1.*;

class homeTest {

	@Test
	void testAssign() {
		item item1;
		String [] args = new String[]{"-name" , "Nokia" , "-type" , "raw" , "-price" , "13456" , "-quant" , "2"} ;
		item item[]= new item[2];
		home homeobject = new home();
		item1 = homeobject.Assign(item, args, 0);
		
		assertNotNull(item1,"The Object is created with Null Value");
		assertNotNull(item1.getName(),"Name is Required");
		assertNotNull(item1.getType(),"Type is Required");
		assertEquals(item.class, item1.getClass(),"The object created doesn't belong to required class");
		assertEquals(item1.getName(),"Nokia");
		assertEquals(item1.getQuantity(),2);
		assertEquals(item1.getPrice(),13456);
		assertEquals(item1.getType(),"raw","The Type don't match");
	}
}
