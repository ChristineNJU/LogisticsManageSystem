package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestUpdateAccount extends TestCase{
	 public void testUpdateAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.updateAccount(null, null, null));
		}
}
