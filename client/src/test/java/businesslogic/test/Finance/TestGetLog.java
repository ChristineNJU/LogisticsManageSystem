package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetLog extends TestCase{
	
public void testGetLog() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getLog(null, null));
	}
	
}
