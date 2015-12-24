package businesslogic.test.Reponsitory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import PO.BalancePO;
import State.AddState;
import State.DeleteState;
import State.StorageArea;
import VO.BalanceVO;
import businesslogic.Impl.Repository.RepositoryController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestBalance extends TestCase {
	
	public void testBalance() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<BalanceVO> balance=new ArrayList<BalanceVO>();
		balance.add(new BalanceVO("1000000000", new Date(), "南京", StorageArea.RAILWAY_TRANSPORTATION,
				2, 2, 10, StorageArea.MANOEUVERING_AREA, 2, 3, 2));
		assertEquals(AddState.SUCCESS, rc.addBalance(balance));
		assertEquals(AddState.FAIL, rc.addBalance(balance));
		try {
			DeleteService deleteBa=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS, deleteBa.delete(new BalancePO(balance.get(0),"02500")));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
