package businesslogic.test.Courier;

import java.util.Date;

import junit.framework.TestCase;
import State.LogisticsType;
import State.PackingCharge;
import State.UpdateState;
import VO.LogisticsInputVO;
import businesslogic.Impl.Courier.CourierController;

public class TestReceiveConfirm extends TestCase {
	
	public void testReceiveConfirm() {
		
		CourierController courier = new CourierController();
		
		assertEquals(UpdateState.SUCCESS, courier.receiveConfirm(new LogisticsInputVO("张三", "无", "无", "88888888", "1111111111111", 
				"李四", "无", "无", "99999999", "222222222222", 
				"1000000000", 2, 4, 5, "鼠标", LogisticsType.STANDARD,
				PackingCharge.COURISE_BAG, 20, "南京", "北京", 
				new Date(), new Date(),  "王五")));
	}
}
