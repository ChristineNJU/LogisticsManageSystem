package businesslogic.test.BusinessLobby;

import junit.framework.TestCase;
import State.AddState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestAddCar extends TestCase {

	public void testAddCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12346", 2015); 
		assertEquals(AddState.SUCCESS,businessLobbyController.addCar(car));
		assertEquals(AddState.FAIL,businessLobbyController.addCar(car));
		
		businessLobbyController.deleteCar(car);
	}
}
