package businesslogic.test.MediumCenter;

import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestGetNeedTransfer extends TestCase {
	
	public void testGetNeedTransfer() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		assertEquals(null, mcc.getNeedEntrucking());
	}
}
