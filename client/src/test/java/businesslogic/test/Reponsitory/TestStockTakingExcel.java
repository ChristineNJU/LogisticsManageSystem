package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestStockTakingExcel extends TestCase {
		
	public void testStockTakingExcel() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.stockTakingExcel());
	}
}
