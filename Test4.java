package Assignment4;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Test4 {
	
	@Test
	public void testConnection(){
		assertEquals(null, ConnectionConfiguration.isConnected());

	}
}
