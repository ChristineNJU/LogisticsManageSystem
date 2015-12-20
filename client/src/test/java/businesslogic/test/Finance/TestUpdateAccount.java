package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestUpdateAccount extends TestCase{
	 public void testUpdateAccount() {
			
			FinanceController finance = new FinanceController();
			assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
			assertEquals(UpdateState.SUCCESS, finance.updateAccount(new AccountVO("中国银行", 100000)));
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",100000)));
			assertEquals(UpdateState.NOTFOUND, finance.updateAccount(new AccountVO("中国银行", 100000)));
		}
}
