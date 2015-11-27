package businesslogic.test.BusinessLobby;

import java.util.ArrayList;

import junit.framework.TestCase;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.BusinessLobbyController;

public class TestSearchCar extends TestCase {

	public void testSearchCar(){
		BusinessLobbyController businessLobbyController=new BusinessLobbyController();
		CarInfoVO car=new CarInfoVO("025000010", "苏A 12346", 2015);
		ArrayList<CarInfoVO> result=new ArrayList<CarInfoVO>();
		result.add(car);
		assertEquals(result.get(0).getCarLicense(),businessLobbyController.searchCar("025000010").get(0).getCarLicense());
	}
}
