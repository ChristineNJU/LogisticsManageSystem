package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetEntrucking extends TestCase{
	public void testGetEntrucking() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getEntrucking("2015-10-01 00:00:00", "2015-11-01 00:00:00"));
	}
}
