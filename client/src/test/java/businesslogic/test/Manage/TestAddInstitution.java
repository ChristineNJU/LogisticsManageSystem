package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.AddState;
import State.DeleteState;
import State.InstitutionType;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageController;

public class TestAddInstitution extends TestCase {

	public void testAddInstitution(){
		ManageController manageController=new ManageController();
		
		InstitutionVO institution=new InstitutionVO("南京仙林营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		
		assertEquals(AddState.SUCCESS,manageController.addInstitution(institution));
		assertEquals(AddState.FAIL,manageController.addInstitution(institution));
		
		assertEquals(DeleteState.SUCCESS,manageController.deleteInstitution(institution));
	}
	
}
