package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.AddState;
import VO.BenefitVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestAddBenefit extends TestCase{
	 public void testAddBenefti() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(AddState.SUCCESS, finance.addBenefit(new BenefitVO(1294324, 492304,"2015-11-26 10:20:20","2015-11-26 10:20:30")));
		}

}
