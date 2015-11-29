package businesslogic.test.BusinessLobby;

import junit.framework.TestCase;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestGetNeedGathering extends TestCase {

	public void testGetNeedGathering(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.getNeedGathering());
	}
}
