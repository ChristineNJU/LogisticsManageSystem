package businesslogic.test.BusinessLobby;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.EntruckingPO;
import State.AddState;
import State.DeleteState;
import VO.EntruckingVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestEntrucking extends TestCase {
	/**
	 * need System log
	 */
	public void testEntrucking(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd hh-mm-ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			EntruckingVO entrucking=new EntruckingVO(sdf.parse("2015-11-27 10:34:23"), "02502015112300000","南京", "苏A 12345", "张斯栋", "张斯栋",barCodeList ,12);
			assertEquals(AddState.SUCCESS,businessLobbyController.entrucking(entrucking));
			assertEquals(AddState.FAIL,businessLobbyController.entrucking(entrucking));
			DeleteService deleteEn=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteEn.delete(new EntruckingPO(entrucking,"025000")));
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
