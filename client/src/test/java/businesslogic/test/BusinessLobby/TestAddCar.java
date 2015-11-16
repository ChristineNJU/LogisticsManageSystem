package businesslogic.test.BusinessLobby;

import businesslogic.Impl.Businesslobby.BusinessLobbyController;

import junit.framework.TestCase;

public class TestAddCar extends TestCase {

	public void testAddCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		assertEquals(null,businessLobbyController.addCar(null));
	}
}
