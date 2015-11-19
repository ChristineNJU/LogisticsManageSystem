package businesslogic.Impl.Businesslobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Service.BusinessLobby.AddCarService;
import businesslogic.Service.BusinessLobby.DeleteCarService;
import businesslogic.Service.BusinessLobby.SearchCarService;
import businesslogic.Service.BusinessLobby.UpdateCarService;

public class CarMgt implements UpdateCarService,SearchCarService,DeleteCarService,AddCarService{

	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

}
