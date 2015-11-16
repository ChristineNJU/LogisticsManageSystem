package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestDeleteAccount extends TestCase{
	 public void testDeleteAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.deleteAccount(null));
		}
}
