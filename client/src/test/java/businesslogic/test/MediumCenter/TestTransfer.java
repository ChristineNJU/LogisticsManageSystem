package businesslogic.test.MediumCenter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
import VO.TransferVO;
import businesslogic.Impl.MediumCenter.MediumCenterController;

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
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
