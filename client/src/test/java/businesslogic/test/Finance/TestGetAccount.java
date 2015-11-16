package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetAccount extends TestCase{
	 public void testGetAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.searchAccount(null));
		}
}
