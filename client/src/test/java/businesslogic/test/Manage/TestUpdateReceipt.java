package businesslogic.test.Manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.CostType;
import State.LogisticsState;
import State.StorageArea;
import State.TransferType;
import State.UpdateState;
import VO.ArrivalVO;
import VO.BalanceVO;
import VO.CostVO;
import VO.DeliveryVO;
import VO.EntruckingVO;
import VO.GatheringVO;
import VO.RemovalVO;
import VO.StorageVO;
import VO.TransferVO;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdateReceipt extends TestCase {
	
	public void testUpdateReceipt(){
		ManageController manageController=new ManageController();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000001");
		
		try {
		ArrivalVO arrival=new ArrivalVO("1234567890", sdf.parse("2015-11-26 11:06:06"), "025000", "南京", LogisticsState.INTACT);
		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(arrival));
		
//		BalanceVO balance=new BalanceVO("0000000001", sdf.parse("2015-11-20 12:20:22"), "苏州", StorageArea.RAILWAY_TRANSPORTATION,2 , 3, 10, StorageArea.AIR_TRANSPORTATION, 2, 4, 10);
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(balance));
		
//		CostVO cost=new CostVO("2015-11-20 12:20:22", 200, "张斯栋", "张斯栋", CostType.rent, "123");
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(cost));
//		
//		DeliveryVO delivery=new DeliveryVO(sdf.parse("2015-11-12 15:34:23"), barCodeList, "张斯栋");
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(delivery));
//		
//		EntruckingVO entrucking=new EntruckingVO(sdf.parse("2015-11-23 14:22:23"),"02502015112300000" , "南京", "025000000", "张斯栋","张斯栋", barCodeList, 12.0);
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(entrucking));
//	
//		GatheringVO gathering=new GatheringVO(sdf.parse("2015-11-21 17:34:01"),204.56 , "张斯栋", barCodeList);
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(gathering));
//		
//		RemovalVO removal=new RemovalVO("0000000001", sdf.parse("2015-11-22 23:32:22"), "南京", TransferType.RAILWAY," 02502015112200000");
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(removal));
//	
//		StorageVO storage=new StorageVO("0000000001", sdf.parse("2015-11-12 18:33:30"), "南京",StorageArea.AIR_TRANSPORTATION,1,2, 5);
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(storage));
//		
//		TransferVO transfer=new TransferVO(sdf.parse("2015-11-23 02:20:21"), "02502015112300000", "D0323", "北京","南京" , "0234", "张斯栋", barCodeList, 12);
//		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(transfer));
//		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
