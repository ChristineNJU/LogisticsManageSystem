package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.DeleteState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestDeleteAccount extends TestCase{
	 public void testDeleteAccount() {
			
			FinanceController finance = new FinanceController();
			finance.addAccount(new AccountVO("中国银行",10));
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",10)));
			assertEquals(DeleteState.FAIL, finance.deleteAccount(new AccountVO("中国银行",10)));
		}
}
