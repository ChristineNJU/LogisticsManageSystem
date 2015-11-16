package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetTransfer extends TestCase{

public void testGetTranfer() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getTransfer(null, null));
	}
	
}
