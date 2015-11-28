package businesslogic.test.MediumCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import State.AddState;
import State.LogisticsState;
import VO.ArrivalVO;
import businesslogic.Impl.MediumCenter.MediumCenterController;
import junit.framework.TestCase;

public class TestArrival extends TestCase {
	/**
	 * need System log
	 */
	public void testArrival() {
		
		MediumCenterController mcc = new MediumCenterController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time="2015-11-26 11:06:06";
		
		try {
			ArrivalVO arrival=new ArrivalVO("1234567890", sdf.parse(time), "025000", "南京", LogisticsState.INTACT);
			ArrayList<ArrivalVO> arrivalList=new ArrayList<ArrivalVO>();
			arrivalList.add(arrival);
			assertEquals(AddState.SUCCESS,mcc.arrival(arrivalList));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
