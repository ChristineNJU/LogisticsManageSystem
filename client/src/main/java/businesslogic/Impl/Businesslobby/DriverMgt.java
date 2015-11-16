package businesslogic.Impl.Businesslobby;

import java.util.ArrayList;

import businesslogic.Service.BusinessLobby.AddDriverService;
import businesslogic.Service.BusinessLobby.DeleteDriverService;
import businesslogic.Service.BusinessLobby.SearchDriverService;
import businesslogic.Service.BusinessLobby.UpdateDriverService;
import businesslogic.VO.DriverInfoVO;
import data.State.AddState;
import data.State.DeleteState;
import data.State.UpdateState;

public class DriverMgt implements AddDriverService,DeleteDriverService,UpdateDriverService,SearchDriverService{

	@Override
	public ArrayList<DriverInfoVO> searchDriver(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UpdateState updateDriver(DriverInfoVO driver, String field, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DeleteState deleteDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddState AddDriver(DriverInfoVO driver) {
		// TODO Auto-generated method stub
		return null;
	}

}
