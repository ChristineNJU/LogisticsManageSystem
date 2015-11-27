package businesslogic.test.Finance;

import businesslogic.Impl.Finance.FinanceController;
import junit.framework.TestCase;

public class TestGetAccount extends TestCase{
	 public void testGetAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(1412414.23, finance.searchAccount("中国银行").get(0).getMoney());
		}
}
