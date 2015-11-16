package businesslogic.test.BusinessLobby;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestSearchDriver extends TestCase {

	public void testSearchDriver(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.searchDriver(null));
	}
}
