package businesslogic.test.Finance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import PO.CostPO;
import State.AddState;
import State.CostType;
import State.DeleteState;
import VO.AccountVO;
import VO.CostVO;
import businesslogic.Impl.Finance.FinanceController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestAddCost extends TestCase{
	
	 public void testAddCost() {
			
			FinanceController finance = new FinanceController();
			assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
			CostVO cost=new CostVO("2015-10-25 00:00:00", 23, "张三", "中国工商银行", 
					CostType.salary, "无");
			
			assertEquals(AddState.SUCCESS, finance.addCost(cost));
//			assertEquals(AddState.FAIL, finance.addCost(new CostVO("2015-10-25 00:00:00", 23, "张三", "中国工商银行", 
//					CostType.salary, "无")));
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",1412414.23-23)));
			
			
			try {
				DeleteService deleteCo = (DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
				assertEquals(DeleteState.SUCCESS, deleteCo.delete(new CostPO(cost)));		
			} catch (MalformedURLException | RemoteException
					| NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}

}
