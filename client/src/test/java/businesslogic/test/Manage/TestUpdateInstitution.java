package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import State.UpdateState;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageController;

public class TestUpdateInstitution extends TestCase {

	public void testUpdateInstitution(){
		ManageController manageController=new ManageController();

        InstitutionVO institution=new InstitutionVO("南京仙林营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		
		assertEquals(AddState.SUCCESS,manageController.addInstitution(institution));
		InstitutionVO institution1=new InstitutionVO("南京营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		assertEquals(UpdateState.SUCCESS,manageController.UpdateInstitution(institution1));
		assertEquals(DeleteState.SUCCESS,manageController.deleteInstitution(institution1));
		assertEquals(UpdateState.NOTFOUND,manageController.UpdateInstitution(institution1));
	}
}
