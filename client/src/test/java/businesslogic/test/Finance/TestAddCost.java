package businesslogic.test.Finance;

import junit.framework.TestCase;
import State.AddState;
import State.CostType;
import VO.CostVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestAddCost extends TestCase{
	
	 public void testAddCost() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(AddState.SUCCESS, finance.addCost(new CostVO("2015-10-25", 23, "张三", "中国工商银行", 
				CostType.salary, "无")));
		}

}
