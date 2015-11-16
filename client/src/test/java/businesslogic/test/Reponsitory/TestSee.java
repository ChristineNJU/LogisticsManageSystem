package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestSee extends TestCase {
	
	public void testSee() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.see("2015-2-2", "2015-11-11"));
	}
}
