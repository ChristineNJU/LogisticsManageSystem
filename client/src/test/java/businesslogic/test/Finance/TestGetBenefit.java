package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetBenefit extends TestCase{
	 public void testGetBenefit() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(1294324, finance.searchBenefit("2015-11-26 10:30:00").getCost());
		}
}
