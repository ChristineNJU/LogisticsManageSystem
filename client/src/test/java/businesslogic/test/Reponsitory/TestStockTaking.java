package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import State.StorageArea;
import State.StorageState;
import businesslogic.Impl.Repository.RepositoryController;

public class TestStockTaking extends TestCase {
	
	public void testStockTaking() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals(StorageArea.AIR_TRANSPORTATION, rc.getStockTaking().get(0).getAreaCode());
	}
}
