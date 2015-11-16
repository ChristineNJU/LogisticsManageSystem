package businesslogic.Impl.Businesslobby;

import java.util.ArrayList;

import businesslogic.Service.BusinessLobby.AddCarService;
import businesslogic.Service.BusinessLobby.DeleteCarService;
import businesslogic.Service.BusinessLobby.SearchCarService;
import businesslogic.Service.BusinessLobby.UpdateCarService;
import businesslogic.VO.CarInfoVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

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
