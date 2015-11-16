package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestStockTaking extends TestCase {
	
	public void testStockTaking() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.stockTaking());
	}
}
