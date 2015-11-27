package businesslogic.test.BusinessLobby;

import State.AddState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestAddCar extends TestCase {

	public void testAddCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12345", 2015); 
		assertEquals(AddState.SUCCESS,businessLobbyController.addCar(car));
	}
}
