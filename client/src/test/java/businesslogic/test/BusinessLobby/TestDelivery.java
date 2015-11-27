package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
import VO.DeliveryVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import businesslogic.URLHelper.URLHelper;

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	}

