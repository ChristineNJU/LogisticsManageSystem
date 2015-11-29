package businesslogic.test.Manage;

import junit.framework.TestCase;
import State.InstitutionType;
import VO.InstitutionVO;
import businesslogic.Impl.Manage.ManageController;

public class TestSearchInstituion extends TestCase {

	public void testSearchInstitution(){
		ManageController manageController=new ManageController();

		InstitutionVO institution=new InstitutionVO("南京江宁营业厅", InstitutionType.BusinessLobby, "南京", "025001");
		assertEquals(institution.getName(),manageController.searchInstitution("025001").get(0).getName());
	}
}
