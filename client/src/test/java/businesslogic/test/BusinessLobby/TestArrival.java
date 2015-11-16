package businesslogic.test.BusinessLobby;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestArrival extends TestCase {

	public void testArrival(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.arrival(null));
	}
}
