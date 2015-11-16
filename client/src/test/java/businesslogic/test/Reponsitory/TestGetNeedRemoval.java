package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestGetNeedRemoval extends TestCase {
	
	public void testGetNeedRemoval() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.getNeedRemoval());
	}
}
