package businesslogic.test.BusinessLobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.ArrivalPO;
import State.AddState;
import State.DeleteState;
import State.LogisticsState;
import VO.ArrivalVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestArrival extends TestCase {

	/**
	 * need System log
	 */
	public void testArrival(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time="2015-11-26 11:06:06";
		
		try {
			ArrivalVO arrival=new ArrivalVO("1234567891", sdf.parse(time), "025000", "南京", LogisticsState.INTACT);
			ArrayList<ArrivalVO> arrivalList=new ArrayList<ArrivalVO>();
			arrivalList.add(arrival);
			assertEquals(AddState.SUCCESS,businessLobbyController.arrival(arrivalList));
			assertEquals(AddState.FAIL,businessLobbyController.arrival(arrivalList));
			DeleteService deleteAccount=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteAccount.delete(new ArrivalPO(arrival,"0250")));
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
