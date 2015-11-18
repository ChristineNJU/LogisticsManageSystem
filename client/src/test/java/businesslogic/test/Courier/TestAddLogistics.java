package businesslogic.test.Courier;

import State.AddState;
import businesslogic.Impl.Courier.CourierController;
import junit.framework.TestCase;

public class TestAddLogistics extends TestCase {
	
	public void testAddLogistics() {
		
		CourierController courier = new CourierController();
		
		assertEquals(AddState.FAIL, courier.addLogistics(null));
	}
}
