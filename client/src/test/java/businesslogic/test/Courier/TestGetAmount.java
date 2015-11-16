package businesslogic.test.Courier;

import businesslogic.Impl.Courier.CourierController;
import businesslogic.State.LogisticsType;
import businesslogic.State.PackingCharge;
import junit.framework.TestCase;

public class TestGetAmount extends TestCase {
	
	public void testGetAmount() {
		
		CourierController courier = new CourierController();
		
		assertEquals(null, courier.getAmount("nj", "ef", LogisticsType.ECONOMIC, PackingCharge.COURISE_BAG, 68, 9));
	}
}
