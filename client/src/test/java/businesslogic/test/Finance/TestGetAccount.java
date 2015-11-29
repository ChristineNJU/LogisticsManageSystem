package businesslogic.test.Finance;

import junit.framework.TestCase;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetAccount extends TestCase{
	 public void testGetAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(1412414.23, finance.searchAccount("中国银行").get(0).getMoney());
		}
}
