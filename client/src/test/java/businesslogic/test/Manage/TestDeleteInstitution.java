package businesslogic.test.Manage;

import State.DeleteState;
import State.InstitutionType;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageController;
import junit.framework.TestCase;

public class TestDeleteInstitution extends TestCase {

	public void testDeleteInstitution(){
		ManageController manageController=new ManageController();
		InstitutionVO institution=new InstitutionVO("南京江宁营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		assertEquals(DeleteState.SUCCESS,manageController.deleteInstitution(institution));
	}
}
