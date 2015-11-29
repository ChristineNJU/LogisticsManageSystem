package businesslogic.test.MediumCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
