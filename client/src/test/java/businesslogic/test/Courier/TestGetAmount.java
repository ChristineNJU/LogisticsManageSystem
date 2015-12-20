package businesslogic.test.Courier;

import junit.framework.TestCase;
import State.LogisticsType;
import State.PackingCharge;
import businesslogic.Impl.Courier.CourierController;

public class TestGetAmount extends TestCase {
	
	public void testGetAmount() {
		
		CourierController courier = new CourierController();
		
		System.out.println(courier.getAmount("南京", "北京", LogisticsType.ECONOMIC, PackingCharge.COURISE_BAG, 100, 9));
	}
}
