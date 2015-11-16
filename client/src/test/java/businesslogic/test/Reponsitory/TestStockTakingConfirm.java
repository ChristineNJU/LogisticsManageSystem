package businesslogic.test.Reponsitory;

import businesslogic.Impl.Reponsitory.ReponsitoryController;
import junit.framework.TestCase;

public class TestStockTakingConfirm extends TestCase {
	
	public void testStockTakingConfirm() {
		
		ReponsitoryController rc = new ReponsitoryController();
		
		assertEquals(null, rc.stockTakingConfirm());
	}
}
