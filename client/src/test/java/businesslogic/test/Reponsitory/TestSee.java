package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import businesslogic.Impl.Repository.RepositoryController;

public class TestSee extends TestCase {
	
	public void testSee() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals("南京", rc.seeRemoval("2015-2-2 00:00:00", "2015-11-11 00:00:00").get(0).getDestination());
		
		
	}
}
