package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import businesslogic.Impl.Repository.RepositoryController;

public class TestAlarm extends TestCase {
	
	public void testAlarm() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals(null, rc.alarm());
	}
}
