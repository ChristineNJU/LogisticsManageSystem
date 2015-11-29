package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetTransfer extends TestCase{

public void testGetTranfer() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getTransfer(null, null));
	}
	
}
