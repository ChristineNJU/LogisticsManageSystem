package businesslogic.test.MediumCenter;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import PO.TransferPO;
import State.AddState;
import State.DeleteState;
import VO.TransferVO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestTransfer extends TestCase {
	/**
	 * need System log
	 */
	public void testTransfer() {
		
		MediumCenterController mcc = new MediumCenterController();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			TransferVO transfer=new TransferVO(sdf.parse("2015-11-27 10:23:23"), "02502015112300001", "D0333", "南京", "上海", "0010", "张斯栋", barCodeList, 5);
			assertEquals(AddState.SUCCESS, mcc.transfer(transfer));
			assertEquals(AddState.FAIL, mcc.transfer(transfer));
			DeleteService deleteTrans=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteTrans.delete(new TransferPO(transfer,"0250")));
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
