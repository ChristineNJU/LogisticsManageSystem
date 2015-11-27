package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import VO.ConstVO;
import businesslogic.Impl.Manage.ManageController;

public class TestAddConst extends TestCase {

	public void testAddConst(){
		ManageController manageController=new ManageController();
		
		ConstVO constvo=new ConstVO("上海到南京的距离", 200);
		assertEquals(AddState.SUCCESS,manageController.addConst(constvo));
	}
}
