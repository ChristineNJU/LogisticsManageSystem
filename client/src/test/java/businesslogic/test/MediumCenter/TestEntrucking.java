package businesslogic.test.MediumCenter;

import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestEntrucking extends TestCase {
	
	public void testEntrucking() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.transfer(null));
	}
}
