package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.AddState;
import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestAddAccount extends TestCase{
	
  public void testAddAccount() {
		
		FinanceController finance = new FinanceController();
		
		assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
	}
	
}
