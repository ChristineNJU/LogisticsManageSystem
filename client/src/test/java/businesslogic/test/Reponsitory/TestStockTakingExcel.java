package businesslogic.test.Reponsitory;

import junit.framework.TestCase;
import businesslogic.Impl.Repository.RepositoryController;

public class TestStockTakingExcel extends TestCase {
		
	public void testStockTakingExcel() {
		
		RepositoryController rc = new RepositoryController();
		
		assertEquals(null, rc.stockTakingExcel());
	}
}
