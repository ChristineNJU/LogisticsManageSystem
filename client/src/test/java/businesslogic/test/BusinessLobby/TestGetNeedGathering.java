package businesslogic.test.BusinessLobby;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestGetNeedGathering extends TestCase {

	public void testGetNeedGathering(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.getNeedGathering());
	}
}
