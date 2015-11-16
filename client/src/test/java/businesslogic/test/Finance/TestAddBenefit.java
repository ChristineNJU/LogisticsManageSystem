package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestAddBenefit extends TestCase{
	 public void testAddBenefti() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(null, finance.addBenefit(null));
		}

}
