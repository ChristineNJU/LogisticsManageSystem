package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestAlarm extends TestCase {
	
	public void testAlarm() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.alarm());
	}
}
