package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetEntrucking extends TestCase{
	public void testGetEntrucking() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.getEntrucking(null, null));
	}
}
