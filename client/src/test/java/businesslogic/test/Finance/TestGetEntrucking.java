package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetEntrucking extends TestCase{
	public void testGetEntrucking() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals("02502015112300000", finance.getEntrucking("2015-10-01 00:00:00", "2015-12-22 00:00:00").get(0).getCarNumber());
	}
}
