package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestAddAccount extends TestCase{
	
  public void testAddAccount() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(null, finance.addAccount(null));
	}
	
}
