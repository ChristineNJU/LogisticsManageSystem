package businesslogic.test.MediumCenter;

import junit.framework.TestCase;
import businesslogic.Impl.MediumCenter.MediumCenterController;

public class TestGetNeedTransfer extends TestCase {
	
	public void testGetNeedTransfer() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.getNeedEntrucking());
	}
}
