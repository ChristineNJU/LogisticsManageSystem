package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestGetNeedStorage extends TestCase {
	
	public void testGetNeedStorage() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.getNeedStorage());
	}
}
