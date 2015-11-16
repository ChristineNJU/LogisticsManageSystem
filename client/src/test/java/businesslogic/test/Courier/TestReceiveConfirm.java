package businesslogic.test.Courier;

import data.State.UpdateState;
import junit.framework.TestCase;
import businesslogic.Impl.Courier.CourierController;

public class TestReceiveConfirm extends TestCase {
	
	public void testReceiveConfirm() {
		
		CourierController courier = new CourierController();
		
		assertEquals(UpdateState.FAIL, courier.receiveConfirm(null, "sender", "hy"));
	}
}
