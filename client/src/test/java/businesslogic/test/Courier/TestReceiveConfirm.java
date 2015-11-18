package businesslogic.test.Courier;

import junit.framework.TestCase;
import State.UpdateState;
import businesslogic.Impl.Courier.CourierController;

public class TestReceiveConfirm extends TestCase {
	
	public void testReceiveConfirm() {
		
		CourierController courier = new CourierController();
		
		assertEquals(UpdateState.NOTFOUND, courier.receiveConfirm(null, "sender", "hy"));
	}
}
