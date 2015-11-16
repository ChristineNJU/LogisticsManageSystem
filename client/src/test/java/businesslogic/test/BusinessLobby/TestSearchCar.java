package businesslogic.test.BusinessLobby;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestSearchCar extends TestCase {

	public void testSearchCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.searchCar(null));
	}
}
