package businesslogic.test.MediumCenter;

import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestArrival extends TestCase {
	
	public void testArrival() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.arrival(null));
	}
}
