package businesslogic.test.BusinessLobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.DeliveryPO;
import State.AddState;
import State.DeleteState;
import VO.DeliveryVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestDelivery extends TestCase {
	/**
	 * need System log
	 */
	public void testDelivery(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			DeliveryVO delivery=new DeliveryVO(sdf.parse("2015-11-27 11:22:22"), barCodeList, "苏蛋紫");
			
			assertEquals(AddState.SUCCESS,businessLobbyController.delivery(delivery));
			assertEquals(AddState.FAIL,businessLobbyController.delivery(delivery));
			DeleteService deleteDe=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteDe.delete(new DeliveryPO(delivery,"025000")));
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

