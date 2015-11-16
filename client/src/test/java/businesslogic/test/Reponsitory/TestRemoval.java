package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestRemoval extends TestCase {
	
	public void testRemoval() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.removal(null));
	}
}
