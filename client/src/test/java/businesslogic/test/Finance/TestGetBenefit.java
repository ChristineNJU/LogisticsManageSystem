package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetBenefit extends TestCase{
	 public void testGetBenefit() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(1294324.0, finance.searchBenefit("2015-11-26 10:30:00").getIncome());
		}
}
