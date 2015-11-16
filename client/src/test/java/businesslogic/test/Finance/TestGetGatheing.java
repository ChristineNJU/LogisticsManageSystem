package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetGatheing extends TestCase{
	
	 public void testGetGathering() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.searchGathering(null, null));
		}

}
