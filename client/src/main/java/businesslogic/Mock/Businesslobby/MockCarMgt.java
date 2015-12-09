package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.CarInfoVO;
import businesslogic.Impl.Businesslobby.CarMgt;

public class MockCarMgt extends CarMgt{
	@Override
	public AddState addCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return AddState.FAIL;
	}

	@Override
	public DeleteState deleteCar(CarInfoVO car) {
		// TODO Auto-generated method stub
		return DeleteState.FAIL;
	}

	@Override
	public ArrayList<CarInfoVO> searchCar(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<CarInfoVO>();
	}

}
