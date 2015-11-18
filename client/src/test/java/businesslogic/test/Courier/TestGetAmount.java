package businesslogic.test.Courier;

import State.LogisticsType;
import State.PackingCharge;
import businesslogic.Impl.Courier.CourierController;
import junit.framework.TestCase;

public class TestGetAmount extends TestCase {
	
	public void testGetAmount() {
		
		CourierController courier = new CourierController();
		
		assertEquals(null, courier.getAmount("nj", "ef", LogisticsType.ECONOMIC, PackingCharge.COURISE_BAG, 68, 9));
	}
}
