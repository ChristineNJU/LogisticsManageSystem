package businesslogic.Mock.Businesslobby;

import java.util.ArrayList;

import State.AddState;
import State.DeleteState;
import State.UpdateState;
import VO.DriverInfoVO;
import businesslogic.Impl.Businesslobby.DriverMgt;

public class MockDriverMgt extends DriverMgt{

	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		return new ArrayList<DriverInfoVO>();
	}

	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value) {
		// TODO Auto-generated method stub
		return UpdateState.SUCCESS;
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return DeleteState.SUCCESS;
	}

	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return AddState.SUCCESS;
	}
}
