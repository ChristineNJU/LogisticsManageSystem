package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetAccount extends TestCase{
	 public void testGetAccount() {
			
			FinanceController finance = new FinanceController();
			assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
			assertEquals(1412414.23, finance.searchAccount("中国银行").get(0).getMoney());
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",1412414.23)));
			assertEquals(null, finance.searchAccount("中国银行"));
		}
}
