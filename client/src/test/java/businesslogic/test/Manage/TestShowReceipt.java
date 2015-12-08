package businesslogic.test.Manage;

import java.util.ArrayList;

import junit.framework.TestCase;
import VO.ArrivalVO;
import VO.VO;
import businesslogic.Impl.Manage.ManageController;

public class TestShowReceipt extends TestCase {

	public void testShowReceipt(){
		ManageController manageController=new ManageController();
		
		ArrayList<VO> result = manageController.showReceipt();
		
		for(VO temp : result){
			ArrivalVO arrival = (ArrivalVO) temp;
			
			System.out.println(arrival.getListId());
		}
		//assertEquals(null,manageController.showReceipt());
	}
}
