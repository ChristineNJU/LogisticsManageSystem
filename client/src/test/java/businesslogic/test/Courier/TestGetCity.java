package businesslogic.test.Courier;

import businesslogic.Impl.Courier.CourierController;
import junit.framework.TestCase;

public class TestGetCity extends TestCase {
	
	public void testGetCity() {
		
		CourierController courier = new CourierController();
		
		assertEquals(null, courier.getCity());
	}
}
