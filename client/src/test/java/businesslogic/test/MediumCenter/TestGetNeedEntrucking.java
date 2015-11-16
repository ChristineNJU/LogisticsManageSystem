package businesslogic.test.MediumCenter;

import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestGetNeedEntrucking extends TestCase {
	
	public void testGetNeedEntrucking() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.getNeedEntrucking());
	}
}
