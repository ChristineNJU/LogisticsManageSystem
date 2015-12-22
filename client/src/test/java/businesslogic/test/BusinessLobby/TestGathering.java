package businesslogic.test.BusinessLobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.GatheringPO;
import State.AddState;
import State.DeleteState;
import VO.AccountVO;
import VO.GatheringVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.Impl.Finance.FinanceController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestGathering extends TestCase {

	public void testGathering (){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			FinanceController finance = new FinanceController();
			
			assertEquals(AddState.SUCCESS, finance.addAccount(new AccountVO("中国银行", 1412414.23)));
			
			GatheringVO gathering=new GatheringVO(sdf.parse("2015-11-27 10:41:31"),210,"张斯,",barCodeList);
			assertEquals(AddState.SUCCESS,businessLobbyController.gathering(gathering));
			assertEquals(AddState.FAIL,businessLobbyController.gathering(gathering));
			DeleteService deleteGa=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteGa.delete(new GatheringPO(gathering,"025000")));
			
			assertEquals(DeleteState.SUCCESS, finance.deleteAccount(new AccountVO("中国银行",1412414.23+210)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
