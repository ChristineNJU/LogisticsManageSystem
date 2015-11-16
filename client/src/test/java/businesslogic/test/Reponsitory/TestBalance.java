package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestBalance extends TestCase {
	
	public void testBalance() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.balance());
	}
}
