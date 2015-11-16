package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetCost extends TestCase{
	
	 public void testGetCost() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.searchCost(null, null));
		}

}
