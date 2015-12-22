package businesslogic.test.Reponsitory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.StockTakingPO;
import State.AddState;
import State.DeleteState;
import State.StorageArea;
import VO.StockTakingVO;
import businesslogic.Impl.Repository.RepositoryController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestStockTakingConfirm extends TestCase {
	
	public void testStockTakingConfirm() {
		SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		RepositoryController rc = new RepositoryController();
		ArrayList<StockTakingVO> stock=new ArrayList<StockTakingVO>();
		try {
			stock.add(new StockTakingVO("1000000000", sdf.parse("2015-11-01 00:00:00"), "南京", 
					StorageArea.CAR_TRANSPORTATION, 2, 4, 10));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(AddState.SUCCESS, rc.stockTakingConfirm(stock));
		assertEquals(AddState.FAIL, rc.stockTakingConfirm(stock));
		try {
			DeleteService deleteSto=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS, deleteSto.delete(new StockTakingPO(stock.get(0),"02500")));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
