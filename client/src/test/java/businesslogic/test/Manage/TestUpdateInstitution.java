package businesslogic.test.Manage;

import State.InstitutionType;
import State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestUpdateInstitution extends TestCase {

	public void testUpdateInstitution(){
		ManageController manageController=new ManageController();

		InstitutionVO institution=new InstitutionVO("南京江宁营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		assertEquals(UpdateState.SUCCESS,manageController.UpdateInstitution(institution));
	}
}
