package businesslogic.test.Courier;

import State.LogisticsType;
import State.PackingCharge;
import businesslogic.Impl.Courier.CourierController;
import junit.framework.TestCase;

public class TestGetAmount extends TestCase {
	
	public void testGetAmount() {
		
		CourierController courier = new CourierController();
		
		assertEquals(null, courier.getAmount("南京", "北京", LogisticsType.ECONOMIC, PackingCharge.COURISE_BAG, 100, 9));
	}
}
