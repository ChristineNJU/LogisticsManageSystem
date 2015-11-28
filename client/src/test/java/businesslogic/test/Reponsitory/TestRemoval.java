package businesslogic.test.Reponsitory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import junit.framework.TestCase;
import State.AddState;
import State.TransferType;
import VO.RemovalVO;
import businesslogic.Impl.Repository.RepositoryController;

public class TestRemoval extends TestCase {
	
	SimpleDateFormat sdf=new SimpleDateFormat("yy-MM-dd HH:mm:ss");
	
	public void testRemoval() {
		
		RepositoryController rc = new RepositoryController();
		ArrayList<RemovalVO> removal=new ArrayList<RemovalVO>();
		try {
			removal.add(new RemovalVO("1000000000", sdf.parse("2015-11-01 00:00:00"), "南京", TransferType.AIR,
					"0250012015102500001"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(AddState.SUCCESS, rc.addRemoval(removal));
	}
}
