package businesslogic.test.Manage;

import java.text.SimpleDateFormat;

import junit.framework.TestCase;
import State.CostType;
import VO.CostVO;
import businesslogic.Impl.Manage.ManageController;

public class TestSearchCost extends TestCase {

	public void testSearchCost(){
		ManageController manageController=new ManageController();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CostVO cost=new CostVO("2015-11-27 19:04:05", 100, "张斯栋", "zsd", CostType.salary,"123456");
		
		assertEquals(null,manageController.searchCost("2015-11-27 17:04:05", "2015-11-27 19:04:05"));
	}
}
