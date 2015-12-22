package businesslogic.test.Courier;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import junit.framework.TestCase;
import PO.LogisticsInfoPO;
import State.DeleteState;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.LogisticsInputVO;
import businesslogic.Impl.Courier.CourierController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestReceiveConfirm extends TestCase {
	
	public void testReceiveConfirm() {
		
		CourierController courier = new CourierController();
		LogisticsInputVO logs=new LogisticsInputVO("张三", "无", "无", "88888888", "1111111111111", 
				"李四", "无", "无", "99999999", "222222222222", 
				"1000000000", 2, 4, 5, "鼠标", LogisticsType.STANDARD,
				PackingCharge.COURISE_BAG, 20, "南京", "北京", 
				new Date(), new Date(),  "王五");
		courier.addLogistics(logs);
		assertEquals(UpdateState.SUCCESS, courier.receiveConfirm(logs));
		try {
			DeleteService deleteLog=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteLog.delete(new LogisticsInfoPO(logs)));
			assertEquals(UpdateState.NOTFOUND, courier.receiveConfirm(logs));
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}
}
