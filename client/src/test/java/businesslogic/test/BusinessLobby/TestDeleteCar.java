package businesslogic.test.BusinessLobby;

import junit.framework.TestCase;
import State.DeleteState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestDeleteCar extends TestCase {

	public void testDeleteCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12345", 2015); 
		businessLobbyController.addCar(car);
		assertEquals(DeleteState.SUCCESS,businessLobbyController.deleteCar(car));
		assertEquals(DeleteState.FAIL,businessLobbyController.deleteCar(car));
	}
}
