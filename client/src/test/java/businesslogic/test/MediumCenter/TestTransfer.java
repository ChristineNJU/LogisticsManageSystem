package businesslogic.test.MediumCenter;

import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestTransfer extends TestCase {
	
	public void testTransfer() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.transfer(null));
	}
}
