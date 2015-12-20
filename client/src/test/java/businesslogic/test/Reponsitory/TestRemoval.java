package businesslogic.test.Reponsitory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.RemovalPO;
import State.AddState;
import State.DeleteState;
import State.TransferType;
import VO.RemovalVO;
import businesslogic.Impl.Repository.RepositoryController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestRemoval extends TestCase {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	
	public void testRemoval() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<RemovalVO> removal=new ArrayList<RemovalVO>();
		try {
			removal.add(new RemovalVO("1000000000", sdf.parse("2015-11-01 00:00:00"), "南京", TransferType.AIR,
					"0250012015102500001"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(AddState.SUCCESS, rc.addRemoval(removal));
		assertEquals(AddState.FAIL, rc.addRemoval(removal));
		try {
			DeleteService deleteRe=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteRe.delete(new RemovalPO(removal.get(0),"02500")));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
