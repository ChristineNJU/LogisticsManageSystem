package businesslogic.test.Reponsitory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;
import PO.StoragePO;
import State.DeleteState;
import State.StorageArea;
import State.StorageState;
import VO.StorageVO;
import businesslogic.Impl.Repository.RepositoryController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestStorage extends TestCase {
	
	public void testStorage() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<StorageVO> storage=new ArrayList<StorageVO>();
		storage.add(new StorageVO("1000000000", new Date(), "南京", StorageArea.CAR_TRANSPORTATION,
				2, 4, 5));
		assertEquals(StorageState.SUCCESS, rc.storage(storage));
		assertEquals(StorageState.FAIL, rc.storage(storage));
		
		try {
			DeleteService deleteSto=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteSto.delete(new StoragePO(storage.get(0),"02500")));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
