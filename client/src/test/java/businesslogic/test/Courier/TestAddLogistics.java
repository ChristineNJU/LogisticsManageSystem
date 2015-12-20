package businesslogic.test.Courier;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;

import junit.framework.TestCase;
import PO.LogisticsInfoPO;
import State.AddState;
import State.DeleteState;
import State.LogisticsType;
import State.PackingCharge;
import VO.LogisticsInputVO;
import businesslogic.Impl.Courier.CourierController;
import data.RMIHelper.RMIHelper;
import data.Service.Delete.DeleteService;

public class TestAddLogistics extends TestCase {
	
	public void testAddLogistics() {
		
		CourierController courier = new CourierController();
		LogisticsInputVO logs=(new LogisticsInputVO("张三", "无", "无", "88888888", "1111111111111", 
				"李四", "无", "无", "99999999", "222222222222", 
				"1000000000", 2, 4, 5, "鼠标", LogisticsType.STANDARD,
				PackingCharge.COURISE_BAG, 20, "南京", "北京", 
				new Date(), new Date(),  "王五"));
		assertEquals(AddState.SUCCESS, courier.addLogistics(logs));
		assertEquals(AddState.FAIL, courier.addLogistics(logs));
		try {
			DeleteService deleteLo=(DeleteService) Naming.lookup(RMIHelper.DELETE_IMPL);
			assertEquals(DeleteState.SUCCESS,deleteLo.delete(new LogisticsInfoPO(logs)));
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
