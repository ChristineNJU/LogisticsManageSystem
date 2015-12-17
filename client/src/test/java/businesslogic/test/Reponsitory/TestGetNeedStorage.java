package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import businesslogic.Impl.Repository.RepositoryController;

public class TestGetNeedStorage extends TestCase {
	
	public void testGetNeedStorage() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals(null, rc.getNeedStorage());
	}
}
