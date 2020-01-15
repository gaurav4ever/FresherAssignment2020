package Question4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Testing {
	
	@Test
	public void testConnection(){
		assertEquals(null, ConnectionSetting.isConnected());

	}
}
