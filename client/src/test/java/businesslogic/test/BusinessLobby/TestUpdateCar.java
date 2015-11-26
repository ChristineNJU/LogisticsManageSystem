package businesslogic.test.BusinessLobby;

import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;
import junit.framework.TestCase;

public class TestUpdateCar extends TestCase {

	public void testUpdateCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12346", 2015); 
		assertEquals(UpdateState.SUCCESS,businessLobbyController.updateCar(car, "carLicense", "苏A 12346"));
	}
}
