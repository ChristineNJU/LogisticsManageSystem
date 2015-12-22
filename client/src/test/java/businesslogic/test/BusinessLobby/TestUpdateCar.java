package businesslogic.test.BusinessLobby;

import junit.framework.TestCase;
import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestUpdateCar extends TestCase {

	public void testUpdateCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12346", 2015); 
		businessLobbyController.addCar(car);
		CarInfoVO car1=new CarInfoVO("025000010", "苏A 12347", 2016); 
		assertEquals(UpdateState.SUCCESS,businessLobbyController.updateCar(car1));
		CarInfoVO car2=new CarInfoVO("025000011", "苏A 12347", 2016); 
		assertEquals(UpdateState.NOTFOUND,businessLobbyController.updateCar(car2));
		businessLobbyController.deleteCar(car1);
	}
}
