package businesslogic.test.MediumCenter;

import junit.framework.TestCase;
import businesslogic.Impl.MediumCenter.MediumCenterController;

public class TestGetNeedEntrucking extends TestCase {
	
	public void testGetNeedEntrucking() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.getNeedEntrucking());
	}
}
