package businesslogic.test.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;
import junit.framework.TestCase;
import PO.EntruckingPO;
import State.AddState;
import State.DeleteState;
import VO.EntruckingVO;
import businesslogic.Impl.MediumCenter.MediumCenterController;

public class TestEntrucking extends TestCase {
	/**
	 * need system log
	 */
	public void testEntrucking() {
		
		MediumCenterController mcc = new MediumCenterController();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			EntruckingVO entrucking=new EntruckingVO(sdf.parse("2015-11-27 10:34:23"), "02502015112300000","南京", "苏A 12345", "张斯栋", "张斯栋",barCodeList ,12);
			assertEquals(AddState.SUCCESS,mcc.entrucking(entrucking));
			assertEquals(AddState.FAIL,mcc.entrucking(entrucking));
			DeleteService deleteEn=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteEn.delete(new EntruckingPO(entrucking,"025000")));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
