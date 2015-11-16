package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestAddCost extends TestCase{
	
	 public void testAddCost() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.addCost(null));
		}

}
