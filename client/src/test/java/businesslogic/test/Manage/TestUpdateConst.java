package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.UpdateState;
import VO.ConstVO;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdateConst extends TestCase {

	public void testUpdateConst(){
		ManageController manageController=new ManageController();
		
		ConstVO constvo=new ConstVO("上海到南京的距离", 20);
		assertEquals(UpdateState.SUCCESS,manageController.updateConst(constvo));
	}
}
