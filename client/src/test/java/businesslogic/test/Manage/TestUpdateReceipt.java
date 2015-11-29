package businesslogic.test.Manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import State.LogisticsState;
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
		
		try {
		ArrivalVO arrival=new ArrivalVO("1234567890", sdf.parse("2015-11-26 11:06:06"), "025000", "南京", LogisticsState.INTACT);
		assertEquals(UpdateState.SUCCESS,manageController.updateReceipt(arrival));
		
////		BalanceVO balance=new BalanceVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		CostVO cost=new CostVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		DeliveryVO delivery=new DeliveryVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		EntruckingVO entrucking=new EntruckingVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		GatheringVO gathering=new GatheringVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		RemovalVO removal=new RemovalVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		StorageVO storage=new StorageVO();
//		assertEquals(null,manageController.updateReceipt(null));
//		
////		TransferVO transfer=new TransferVO();
//		assertEquals(null,manageController.updateReceipt(null));
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
