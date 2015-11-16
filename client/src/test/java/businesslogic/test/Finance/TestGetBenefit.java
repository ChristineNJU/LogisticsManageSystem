package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetBenefit extends TestCase{
	 public void testGetBenefit() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.searchBenefit(null));
		}
}
