package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetLog extends TestCase{
	
public void testGetLog() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getLog(null, null));
	}
	
}
