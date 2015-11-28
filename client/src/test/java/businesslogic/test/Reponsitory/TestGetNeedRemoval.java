package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import businesslogic.Impl.Repository.RepositoryController;

public class TestGetNeedRemoval extends TestCase {
	
	public void testGetNeedRemoval() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals(null, rc.getNeedRemoval(null));
	}
}
