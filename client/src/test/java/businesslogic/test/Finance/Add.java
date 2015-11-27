package businesslogic.test.Finance;

import VO.AccountVO;
import businesslogic.Impl.Finance.FinanceController;

public class Add {
	public static void main(String[] args){
	FinanceController finance = new FinanceController();
		
		finance.updateAccount(new AccountVO("中国银行", 10));
		
	}
}
