package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestUpdateAccount extends TestCase{
	 public void testUpdateAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(UpdateState.SUCCESS, finance.updateAccount(new AccountVO("中国银行", 100000)));
		}
}
