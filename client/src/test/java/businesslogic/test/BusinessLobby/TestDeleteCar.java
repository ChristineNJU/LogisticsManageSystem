package businesslogic.test.BusinessLobby;

import State.DeleteState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestDeleteCar extends TestCase {

	public void testDeleteCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12345", 2015); 
		assertEquals(DeleteState.SUCCESS,businessLobbyController.deleteCar(car));
	}
}
