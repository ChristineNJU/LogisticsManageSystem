package businesslogic.test.BusinessLobby;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
import VO.GatheringVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestGathering extends TestCase {

	public void testGathering (){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		ArrayList<String> barCodeList=new ArrayList<String>();
		barCodeList.add("0000000002");
		try {
			GatheringVO gathering=new GatheringVO(sdf.parse("2015-11-27 10:41:31"),210,"张斯,",barCodeList);
			assertEquals(AddState.SUCCESS,businessLobbyController.gathering(gathering));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
