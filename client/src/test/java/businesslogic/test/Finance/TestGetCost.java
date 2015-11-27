package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetCost extends TestCase{
	
	 public void testGetCost() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(23.0, finance.searchCost("2015-10-24 00:00:00", "2015-11-01 00:00:00").get(0).getAmount());
		}

}
