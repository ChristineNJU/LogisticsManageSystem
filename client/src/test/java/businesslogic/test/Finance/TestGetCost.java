package businesslogic.test.Finance;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;
import junit.framework.TestCase;
import PO.CostPO;
import State.AddState;
import State.CostType;
import State.DeleteState;
import VO.AccountVO;
import VO.CostVO;
import businesslogic.Impl.Finance.FinanceController;

public class TestGetCost extends TestCase{
	
	 public void testGetCost() {
			
			FinanceController finance = new FinanceController();
			
			assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
			CostVO cost=new CostVO("2015-10-25 00:00:00", 23, "张三", "中国工商银行", 
					CostType.salary, "无");
			
			assertEquals(AddState.SUCCESS, finance.addCost(cost));
			
			assertEquals(23.0, finance.searchCost("2015-10-24 00:00:00", "2015-11-01 00:00:00").get(0).getAmount());
			
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",1412414.23-23)));
			try {
				DeleteService deleteCo = (DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
				assertEquals(DeleteState.SUCCESS, deleteCo.delete(new CostPO(cost)));		
			} catch (MalformedURLException | RemoteException
					| NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertEquals(null, finance.searchCost("2015-10-01 00:00:00", "2015-10-24 00:00:00").get(0));
		}

}
