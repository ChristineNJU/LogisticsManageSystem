package businesslogic.test.BusinessLobby;

import junit.framework.TestCase;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestGetNeedEntrucking extends TestCase {

	public void testGetNeedEntrucking(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.getNeedEntrucking());
	}
}
