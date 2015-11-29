package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.DeleteState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestDeleteAccount extends TestCase{
	 public void testDeleteAccount() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",10)));
		}
}
