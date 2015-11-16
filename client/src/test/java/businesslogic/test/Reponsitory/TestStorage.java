package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestStorage extends TestCase {
	
	public void testStorage() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.storage(null));
	}
}
