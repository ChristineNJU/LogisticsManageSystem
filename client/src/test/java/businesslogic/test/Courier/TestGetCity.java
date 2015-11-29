package businesslogic.test.Courier;

import junit.framework.TestCase;
import businesslogic.Impl.Courier.CourierController;

public class TestGetCity extends TestCase {
	
	public void testGetCity() {
		
		CourierController courier = new CourierController();
		
		assertEquals(null, courier.getCity());
	}
}
