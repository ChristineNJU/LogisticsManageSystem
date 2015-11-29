package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetGatheing extends TestCase{
	
	 public void testGetGathering() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.searchGathering(null, null));
		}

}
