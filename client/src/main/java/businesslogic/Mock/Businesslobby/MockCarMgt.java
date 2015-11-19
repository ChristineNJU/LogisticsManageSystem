package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import businesslogic.Impl.Businesslobby.CarMgt;
import businesslogic.VO.CarInfoVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

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

	@Override
	public UpdateState updateCar(CarInfoVO car, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.FAIL;
	}
}
